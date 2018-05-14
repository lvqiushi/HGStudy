package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.enums.VideoUploadEnum;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private static final int BUFFER_SIZE = 100 * 1024;
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
	public String UploadVideo(Model model, @RequestParam MultipartFile upload, HttpServletRequest request, HttpSession session){
		try {
			Long times = System.currentTimeMillis();
			String name = request.getParameter("name");
			Integer chunk = 0, chunks = 0;
			if(null != request.getParameter("chunk") && !request.getParameter("chunk").equals("")){
				chunk = Integer.valueOf(request.getParameter("chunk"));
			}
			if(null != request.getParameter("chunks") && !request.getParameter("chunks").equals("")){
				chunks = Integer.valueOf(request.getParameter("chunks"));
			}
			//logger.info("chunk:[" + chunk + "] chunks:[" + chunks + "]");
			//检查文件目录，不存在则创建
			String realPath = session.getServletContext().getRealPath("/video");
			File folder = new File(realPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			String videoName = times + ".mp4";
			//目标文件
			File destFile = new File(folder, name);
			//文件已存在删除旧文件（上传了同名的文件）
			if (chunk == 0 && destFile.exists()) {
				destFile.delete();
				destFile = new File(folder, name);
			}
			//合成文件
			appendFile(upload.getInputStream(), destFile);
			if (chunk == chunks - 1) {
				//logger.info("上传完成");
			}else {
				return "upload_video_result";
				//logger.info("还剩["+(chunks-1-chunk)+"]个块文件");
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return "upload_video_result";
	}

	/*    
	 * <p> 确认上传视频 </p>
	 *
	 * @param [jointId, operte, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/submitUpload")
	public String submitUpload(Integer jointId,Integer operte,Model model, HttpServletRequest request, HttpSession session){
		try {
			String uploadFileName = request.getParameter("uploader_0_name");
			String path = request.getParameter("uploader_0_tmpname");
//			Long times = System.currentTimeMillis();
//			Date d = new Date(times);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(VideoUploadEnum.UPLOAD.getCode().equals(operte)) {
				Video vid = new Video();
				vid.setVidPath(path);
				vid.setJointid(jointId);
				vid.setVidName(uploadFileName);

				videoService.uploadVideo(vid);
			}
			if(VideoUploadEnum.RE_UPLOAD.getCode().equals(operte)){
				Video video = videoService.selectVideo(jointId);
				video.setVidPath(path);
				video.setVidName(uploadFileName);
				videoService.updateVideo(video);
			}
			String result = "";
			int count = Integer.parseInt(request.getParameter("uploader_count"));
			for (int i = 0; i < count; i++) {
				String temFile = request.getParameter("uploader_" + i + "_name");
				String temName = request.getParameter("uploader_" + i + "_tmpname");
				try {
					//do something with file;
					result += uploadFileName + "导入完成. <br />";
				} catch (Exception e) {
					result += uploadFileName + "导入失败:" + e.getMessage() + ". <br />";
					e.printStackTrace();
				}
			}
			model.addAttribute("result",result);

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
			model.addAttribute("msg","删除课程视频成功");
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
				if(Objects.nonNull(video) && !StringUtils.isEmpty(video.getVidPath())) {
					model.addAttribute("video", video);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "video_play";
	}

	private void appendFile(InputStream in, File destFile) {
		OutputStream out = null;
		try {
			// plupload 配置了chunk的时候新上传的文件append到文件末尾
			if (destFile.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(destFile, true), BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(destFile),BUFFER_SIZE);
			}
			in = new BufferedInputStream(in, BUFFER_SIZE);

			int len = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if(null != out){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
