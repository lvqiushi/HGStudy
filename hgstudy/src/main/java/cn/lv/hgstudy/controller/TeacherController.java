/**   
 * @Title: TeacherController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO
 * @author lv 
 * @date 2017年9月13日 下午7:09:38 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.lv.hgstudy.enums.EmailTypeEnum;
import cn.lv.hgstudy.model.UserMailInfo;
import cn.lv.hgstudy.pojo.Chapter;
import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.service.StudentService;
import cn.lv.hgstudy.util.AesUtil;
import cn.lv.hgstudy.util.RedisUtil;
import cn.lv.hgstudy.util.SendMailUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Description:
 * @author lv
 * @date 2017年9月13日 下午7:09:38 
 *  
 */

@Controller
public class TeacherController {
	@Resource
	private TeacherService tercherService;
	@Resource
	private CourseService courseService;
	@Resource
	private ChapterService chapterService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private RedisUtil redisUtil;
	
	//分页时每页数量
    private static final int pageNumber = 5;

    private static final String PASSWORD_URL = "localhost:8080/toEditPassword?token=";
	
    /**
     * 
     * @Title: showTeacherInfor 
     * @Description: 跳转到教师信息页面
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
	 * @Description: 跳转到教师个人中心页面
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
	 * @Description: 跳转到教师下的课程列表页面
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
	 * @Description: 跳转到编辑教师信息页面
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
	
	/*     
	 * <p> 编辑教师个人信息 </p>
	 * 
	 * @param [model, tea, session]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/editTeaInfor")
    public String editTeacherInfor(Model model,Teacher tea,HttpSession session){
		tercherService.editTeacher(tea);
		session.setAttribute("user", tea);
		Teacher newtea = tercherService.showTeacherInfor(tea.getTeaId());
		model.addAttribute("tea", newtea);
		return "teacher";
	}
	
	/*     
	 * <p> 跳转到管理课程页面 </p>
	 * 
	 * @param [model, couid, session]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toEditCourse")
    public String toEditCourse(Model model,Integer couid){
		Course cou = courseService.selectCourseByID(couid);
		model.addAttribute("couname", cou.getCouName());
		model.addAttribute("couid", cou.getCouId());
		List<Chapter> chapters = chapterService.selectChaptersByCouId(couid);
		model.addAttribute("chapters", chapters);
		return "edit_course";
	}
	
	/*     
	 * <p> 跳转到课程管理首页 </p>
	 * 
	 * @param [model, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toEditCourseIndex")
    public String toEditCourseIndex(Model model,String couid){
		model.addAttribute("couid", couid);
		return "edit_course_index";
	}
	
	/*     
	 * <p> 修改头像 </p>
	 * 
	 * @param [model, img, teaid]
	 * @return cn.lv.hgstudy.common.JsonResult 
	 */
	@RequestMapping(value = "/editHeader")
	@ResponseBody
    public JsonResult editHeader(Model model,String img,String teaid){
		tercherService.editTeaHeader(img,teaid);
		JsonResult result = new JsonResult();
		result.setMessage("修改头像成功");
		return result;
	}

	@RequestMapping(value = "/toSendPasswordMail")
	public String toSendPasswordMail(){
		return "password_send_mail";
	}

	@RequestMapping(value = "/toEditPassword")
	public String toEditPassword(String token,Model model){
		model.addAttribute("token",token);
		return "reset_password";
	}

	@RequestMapping(value = "/editPassword")
	@ResponseBody
	public JsonResult editPassword(String token,HttpSession session,String password){
		JsonResult result = new JsonResult();
		if(StringUtils.isBlank(token)){
			result.setSuccess(false);
			result.setMessage("token不能为空");
			return result;
		}
		String type = (String) session.getAttribute("userType");
		String userId = AesUtil.AESDecode(token);
		if(StringUtils.isBlank(userId)){
			result.setSuccess(false);
			result.setMessage("请访问正确的连接地址修改密码");
			return result;
		}
//		if("student".equals(type)){
//			Student student = new Student();
//			//获取redis中用户token
//			String userToken = redisUtil.getString(student.getStuId());
//			if(!token.equals(userToken)){
//				result.setSuccess(false);
//				result.setMessage("你只能修改自己的密码");
//				return result;
//			}
//			student.setStuId(userId);
//			student.setStuPassword(password);
//			studentService.editStudentInfor(student);
//		}else {
//			Teacher teacher = new Teacher();
//			//获取redis中用户token
//			String userToken = redisUtil.getString(teacher.getTeaId());
//			if(!token.equals(userToken)){
//				result.setSuccess(false);
//				result.setMessage("你只能修改自己的密码");
//				return result;
//			}
//			teacher.setTeaId(userId);
//			teacher.setTeaPassword(password);
//			tercherService.editTeacher(teacher);
//		}
		result.setMessage("修改密码成功，请重新登录");
		return result;
	}

	@RequestMapping(value = "/sendPasswordMail")
	@ResponseBody
	public JsonResult sendPasswordMail(HttpSession session,String email){
		JsonResult result = new JsonResult();
//		String type = (String) session.getAttribute("userType");
//		UserMailInfo user = new UserMailInfo();
//		List<UserMailInfo> users = new ArrayList<>();
//		if("student".equals(type)){
//			Student stu = (Student) session.getAttribute("user");
//			String token = AesUtil.AESEncode(stu.getStuId());
//			user.setUserMailAdress(email);
//			user.setUserName(stu.getStuName());
//			users.add(user);
//			String content = String.format(EmailTypeEnum.EDIT_PASSWORD.getContent(),PASSWORD_URL+token);
//			//发送链接邮件
//			SendMailUtil.sendMail(EmailTypeEnum.EDIT_PASSWORD.getType(),content,users);
//			//将token保存在redis
//			redisUtil.set(stu.getStuId(),token);
//		} else {
//			Teacher tea = (Teacher) session.getAttribute("user");
//			String token = AesUtil.AESEncode(tea.getTeaId());
//			user.setUserMailAdress(tea.getEmailAdress());
//			user.setUserName(tea.getTeaName());
//			users.add(user);
//			String content = String.format(EmailTypeEnum.EDIT_PASSWORD.getContent(),PASSWORD_URL+token);
//			//发送链接邮件
//			SendMailUtil.sendMail(EmailTypeEnum.EDIT_PASSWORD.getType(),content,users);
//			//将token保存在redis
//			redisUtil.set(tea.getTeaId(),token);
//		}
		return result;
	}
}
