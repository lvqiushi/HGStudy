package cn.lv.hgstudy.controller;

import java.util.List;

import javax.annotation.Resource;

import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.pojo.Live;
import cn.lv.hgstudy.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.service.imp.CourseServiceImpl;

@Controller
public class IndexController {

	@Resource
	private CourseServiceImpl courseService;
	@Autowired
	private LiveService liveService;
	
	@RequestMapping(value = "/index")
    public String index(Model model){
		try {
			List courses = courseService.selectCompetitiveCourses(0, 8);
			List lives = liveService.selectAll(0,8).getContents();
			List<Course> hotCourses = courseService.selectHotCourses();
			Course jsj = hotCourses.get(0);
			model.addAttribute("jsj",jsj);
			Course wy = hotCourses.get(1);
			model.addAttribute("wy",wy);
			Course gx = hotCourses.get(2);
			model.addAttribute("gx",gx);
			Course wx = hotCourses.get(3);
			model.addAttribute("wx",wx);
			Course lx = hotCourses.get(4);
			model.addAttribute("lx",lx);

			model.addAttribute("courses", courses);
			model.addAttribute("lives",lives);
		}
		catch (Exception e){
			e.printStackTrace();
		}
        return "index";
    }
}
