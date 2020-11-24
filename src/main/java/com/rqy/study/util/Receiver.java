package com.rqy.study.util;

/**
 * redis发布订阅的回调方法
 *
 * @Author renqingyang
 * @create 2020/6/18 7:56 PM
 */

import com.rqy.study.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("receiver")
public class Receiver{

    @Autowired
    private RedisService redisService;

    /**
     * 清除外部广告位本地缓存
     * @param message
     */
    public  void dealJt(String message){
        System.out.println("我是用来监听信息的");
        System.out.println(message);
    }




}

