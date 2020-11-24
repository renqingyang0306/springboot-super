package com.rqy.study.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author 任清阳
 *
 * @date 20/9/18 11:18
 */
public class RedisTemplate extends StringRedisTemplate {
    public static ThreadLocal<Integer> LOCAL_DB_INDEX = new ThreadLocal<>();


    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = LOCAL_DB_INDEX.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                if (connection instanceof JedisConnection) {
                    if (((JedisConnection) connection).getNativeConnection().getDB() != dbIndex) {
                        connection.select(dbIndex);
                    }
                } else {
                    connection.select(dbIndex);
                }
            } else {
                connection.select(0);
            }
        } finally {
            LOCAL_DB_INDEX.remove();
        }

        return super.preProcessConnection(connection, existingConnection);
    }

}
