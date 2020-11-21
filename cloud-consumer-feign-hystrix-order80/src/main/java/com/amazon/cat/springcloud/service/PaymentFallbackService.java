package com.amazon.cat.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHytrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "-----PaymentFallbackService paymentInfoOk ";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-----PaymentFallbackService paymentInfoTimeout ";
    }
}
