package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.pojo.Live;
import cn.lv.hgstudy.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/19 16:38   
 * @since V1.0
 */
@Controller
public class LiveController {
	@Autowired
	LiveService liveService;

	@RequestMapping(value = "/toLiveRoom")
	public String showCourseInfor(Integer id,Model model){
//		Live live = liveService.selectById(id);
//		model.addAttribute("live",live);
		return "live_room";
	}
}
