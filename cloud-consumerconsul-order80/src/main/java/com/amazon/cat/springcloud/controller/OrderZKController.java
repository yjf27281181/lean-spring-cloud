package com.amazon.cat.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yanjuefei
 * @date 2020/11/15 0015
 * @Description
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String res = restTemplate.getForObject(INVOKE_URL+ "/payment/consul", String.class);
        return res;
    }
}
