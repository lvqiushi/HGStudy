package cn.lv.hgstudy.test;

import redis.clients.jedis.Jedis;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/10 20:44   
 * @since V1.0
 */
public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println("value=" + value);
	}



}
