package com.amazon.cat.springcloud.service.impl;


import com.amazon.cat.springcloud.dao.PaymentDao;
import com.amazon.cat.springcloud.entities.Payment;
import com.amazon.cat.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanjuefei
 * @date 2020/11/7 0007
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao  paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
