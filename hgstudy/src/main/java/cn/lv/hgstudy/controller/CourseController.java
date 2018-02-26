package cn.lv.hgstudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.lv.hgstudy.enums.AttentionEnum;
import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.service.StuAttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.service.imp.CourseServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
	@Resource
	CourseServiceImpl courseService;
	@Autowired
	StuAttService stuAttService;

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

		model.addAttribute("kind", kind);
		model.addAttribute("type", type);
        return "all_course";
    }
	
	@RequestMapping(value = "/selectCourseInfor")
    public String showCourseInfor(Integer couid,Model model,HttpSession session){
    	try {
			String type = (String) session.getAttribute("userType");
			Course course = courseService.selectCourseByID(couid);
			model.addAttribute("cou", course);
			if("student".equals(type)) {
				Student student = (Student) session.getAttribute("user");
				if(stuAttService.selectAttention(student.getStuId(),couid) > 0){
					model.addAttribute("statu", AttentionEnum.CANCEL.getCode());
				}
				else {
					model.addAttribute("statu", AttentionEnum.ATTENTION.getCode());
				}
			}
		}catch (Exception e){
    		e.printStackTrace();
		}
        return "course_detail";
    }

	@RequestMapping(value = "/toEditCourseInfor")
	public String toEditCourseIndex(Integer couid,Model model){

		Course course = courseService.selectCourseByID(couid);
		model.addAttribute("cou", course);
		model.addAttribute("couid", couid);
		return "edit_course_infor";
	}

	@RequestMapping(value = "/editCourseInfor")
	public String editCourseInfor(Course cou,Model model){
		boolean b = courseService.EditCourseInfor(cou);
		//model.addAttribute("cou", course);

		return "redirect:/toEditCourse?couid="+cou.getCouId();
	}
}
