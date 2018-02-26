package cn.lv.hgstudy.service.imp;

import cn.lv.hgstudy.dao.StuAttDao;
import cn.lv.hgstudy.pojo.StuAttention;
import cn.lv.hgstudy.service.StuAttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/26 14:04   
 * @since V1.0
 */
@Service
public class StuAttServiceImpl implements StuAttService{
	@Autowired
	StuAttDao stuAttDao;

	@Override
	public Boolean AttCourse(String userId,Integer couId) {
		StuAttention stuAttention = new StuAttention();
		stuAttention.setCouId(couId);
		stuAttention.setUserId(userId);
		return stuAttDao.addAttention(stuAttention);
	}

	@Override
	public Boolean cancelAtt(String userId,Integer couId) {
		StuAttention stuAttention = new StuAttention();
		stuAttention.setCouId(couId);
		stuAttention.setUserId(userId);
		return stuAttDao.delAttention(stuAttention);
	}

	@Override
	public Integer selectAttention(String userId, Integer couId) {
		StuAttention stuAttention = new StuAttention();
		stuAttention.setCouId(couId);
		stuAttention.setUserId(userId);
		return stuAttDao.selectAttention(stuAttention);
	}
}
