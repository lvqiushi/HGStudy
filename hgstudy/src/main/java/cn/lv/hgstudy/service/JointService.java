/**   
 * @Title: JointService.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月19日 下午10:26:17 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import java.util.List;

import cn.lv.hgstudy.pojo.Joint;

/** 
 * @ClassName: JointService 
 * @Description:
 * @author lv
 * @date 2017年9月19日 下午10:26:17 
 *  
 */
public interface JointService {
	Joint selectJointByJId(Integer jointid);
	List<Joint> selectJointsByCId(Integer chapterid);
	int addJoint(Joint joint);
	int editJoint(Joint joint);
	int deleteJoint(Integer jointid);
}
