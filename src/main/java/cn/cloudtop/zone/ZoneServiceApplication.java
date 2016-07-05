package cn.cloudtop.zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@ComponentScan(value = {"cn.cloudtop.strawberry.service", "cn.cloudtop.zone"})
public class ZoneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoneServiceApplication.class, args);
    }
}
