/**   
 * @Title: TeacherController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO
 * @author lv 
 * @date 2017年9月13日 下午7:09:38 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.lv.hgstudy.common.JsonResult;
import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.dao.CourseDao;
import cn.lv.hgstudy.dao.TeacherDao;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.service.ChapterService;
import cn.lv.hgstudy.service.CourseService;
import cn.lv.hgstudy.service.TeacherService;
import cn.lv.hgstudy.util.BASE64Encode;

/** 
 * @ClassName: TeacherController 
 * @Description: TODO
 * @author lv
 * @date 2017年9月13日 下午7:09:38 
 *  
 */

@Controller
public class TeacherController {
	@Resource
	TeacherService tercherService;
	@Resource
	CourseService courseService;
	@Resource
	ChapterService chapterService;
	
	//分页时每页数量
    private int pageNumber = 5;
	
    /**
     * 
     * @Title: showTeacherInfor 
     * @Description: TODO(跳转到教师信息页面) 
     * @param teaid  教师号
     * @param model
     * @return String 教师信息页面 
     * @throws
     */
	@RequestMapping(value = "/showTeacherInfor")
    public String showTeacherInfor(String teaid,Model model){
		Teacher tea = tercherService.showTeacherInfor(teaid);
		
		List<Course> courses = (List<Course>) courseService.selectCoursesByTeaID(teaid, 0, 16).getContents();
		model.addAttribute("tea", tea);
		model.addAttribute("courses", courses);
		return "teacher_introduce";
	}
	
	/**
	 * 
	 * @Title: managerTeacherInfor 
	 * @Description: TODO(跳转到教师个人中心页面) 
	 * @param model
	 * @param session   
	 * @return String     
	 * @throws
	 */
	@RequestMapping(value = "/teaInfor")
    public String managerTeacherInfor(Model model,HttpSession session){
		Teacher tea = (Teacher) session.getAttribute("user");
		Teacher newtea = tercherService.showTeacherInfor(tea.getTeaId());
		model.addAttribute("tea", newtea);
		return "teacher";
	}
	
	/**
	 * 
	 * @Title: showTeachercCourse 
	 * @Description: TODO(跳转到教师下的课程列表页面) 
	 * @param model
	 * @param session
	 * @param curpage
	 * @return String     
	 * @throws
	 */
	@RequestMapping(value = "/selectCourseByTeaId")
    public String showTeachercCourse(Model model,HttpSession session,Integer curpage){
		if(null==curpage || curpage<1){
			curpage=1;
		}
		Teacher tea = (Teacher) session.getAttribute("user");
		Page courses = courseService.selectCoursesByTeaID(tea.getTeaId(), (curpage-1)*pageNumber, pageNumber);
		model.addAttribute("pagebean", courses);
		return "teacher_course";
	}
	
	/**
	 * 
	 * @Title: showTeachercCourse 
	 * @Description: TODO(跳转到编辑教师信息页面) 
	 * @param model
	 * @param teaid
	 * @return String     
	 * @throws
	 */
	@RequestMapping(value = "/showPersonInfor")
    public String showTeachercCourse(Model model,String teaid){
		if(null == teaid)
			return "error";
		Teacher tea = tercherService.showTeacherInfor(teaid);
		model.addAttribute("tea", tea);
		return "teacher_infor";
	}
	
	@RequestMapping(value = "/editTeaInfor")
    public String editTeacherInfor(Model model,Teacher tea,HttpSession session){
		System.out.println(tea.getTeaImage());
		System.out.println(tea.getTeaName());
		System.out.println(tea.getTeaId());
		tercherService.editTeacher(tea);
		session.setAttribute("user", tea);
		Teacher newtea = tercherService.showTeacherInfor(tea.getTeaId());
		model.addAttribute("tea", newtea);
		return "teacher";
	}
	
	@RequestMapping(value = "/toEditCourse")
    public String toEditCourse(Model model,String couid,HttpSession session){
		Course cou = courseService.selectCourseByID(couid);
		model.addAttribute("couname", cou.getCouName());
		model.addAttribute("couid", cou.getCouId());
		List chapters = chapterService.selectChaptersByCouId(couid);
		model.addAttribute("chapters", chapters);
		return "edit_course";
	}
	
	@RequestMapping(value = "/toEditCourseIndex")
    public String toEditCourseIndex(Model model,String couid){
		model.addAttribute("couid", couid);
		return "edit_course_index";
	}
	
	
	@RequestMapping(value = "/editHeader")
	@ResponseBody
    public JsonResult editHeader(Model model,String img,String teaid){
		tercherService.editTeaHeader(img,teaid);	
		JsonResult result = new JsonResult();
		result.setMessage("修改头像成功");
		return result;
	}
	

}
