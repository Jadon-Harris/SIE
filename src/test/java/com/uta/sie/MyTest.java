package com.uta.sie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
//        final Object cacheObject = redisCache.getCacheObject("login:1");
//        System.out.println(cacheObject);
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("1234"));
//        System.out.println(bCryptPasswordEncoder.matches("123","$2a$10$kivRZb6lJxHesKaIKSMS8.1yPFyX3.LewllTIirZxOopNA7VGdfAm"));
    }

}
