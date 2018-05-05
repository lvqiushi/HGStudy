/**   
 * @Title: ChapterController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月19日 下午10:23:01 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.pojo.Chapter;
import cn.lv.hgstudy.service.ChapterService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/** 
 * @ClassName: ChapterController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月19日 下午10:23:01 
 *  
 */
@Controller
public class ChapterController {
	@Resource
	ChapterService chapterService;
	
	/*     
	 * <p> 跳转到新增章节页面 </p>
	 * 
	 * @param [model, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toAddChapter")
	public String toAddChapter(Model model,String couid){
		model.addAttribute("couid", couid);
		return "add_zhangjie";
	}
	
	/*     
	 * <p> 新增章节 </p>
	 * 
	 * @param [model, chapter]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/AddChapter")
	public String AddChapter(Model model,Chapter chapter) throws UnsupportedEncodingException{
		String msg = "";
		if(chapterService.addChapter(chapter)) {
			msg = "新增章节成功";
		}
		else {
			msg = "该章节已经存在，不能重复添加";
		}
		//String url = "redirect:/toEditCourse?couid="+chapter.getCouId() + "&msg=" + msg;
		String newMsg = URLEncoder.encode(msg, "UTF-8");
		return "redirect:/toEditCourse?couid="+chapter.getCouId() + "&msg=" + newMsg;
	}
	
	/*     
	 * <p> 跳转到编辑章节页面 </p>
	 * 
	 * @param [model, chapterId]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toEditChapter")
	public String toEditChapter(Model model,Integer chapterId){
		Chapter chapter = chapterService.selectChapterByCId(chapterId);
		model.addAttribute("chapter", chapter);
		return "edit_zhangjie";
	}
	
	/*     
	 * <p> 编辑章节 </p>
	 * 
	 * @param [model, chapter]
	 * @return java.lang.String 
	 */
	@RequestMapping(value= "/editChapter")
	public String EditChapter(Model model,Chapter chapter) throws UnsupportedEncodingException{
		System.out.println(chapter.getChapterTitle());
		chapterService.editChapterInfor(chapter);
		String msg = "编辑章节成功";
		String newMsg = URLEncoder.encode(msg, "UTF-8");
		return "redirect:/toEditCourse?couid="+chapter.getCouId() + "&msg=" + newMsg;
	}
	
	/*     
	 * <p> 删除章节 </p>
	 * 
	 * @param [model, chapterid, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value= "/deleteChapter")
	public String deleteChapter(Model model,Integer chapterid,String couid) throws UnsupportedEncodingException{
		chapterService.deleteChapterById(chapterid);
		String msg = "删除章节成功";
		String newMsg = URLEncoder.encode(msg, "UTF-8");
		return "redirect:/toEditCourse?couid="+couid + "&msg=" + newMsg;
	}
}
