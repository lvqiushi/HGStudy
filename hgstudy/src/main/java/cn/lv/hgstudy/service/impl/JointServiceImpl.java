package cn.lv.hgstudy.service.impl;

import cn.lv.hgstudy.dao.JointDao;
import cn.lv.hgstudy.pojo.Joint;
import cn.lv.hgstudy.service.JointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/1/12 09:59   
 * @since V1.0
 */
@Service
public class JointServiceImpl implements JointService{
	@Autowired
	JointDao jointDao;

	@Override
	public Joint selectJointById(Integer id) {
		return jointDao.selectJointById(id);
	}

	@Override
	public List<Joint> selectJointByCId(Integer chapterId) {
		return jointDao.selectJointByCId(chapterId);
	}

	@Override
	public Boolean deleteJoint(Integer id) {
		return jointDao.deleteJoint(id);
	}

	@Override
	public Boolean addJoint(Joint joint) {
		return jointDao.addJoint(joint);
	}

	@Override
	public Boolean editJointInfor(Joint joint) {
		return jointDao.editJointInfor(joint);
	}
}
