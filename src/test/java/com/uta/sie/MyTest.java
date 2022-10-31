package com.uta.sie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uta.sie.utils.RedisCache;

/**
 * @author Jadon
 */
@SpringBootTest
public class MyTest {

    @Autowired
    private RedisCache redisCache;

    @Test
    public void mytest1(){
        final Object cacheObject = redisCache.getCacheObject("login:1");
        System.out.println(cacheObject);
    }

}
