/**   
 * @Title: TeacherController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO
 * @author lv 
 * @date 2017年9月13日 下午7:09:38 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.lv.hgstudy.enums.EmailTypeEnum;
import cn.lv.hgstudy.form.Announce;
import cn.lv.hgstudy.model.UserMailInfo;
import cn.lv.hgstudy.pojo.*;
import cn.lv.hgstudy.service.*;
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
	private CourseApplyService applyService;
	@Autowired
	private LiveService liveService;
	@Autowired
	private RedisUtil redisUtil;
	
	//分页时每页数量
    private static final int pageNumber = 5;

    private static final String PASSWORD_URL = "http://localhost:8080/toEditPassword?token=";
	
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
    public String toEditCourse(Model model,Integer couid,String msg){
		Course cou = courseService.selectCourseByID(couid);
		model.addAttribute("couname", cou.getCouName());
		model.addAttribute("couid", cou.getCouId());
		List<Chapter> chapters = chapterService.selectChaptersByCouId(couid);
		model.addAttribute("chapters", chapters);
		model.addAttribute("msg",msg);
		return "edit_course";
	}
	
	/*     
	 * <p> 跳转到课程管理首页 </p>
	 * 
	 * @param [model, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toEditCourseIndex")
    public String toEditCourseIndex(Model model,Integer couid){
		model.addAttribute("couid", couid);
		Course cou = courseService.selectCourseByID(couid);
		model.addAttribute("couname", cou.getCouName());
		return "edit_course_index";
	}

	/*    
	 * <p> 跳转到课程申请页面 </p>
	 *
	 * @param [model, couid]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/toApplyCourse")
	public String toApplyCourse(Model model,HttpSession session){
		Teacher tea = (Teacher) session.getAttribute("user");
		model.addAttribute("teaId",tea.getTeaId());
		return "apply_course";
	}

	/*    
	 * <p> 提交课程申请 </p>
	 *
	 * @param [model, couid]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/applyCourse")
	public String applyCourse(Model model,String teaId,String courseName,Integer courseType){
		CourseApply apply = new CourseApply();
		Teacher tea = tercherService.showTeacherInfor(teaId);
		apply.setCouresName(courseName);
		apply.setCourseType(courseType);
		apply.setTeaId(teaId);
		apply.setTeaSchool(tea.getTeaSchool());
		apply.setTeaName(tea.getTeaName());
		applyService.applyCourse(apply);
		model.addAttribute("tea", tea);
		model.addAttribute("msg","成功提交课程申请");
		return "teacher";
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
		//String type = (String) session.getAttribute("userType");
		String idAndType = AesUtil.AESDecode(token);
		if(StringUtils.isBlank(idAndType)){
			result.setSuccess(false);
			result.setMessage("请访问正确的连接地址修改密码");
			return result;
		}
		String[] properties = idAndType.split("_");
		String userId = properties[0];
		String type = properties[1];
		if("stu".equals(type)){
			Student student = new Student();
			//获取redis中用户token
			String userToken = redisUtil.getString(student.getStuId());
			if(!token.equals(userToken)){
				result.setSuccess(false);
				result.setMessage("你只能修改自己的密码");
				return result;
			}
			student.setStuId(userId);
			student.setStuPassword(password);
			studentService.editStudentInfor(student);
		}else {
			Teacher teacher = new Teacher();
			//获取redis中用户token
			String userToken = redisUtil.getString(teacher.getTeaId());
			if(!token.equals(userToken)){
				result.setSuccess(false);
				result.setMessage("你只能修改自己的密码");
				return result;
			}
			teacher.setTeaId(userId);
			teacher.setTeaPassword(password);
			tercherService.editTeacher(teacher);
		}
		result.setMessage("修改密码成功，请重新登录");
		return result;
	}

	@RequestMapping(value = "/sendPasswordMail")
	@ResponseBody
	public JsonResult sendPasswordMail(String email){
		JsonResult result = new JsonResult();
		//String type = (String) session.getAttribute("userType");
		UserMailInfo user = new UserMailInfo();
		List<UserMailInfo> users = new ArrayList<>();
		try {
			Teacher tea = tercherService.findTeaByEmail(email);
			if (!Objects.isNull(tea)){
				String token = AesUtil.AESEncode(tea.getTeaId()+"_tea");
				//将token保存在redis
				String success = redisUtil.setex(tea.getTeaId(),60*10,token);
				if(StringUtils.isBlank(success)){
					result.setSuccess(false);
					result.setMessage("发送邮件失败，请重试");
					return result;
				}
				user.setUserMailAdress(tea.getEmailAdress());
				user.setUserName(tea.getTeaName());
				users.add(user);
				String content = String.format(EmailTypeEnum.EDIT_PASSWORD.getContent(),PASSWORD_URL+token,PASSWORD_URL+token);
				//发送链接邮件
				//SendMailUtil.sendMail(EmailTypeEnum.EDIT_PASSWORD.getType(),content,users);
				return result;
			}
			Student stu = studentService.findStuByEmail(email);
			if(Objects.isNull(stu)){
				result.setSuccess(false);
				result.setMessage("邮箱地址无效");
				return result;
			}else {
				String token = AesUtil.AESEncode(stu.getStuId()+"_stu");
				//将token保存在redis
				String success = redisUtil.setex(stu.getStuId(),60*10,token);
				if(StringUtils.isBlank(success)){
					result.setSuccess(false);
					result.setMessage("发送邮件失败，请重试");
					return result;
				}
				user.setUserMailAdress(email);
				user.setUserName(stu.getStuName());
				users.add(user);
				String content = String.format(EmailTypeEnum.EDIT_PASSWORD.getContent(),PASSWORD_URL+token,PASSWORD_URL+token);
				//发送链接邮件
				//SendMailUtil.sendMail(EmailTypeEnum.EDIT_PASSWORD.getType(),content,users,"");
			}
		}catch (Exception e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("发送邮件失败，请重试");
		}

		return result;
	}

	@RequestMapping(value = "/sendMailToStudent")
	@ResponseBody
	public JsonResult sendMailToStudent(Announce announce,HttpSession session){
		JsonResult result = new JsonResult();
		String frequency = redisUtil.getString(announce.getCouId().toString());
		if(StringUtils.isNotBlank(frequency)){
			Integer frequencys = Integer.valueOf(frequency);
			if(frequencys > 2){
				result.setSuccess(false);
				result.setMessage("每天发送课程公告次数不能大于三次,请明天再试");
				return result;
			}
		}
		Course course = courseService.selectCourseByID(announce.getCouId());
		Teacher tea = (Teacher) session.getAttribute("user");
		List<Student> students = studentService.selectStudentsByCId(announce.getCouId());
		List<UserMailInfo> users = new ArrayList<>();
		for (Student student:students) {
			UserMailInfo user = new UserMailInfo();
			user.setUserName(student.getStuName());
			user.setUserMailAdress(student.getEmailAdress());
			users.add(user);
		}
		String title = String.format(EmailTypeEnum.PUB_MESSAGE.getTitle(),tea.getTeaName(),course.getCouName());
		SendMailUtil.sendMail(EmailTypeEnum.PUB_MESSAGE.getType(),announce.getContent(),users,title);
		//将使用次数保存在redis
		LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//当天零点
		Long success = redisUtil.incrAtExpire(announce.getCouId().toString(),
				today_end.toInstant(ZoneOffset.of("+8")).toEpochMilli());
		return result;
	}

	@RequestMapping(value = "/toAnnounce")
	public String toAnnounce(Integer couId,Model model){
		model.addAttribute("couId",couId);
		return "announce";
	}

	@RequestMapping(value = "/toApplyLive")
	public String toApplyLive(Integer couId,Model model){
		model.addAttribute("couId",couId);
		return "apply_live_room";
	}

	@RequestMapping(value = "/applyLive")
	public String applyLive(Live live,HttpSession session){
		Teacher tea = (Teacher) session.getAttribute("user");
		live.setTeaId(tea.getTeaId());
		liveService.addLive(live);
		return "apply_live_room";
	}
}
