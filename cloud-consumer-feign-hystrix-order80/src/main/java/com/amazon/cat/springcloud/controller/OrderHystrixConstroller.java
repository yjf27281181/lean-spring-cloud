package com.amazon.cat.springcloud.controller;

import com.amazon.cat.springcloud.service.PaymentHytrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_Global_Handler")
public class OrderHystrixConstroller {
    @Resource
    private PaymentHytrixService paymentHytrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String res = paymentHytrixService.paymentInfoOk(id);
        return res;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000")
//    })
//    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String res = paymentHytrixService.paymentInfoTimeout(id);
        return res;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "thread pool:" + Thread.currentThread().getName()+ " paymentInfo_TimeOutHandler, id:" + id+" (-_-)";
    }

    private String paymentInfo_Global_Handler() {
        return "this is global";
    }

}
