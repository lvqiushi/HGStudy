/**   
 * @Title: JointServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月19日 下午10:41:13 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.JointDao;
import cn.lv.hgstudy.pojo.Joint;

/** 
 * @ClassName: JointServiceImp 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月19日 下午10:41:13 
 *  
 */
@Service
public class JointServiceImp implements JointService{
	@Resource
	JointDao jointdao;
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#selectJointByJId(int)
	 */
	public Joint selectJointByJId(Integer jointid) {
		// TODO Auto-generated method stub
		return jointdao.selectJointById(jointid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#selectJointsByCouid(java.lang.String)
	 */
	public List<Joint> selectJointsByCId(Integer chapterid) {
		// TODO Auto-generated method stub
		return jointdao.selectJointByCId(chapterid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#addJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	public int addJoint(Joint joint) {
		// TODO Auto-generated method stub
		Map map = new HashMap<String, Object>();
		map.put("chapterid", joint.getChapterid());
		map.put("index", joint.getJointIndex());
		if(jointdao.selectJointByIndex(map)){
			System.out.println("存在");
			
			return 1;
		}
		// 已经存在该小节不能添加
		else{
			System.out.println("不存在");
			jointdao.addJoint(joint);
			return 2;
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#editJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	public int editJoint(Joint joint) {
		// TODO Auto-generated method stub
		jointdao.editJointInfor(joint);
		return 1;
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.JointService#deleteJoint(cn.lv.hgstudy.pojo.Joint)
	 */
	public int deleteJoint(Integer jointid) {
		// TODO Auto-generated method stub
		jointdao.deleteJoint(jointid);
		return 1;
	}

}
