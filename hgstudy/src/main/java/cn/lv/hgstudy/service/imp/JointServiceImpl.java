/**   
 * @Title: JointServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月19日 下午10:41:13 
 * @version V1.0   
 */
package cn.lv.hgstudy.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.JointService;
import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.JointDao;
import cn.lv.hgstudy.pojo.Joint;

/** 
 * @ClassName: JointServiceImp 
 * @Description:
 * @author lv
 * @date 2017年9月19日 下午10:41:13 
 *  
 */
@Service
public class JointServiceImpl implements JointService {
	@Resource
	JointDao jointdao;

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#selectJointByJId(int)
	 */
	@Override
	public Joint selectJointByJId(Integer jointid) {
		return jointdao.selectJointById(jointid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#selectJointsByCouid(java.lang.String)
	 */
	@Override
	public List<Joint> selectJointsByCId(Integer chapterid) {
		return jointdao.selectJointByCId(chapterid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#addJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	@Override
	public String addJoint(Joint joint) {
		Map map = new HashMap<String, Object>();
		map.put("chapterid", joint.getChapterid());
		map.put("index", joint.getJointIndex());
		// 已经存在该小节不能添加
		if(jointdao.selectJointByIndex(map)){
			return "已经存在该小节，不能重复添加";
		}

		else{
			jointdao.addJoint(joint);
			return "添加小节成功";
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#editJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	@Override
	public int editJoint(Joint joint) {
		jointdao.editJointInfor(joint);
		return 1;
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#deleteJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	@Override
	public int deleteJoint(Integer jointid) {
		jointdao.deleteJoint(jointid);
		return 1;
	}

}
