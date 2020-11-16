package com.amazon.cat.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "thread pool:" + Thread.currentThread().getName()+ " paymentInfoOk, id:" + id;
    }

    public String paymentInfoTimeout(Integer id) {
        int timeout = 10;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread pool:" + Thread.currentThread().getName()+ " paymentInfoOk, id:" + id+" running time:"+timeout;
    }
}
