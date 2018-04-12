package cn.lv.hgstudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/11 14:34   
 * @since V1.0
 */
@Configuration
public class RedisConfig {

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
	@Value("${redis.pool.max-wait}")
	private long maxWaitMillis;
	@Value("${redis.pool.max-active}")
	private int maxActive;

	@Bean
	public JedisPool redisPoolFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setMaxTotal(maxActive);
		return new JedisPool(jedisPoolConfig, host, port, timeout, password);
	}
}
