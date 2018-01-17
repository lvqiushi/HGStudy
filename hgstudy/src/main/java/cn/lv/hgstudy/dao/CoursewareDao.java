package cn.lv.hgstudy.dao;

import java.util.List;
import java.util.Map;

import cn.lv.hgstudy.pojo.Courseware;

public interface CoursewareDao {
	
	Courseware selectCoursewareById(String coursewardid);
	
	List<Courseware> selectCoursewareByCouid(Map map);
	
	boolean addCourseware(Courseware courseware);
	
	boolean deleteCourseware(String coursewardid);
	
	Integer selectCourswareTotal(String couid);
	
}
