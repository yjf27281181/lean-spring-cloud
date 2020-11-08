package com.amazon.cat.springcloud.service;

import com.amazon.cat.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanjuefei
 * @date 2020/11/7 0007
 * @Description
 */
public interface PaymentService {
    int create(Payment payment) ;

    Payment getPaymentById(@Param("id") Long id);
}
