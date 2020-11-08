package com.amazon.cat.springcloud.controller;

import com.amazon.cat.springcloud.entities.CommonResult;
import com.amazon.cat.springcloud.entities.Payment;
import com.amazon.cat.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping(value = "/payment")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******insert result:", result);

        if (result > 0) {
            return new CommonResult(200, "insert successful", result);
        } else {
            return new CommonResult(500, "insert failed");
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******insert result:", payment);

        if (payment != null) {
            return new CommonResult(200, "select successful", payment);
        } else {
            return new CommonResult(500, "select failed");
        }
    }
}
