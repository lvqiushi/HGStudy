package cn.lv.hgstudy.service;

import cn.lv.hgstudy.pojo.Joint;

import java.util.List;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com）
 * @date: 2018/1/11 15:28  
 * @since V1.0
 */
public interface JointService {
	Joint selectJointById(Integer id);

	List<Joint> selectJointByCId(Integer chapterId);

	Boolean deleteJoint(Integer id);

	Boolean addJoint(Joint joint);

	Boolean editJointInfor(Joint joint);
}
