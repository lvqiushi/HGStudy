package cn.lv.hgstudy.dao;

import java.util.List;

import cn.lv.hgstudy.pojo.Joint;

public interface JointDao {
	boolean addJoint(Joint joint);
	boolean deleteJoint(int jointid);
	//
	Joint selectJointById(int jointid);
	//
	List<Joint> selectJointByCId(int chapterid);
	
	boolean editJointInfor(Joint joint);
	//
	//boolean deleteJointsByCptId(int chapterid);
}
