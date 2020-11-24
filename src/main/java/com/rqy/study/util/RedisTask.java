package com.rqy.study.util;

import com.rqy.study.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务demo，最大核心线程数在config配置
 *
 * @Author renqingyang
 * @create 2020/6/19 3:03 PM
 */
@Component
public class RedisTask {

    @Autowired
    private RedisService redisService;


    private Logger logger = LoggerFactory.getLogger(RedisTask.class);

//    @Scheduled(initialDelay = 3000,fixedDelay = 10000)
//    public void operate(){
//        logger.info("-----------------定时任务开始执行--------------------");
//            //读取队列信息
//            try{
//
//                Object ceshi = redisService.lpop(0,"ceshi");
//                if (!Objects.isNull(ceshi)) {
//                    System.out.println("任务消费了：{}" + ceshi.toString());
//                }
//
//            }catch (Exception e){
//                logger.error("定时任务失败：{} ", e);
//            }
//    }
}
