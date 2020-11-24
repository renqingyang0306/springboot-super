package com.rqy.study.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


/**
 * redis发布订阅的配置
 *
 * @Author renqingyang
 * @create 2020/6/18 7:53 PM
 */

@Configuration
public class RedisMsgListener {

    @Autowired
    Receiver receiver;//监听方法，用于接收消息

    /**
     * redis消息队列监听信息
     *
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(@Qualifier("factory") RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("dealFaBuDingYue"));//topic=dealFaBuDingYue
        return container;
    }

    /**
     * 监听方法
     *
     * @return
     */
    @Bean(name = "listenerAdapter")
    MessageListenerAdapter listenerAdapter() {
        // 回调数据处理方法
        return new MessageListenerAdapter(receiver, "dealJt");
    }
}

