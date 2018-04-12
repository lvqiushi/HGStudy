/**   
 * @Title: StudentController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月14日 下午2:49:46 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.lv.hgstudy.common.JsonResult;
import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.service.CourseService;
import org.springframework.stereotype.Controller;

import cn.lv.hgstudy.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @ClassName: StudentController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月14日 下午2:49:46 
 *  
 */
@Controller
public class StudentController {
	@Resource
	private StudentService stuservice;

	@Resource
	private CourseService courseService;

	//分页时每页数量
	private int pageNumber = 5;
	/**
	 *
	 * @Description: 跳转到学生个人中心页面
	 * @param model
	 * @param session
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/stuInfor")
	public String studentInfor(Model model,HttpSession session){
		Student stu = (Student) session.getAttribute("user");
		Student student = stuservice.showStudentInfor(stu.getStuId());
		model.addAttribute("stu", student);
		return "student";
	}

	/**
	 *
	 * @Description: 跳转到编辑学生信息页面
	 * @param model
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/showStuInfor")
	public String showStuInfor(Model model,String stuid){
		Student student = stuservice.showStudentInfor(stuid);
		model.addAttribute("stu", student);
		return "student_infor";
	}

	/**
	 *
	 * @Description: 编辑学生信息页面
	 * @param model
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/editStuInfor")
	public String editStuInfor(Model model,Student student){
		stuservice.editStudentInfor(student);
		model.addAttribute("stu", student);
		model.addAttribute("msg","修改信息成功");
		return "student_infof";
	}

	/*    
	 * <p> 修改头像 </p>
	 *
	 * @param [model, img, teaid]
	 * @return cn.lv.hgstudy.common.JsonResult
	 */
	@RequestMapping(value = "/editStuHeader")
	@ResponseBody
	public JsonResult editHeader(Model model,String img,String stuid){
		stuservice.editStuHeader(img,stuid);
		JsonResult result = new JsonResult();
		result.setMessage("修改头像成功");
		return result;
	}

	@RequestMapping(value = "/showAttCourse")
	public String showAttCourse(Model model,HttpSession session,Integer curpage){
		if(null==curpage || curpage<1){
			curpage=1;
		}
		Student stu = (Student) session.getAttribute("user");
		Page courses = courseService.selectCoursesByStuID(stu.getStuId(), (curpage-1)*pageNumber, pageNumber);
		model.addAttribute("pagebean", courses);
		return "student_att_course";
	}
}
