package cn.lv.hgstudy.service;

import java.util.List;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Course;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface CourseService {
	List<Course> selectHotCourses();

	List<Course> selectCompetitiveCourses(int start,int pageNumber);

	Page selectCourses(Integer start,Integer pageNumber,Integer type,Integer kind,String keyword);

	Page searchCourses(Integer start,Integer pageNumber,String keyword);

	Page selectCoursesByTeaID(String teaid,int start,int pageNumber);

	Course selectCourseByID(Integer couid);

	Boolean EditCourseImg(Integer couid,CommonsMultipartFile pic,String path);

	Boolean EditCourseInfor(Course cou);
}
