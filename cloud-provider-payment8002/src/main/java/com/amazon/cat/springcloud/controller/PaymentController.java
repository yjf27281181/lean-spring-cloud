package com.amazon.cat.springcloud.controller;

import com.amazon.cat.springcloud.entities.CommonResult;
import com.amazon.cat.springcloud.entities.Payment;
import com.amazon.cat.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yanjuefei
 * @date 2020/11/7 0007
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******insert result:", result);

        if (result > 0) {
            return new CommonResult(200, "insert successful, port: "+serverPort, result);
        } else {
            return new CommonResult(500, "insert failed");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******insert result:", payment);

        if (payment != null) {
            return new CommonResult(200, "select successful, port"+serverPort, payment);
        } else {
            return new CommonResult(500, "select failed");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        discoveryClient.getServices().forEach(log::info);
        discoveryClient
                .getInstances("CLOUD-PAYMENT-SERVICE")
                .forEach((instance) -> log.info(instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri()));

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
