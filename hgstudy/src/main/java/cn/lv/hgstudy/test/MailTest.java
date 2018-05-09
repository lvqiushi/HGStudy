package cn.lv.hgstudy.test;

import cn.lv.hgstudy.enums.EmailTypeEnum;
import cn.lv.hgstudy.model.UserMailInfo;
import cn.lv.hgstudy.util.SendMailUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/11 18:55   
 * @since V1.0
 */
public class MailTest {
	public static void main(String[] args) {
		List<UserMailInfo> userInfos = new ArrayList<>();
		UserMailInfo user1= new UserMailInfo();
		user1.setUserName("吕秋实");
		user1.setUserMailAdress("578915614@qq.com");
//		UserMailInfo user2= new UserMailInfo();
//		user2.setUserName("宫本");
//		user2.setUserMailAdress("291051194@qq.com");

		userInfos.add(user1);
		//userInfos.add(user2);
		try {
			SendMailUtil.sendMail(EmailTypeEnum.PUB_MESSAGE.getType(),"测试内容",userInfos,"淮工网教平台");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
