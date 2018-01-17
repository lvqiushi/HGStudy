package cn.lv.hgstudy.dao;

import java.util.List;
import java.util.Map;

import cn.lv.hgstudy.pojo.Joint;

public interface JointDao {
	boolean addJoint(Joint joint);
	boolean deleteJoint(Integer jointid);
	//
	Joint selectJointById(Integer jointid);
	
	boolean selectJointByIndex(Map map);
	//
	List<Joint> selectJointByCId(Integer chapterid);
	
	boolean editJointInfor(Joint joint);
	//
	//boolean deleteJointsByCptId(int chapterid);
}
