package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/11 14:55   
 * @since V1.0
 */
@Controller
public class TestController {

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping(value = "/test")
	@ResponseBody
	public String toEditCourseIndex(){
		redisUtil.set("foo", "bar");
		return redisUtil.getString("foo");
	}
}
