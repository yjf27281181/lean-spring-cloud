package com.amazon.cat.springcloud.dao;

import com.amazon.cat.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanjuefei
 * @date 2020/11/7 0007
 * @Description
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment) ;

    Payment getPaymentById(@Param("id") Long id);
}
