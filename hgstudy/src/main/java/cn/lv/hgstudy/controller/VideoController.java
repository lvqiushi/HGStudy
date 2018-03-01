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

	/*     
	 * <p> 跳转到视频管理页面 </p>
	 * 
	 * @param [jointId, model]
	 * @return java.lang.String 
	 */
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

	/*     
	 * <p> 跳转到上传视频页面 </p>
	 * 
	 * @param [jointId, operte, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toUploadVideo")
	public String toUploadVideo(Integer jointId,Integer operte,Model model){
		try {

		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/*     
	 * <p> 删除视频 </p>
	 * 
	 * @param [videoId, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/delVideo")
	public String delVideo(Integer videoId,Model model){
		try {
			videoService.delVideo(videoId);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_manage";
	}

	/*     
	 * <p> 重新上传视频 </p>
	 * 
	 * @param [videoId, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/reUploadVideo")
	public String reUploadVideo(Integer videoId,Model model){

		return null;
	}
}
