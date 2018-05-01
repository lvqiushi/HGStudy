package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.common.JsonResult;
import cn.lv.hgstudy.enums.UrlEnum;
import cn.lv.hgstudy.pojo.Live;
import cn.lv.hgstudy.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private LiveService liveService;

	@RequestMapping(value = "/toLiveRoom")
	public String toLiveRoom(Integer id,Model model){
		Live live = liveService.selectById(id);
		model.addAttribute("live",live);
		model.addAttribute("url", UrlEnum.LIVE_URL.getDesc()+"/"+live.getRoomName());
		return "live_room";
	}

	@RequestMapping(value = "/startLive")
	@ResponseBody
	public JsonResult startLive(Integer liveId){
		JsonResult result = new JsonResult();
		liveService.openLive(liveId);
		return result;
	}

	@RequestMapping(value = "/closeLive")
	@ResponseBody
	public JsonResult closeLiveRoom(Integer liveId){
		JsonResult result = new JsonResult();
		liveService.exitLive(liveId);
		return result;
	}
}
