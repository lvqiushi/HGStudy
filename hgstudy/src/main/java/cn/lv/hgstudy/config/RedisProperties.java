package cn.lv.hgstudy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 *
 * 读取redis的配置
 */

public class RedisProperties {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.max-wait}")
    private long maxWaitMillis;
    @Value("${redis.max-active}")
    private int maxActive;

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public String getHost() {
        return host;
    }
}
