package cn.lv.hgstudy.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.CourseService;
import org.springframework.stereotype.Service;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.dao.CourseDao;
import cn.lv.hgstudy.pojo.Course;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @ClassName: CourseServiceImp 
 * @Description:
 * @author lv
 * @date 2017年9月12日 下午7:22:27 
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
	
	@Resource
	CourseDao cdao;

	@Override
	public List<Course> selectHotCourses() {
		List courses = new ArrayList<Course>();
		
		for(int i=1;i<6;i++){			
			Course cou = cdao.selectHotCourse(i);
			courses.add(cou);
		}
		return courses;
	}

	@Override
	public List<Course> selectCompetitiveCourses(int start,int pageNumber) {
		List courses = new ArrayList<Course>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		map.put("sort", "cou.evaluate");
		courses = cdao.selectCourses(map);
		return courses;
	}

	@Override
	public Page selectCoursesByTeaID(String teaid,int start,int pageNumber) {
		List courses = new ArrayList<Course>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		map.put("teaid", teaid);
		courses = cdao.selectCourses(map);
		int total = cdao.selectCoursesTotal(map);
		Page page = new Page(total, start, pageNumber);
		page.setContents(courses);
		return page;
	}

	@Override
	public Boolean EditCourseInfor(Course cou) {
		return cdao.editCourseInfor(cou);
	}

	@Override
	public Course selectCourseByID(Integer couid) {
		return cdao.selectCourseById(couid);
	}

	@Override
	public Boolean EditCourseImg(Integer couid,CommonsMultipartFile pic,String path) {
		System.out.println("paht "+path);
		Boolean success = false;
		Course cou = new Course();
		String fileName = pic.getOriginalFilename();
		String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
		String filename = couid+System.currentTimeMillis()+"."+prefix;
		File newFile=new File(path+File.separator+filename);
		cou.setCouId(couid);
		cou.setCouImg("courseimage"+File.separator+filename);
		try {
			pic.transferTo(newFile);
			success = cdao.editCourseInfor(cou);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Page selectCourses(Integer start, Integer pageNumber, Integer type,
			Integer kind,String keyword) {
		List courses = new ArrayList<Course>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		map.put("keyword",keyword);
		if(null != type && type > 0){
			map.put("type", type);
		}
		if(null != kind){
			if(kind==1){
				map.put("sort", "cou.evaluate");
			}
			if(kind==2){
				map.put("sort", "cou.create_time");
			}			
		}
		courses = cdao.selectCourses(map);
		int total = cdao.selectCoursesTotal(map);

		Page page = new Page(total, start, pageNumber);
		page.setContents(courses);
		return page;
	}

	@Override
	public Page searchCourses(Integer start, Integer pageNumber,String keyword) {
		List courses = new ArrayList<Course>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		map.put("keyword",keyword);
		map.put("sort", "cou.create_time");

		courses = cdao.selectCourses(map);
		int total = cdao.selectCoursesTotal(map);

		Page page = new Page(total, start, pageNumber);
		page.setContents(courses);
		return page;
	}

}
