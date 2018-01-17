package cn.lv.hgstudy.dao;

import java.util.List;
import java.util.Map;

import cn.lv.hgstudy.pojo.Course;

public interface CourseDao {
	Course selectCourseById(String couid);
	//
	List<Course> selectCourses(Map<String,Object> map);
	
	int selectCoursesTotal(Map<String,Object> map);
	//
	//List<Course> selectCoursesByTeaId(Map<String,Object> map);
	//
	Course selectHotCourse(int type);
	
	//
	boolean editCourseInfor(Course cou);

	//
	boolean deleteCourseById(String couid);
	//
	//boolean changeTeacher();
}
