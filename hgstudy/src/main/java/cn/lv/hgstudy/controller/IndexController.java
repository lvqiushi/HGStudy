package cn.lv.hgstudy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.service.imp.CourseServiceImpl;

@Controller
public class IndexController {

	@Resource CourseServiceImpl courseService;
	
	@RequestMapping(value = "/index")
    public String index(Model model){
		List courses = courseService.selectCompetitiveCourses(0, 8);
		model.addAttribute("courses", courses);
        return "index";
    }
}
