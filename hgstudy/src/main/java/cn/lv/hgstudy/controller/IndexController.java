package cn.lv.hgstudy.controller;

import java.util.List;

import javax.annotation.Resource;

import cn.lv.hgstudy.pojo.Live;
import cn.lv.hgstudy.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.service.imp.CourseServiceImpl;

@Controller
public class IndexController {

	@Resource CourseServiceImpl courseService;
	@Autowired LiveService liveService;
	
	@RequestMapping(value = "/index")
    public String index(Model model){
		try {
			List courses = courseService.selectCompetitiveCourses(0, 8);
			List lives = liveService.selectAll(0,8).getContents();
			model.addAttribute("courses", courses);
			model.addAttribute("lives",lives);
		}
		catch (Exception e){
			e.printStackTrace();
		}
        return "index";
    }
}
