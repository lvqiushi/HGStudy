package cn.lv.hgstudy.service;

import java.util.List;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Course;

public interface CourseService {
	List<Course> selectHotCourses();

	List<Course> selectCompetitiveCourses(int start,int pageNumber);

	Page selectCourses(Integer start,Integer pageNumber,Integer type,Integer kind);

	Page selectCoursesByTeaID(String teaid,int start,int pageNumber);

	Course selectCourseByID(Integer couid);

	boolean EditCourseInfor(Course cou);
}
