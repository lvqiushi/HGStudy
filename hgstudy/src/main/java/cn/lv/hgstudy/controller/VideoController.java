package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.pojo.Joint;
import cn.lv.hgstudy.pojo.Video;
import cn.lv.hgstudy.service.JointService;
import cn.lv.hgstudy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/26 11:08   
 * @since V1.0
 */
@Controller
public class VideoController {
	@Autowired
	VideoService videoService;
	@Autowired
	JointService jointService;

	@RequestMapping(value = "/toVideoManage")
	public String toManage(Integer jointId,Model model){
		try {
			Video video = videoService.selectVideo(jointId);
			if(Objects.nonNull(video)){
				Joint joint = jointService.selectJointByJId(jointId);
				model.addAttribute("video",video);
				model.addAttribute("joint",joint);
			}
			else {
				model.addAttribute("jointId",jointId);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_manage";
	}

	@RequestMapping(value = "/toUploadVideo")
	public String toUploadVideo(Integer jointId,Integer operte,Model model){
		try {

		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/delVideo")
	public String delVideo(Integer videoId,Model model){
		try {
			videoService.delVideo(videoId);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_manage";
	}

	@RequestMapping(value = "/reUploadVideo")
	public String reUploadVideo(Integer videoId,Model model){

		return null;
	}
}