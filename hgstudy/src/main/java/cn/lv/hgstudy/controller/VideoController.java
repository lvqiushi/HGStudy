package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.pojo.Chapter;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.pojo.Joint;
import cn.lv.hgstudy.pojo.Video;
import cn.lv.hgstudy.service.ChapterService;
import cn.lv.hgstudy.service.CourseService;
import cn.lv.hgstudy.service.JointService;
import cn.lv.hgstudy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
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
	@Resource
	ChapterService chapterService;
	@Autowired
	CourseService courseService;

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
			model.addAttribute("jointId",jointId);
			model.addAttribute("operte",operte);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_upload";
	}

	/*    
	 * <p> 上传视频 </p>
	 *
	 * @param [jointId, operte, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/UploadVideo")
	public String UploadVideo(Integer jointId,Integer operte,Model model){
		try {
			model.addAttribute("result",operte);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "upload_video_result";
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

	/*    
	 * <p> 跳转到播放视频页面 </p>
	 *
	 * @param [jointId, operte, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/toPlayVideo")
	public String toplayVideo(Integer couid,Model model){
		try {
			List<Chapter> chapters = chapterService.selectChaptersByCouId(couid);
			Course cou = courseService.selectCourseByID(couid);
			Integer playVideoId = 0;
			if(!CollectionUtils.isEmpty(chapters) && !CollectionUtils.isEmpty(chapters.get(0).getJoints())) {
				playVideoId = ((Joint) chapters.get(0).getJoints().get(0)).getJid();
			}
			model.addAttribute("chapters", chapters);
			model.addAttribute("course", cou);
			model.addAttribute("playVideoId", playVideoId);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_play_index";
	}

	/*    
	 * <p> 播放视频 </p>
	 *
	 * @param [jointId, operte, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/PlayVideo")
	public String playVideo(Integer jointId,Model model){
		try {
			if(null != jointId && 0 != jointId) {
				Video video = videoService.selectVideo(jointId);
				model.addAttribute("video", video);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_play";
	}
}
