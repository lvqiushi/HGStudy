package cn.lv.hgstudy.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
	@Resource CourseServiceImpl courseService;
	//分页时每页数量
	private int pageNumber = 6;
	
	@RequestMapping(value = "/selectCourses")
    public String index(Integer curpage,
			@RequestParam(value = "type", required = false, defaultValue = "0")Integer type,
			@RequestParam(value = "kind", required = false, defaultValue = "1")Integer kind,
			Model model){
		if(null==curpage || curpage<1){
			curpage=1;
		}
		Page courses = courseService.selectCourses((curpage-1)*pageNumber, pageNumber, type, kind);
		model.addAttribute("pagebean", courses);

//		if(null==kind){
//			kind=1;
//		}
//		if(null==type ){
//			type=0;
//		}
		model.addAttribute("kind", kind);
		model.addAttribute("type", type);
		return "all_course";
    }
	
	@RequestMapping(value = "/selectCourseInfor")
    public String showCourseInfor(String couid,Model model){
		
		Course course = courseService.selectCourseByID(couid);
		model.addAttribute("cou", course);

        return "course_detail";
    }
}
