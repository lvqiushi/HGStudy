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
	
	@RequestMapping(value = "/toAddChapter")
	public String toAddChapter(Model model,String couid){
		model.addAttribute("couid", couid);
		return "add_zhangjie";
	}
	
	@RequestMapping(value = "/AddChapter")
	public String AddChapter(Model model,Chapter chapter){
		chapterService.addChapter(chapter);
		return "redirect:/toEditCourse?couid="+chapter.getCouId();
	}
	
	@RequestMapping(value = "/toEditChapter")
	public String toEditChapter(Model model,Integer chapterId){
		Chapter chapter = chapterService.selectChapterByCId(chapterId);
		model.addAttribute("chapter", chapter);
		return "edit_zhangjie";
	}
	
	@RequestMapping(value= "/editChapter")
	public String EditChapter(Model model,Chapter chapter){
		System.out.println(chapter.getChapterTitle());
		chapterService.editChapterInfor(chapter);
		return "redirect:/toEditCourse?couid="+chapter.getCouId();
	}
	
	@RequestMapping(value= "/deleteChapter")
	public String deleteChapter(Model model,Integer chapterid,String couid){
		chapterService.deleteChapterById(chapterid);
		return "redirect:/toEditCourse?couid="+couid;
	}
}
