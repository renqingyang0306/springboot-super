package com.rqy.study.controller;

import com.rqy.study.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试 controller
 *
 * @Author renqingyang
 * @create 2020/9/18 5:21 PM
 */
@Slf4j
@RestController
@RequestMapping("/super")
public class SuperController {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @RequestMapping(value = "/test12", produces = {"application/json;charset=UTF-8;"})
    public RestResponse test(){

        Future<String> future = threadPoolTaskExecutor.submit(this::callBack);
        String s = "";
        try {
            s = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  new RestResponse(s);
    }


    public String callBack(){
        return "test";
    }
}
