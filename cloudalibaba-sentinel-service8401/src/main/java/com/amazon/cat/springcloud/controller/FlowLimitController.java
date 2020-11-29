package com.amazon.cat.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----testB";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        log.info("testD exception");
        throw new RuntimeException();
//        return "----testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handle_testHotKey")
    public String testHotKeytg(@RequestParam(value="p1", required = false) String p1,
                               @RequestParam(value="p2", required = false) String p2) {
        return "test hotkey";
    }

    public String handle_testHotKey(String p1, String p2, BlockException exception) {
        return "handle_testHotKey";
    }
}
