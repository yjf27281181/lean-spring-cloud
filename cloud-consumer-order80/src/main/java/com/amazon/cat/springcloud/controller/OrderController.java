package com.amazon.cat.springcloud.controller;

import com.amazon.cat.springcloud.entities.CommonResult;
import com.amazon.cat.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yanjuefei
 * @date 2020/11/8 0008
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id, CommonResult.class);
    }
}
