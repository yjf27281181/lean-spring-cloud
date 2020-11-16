package com.amazon.cat.robbin;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanjuefei
 * @date 2020/11/15 0015
 * @Description
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }
}
