/**   
 * @Title: LoginController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO
 * @author lv 
 * @date 2017年9月13日 下午10:22:02 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.service.StudentService;
import cn.lv.hgstudy.service.TeacherService;
import cn.lv.hgstudy.util.VerifyCodeUtils;

/** 
 * @ClassName: LoginController 
 * @Description: TODO
 * @author lv
 * @date 2017年9月13日 下午10:22:02 
 *  
 */
@Controller
public class LoginController {
	@Resource
	TeacherService teacherService;
	@Resource
	StudentService studentService;
	
	@RequestMapping(value = "/login")
    public String login(String username,String password,String usertype,HttpSession session){
		try {
			password = password.trim();
			if ("student".equals(usertype)) {
				Student stu = studentService.loginStudent(username, password);
				if (null == stu) {
					return "redirect:/login.jsp";
				} else {
					session.setAttribute("user", stu);
					session.setAttribute("userType", usertype);
					return "redirect:/index";
				}
			}
			if ("teacher".equals(usertype)) {
				Teacher tea = teacherService.loginTeacher(username, password);
				if (null == tea) {
					return "redirect:/login.jsp";
				} else {
					session.setAttribute("user", tea);
					session.setAttribute("userType", usertype);
					return "redirect:/index";
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("userType");
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value="/getYzm",method=RequestMethod.GET)
	public void getYzm(HttpServletResponse response,HttpServletRequest request){
		System.out.println("this");
		try {
			response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/jpeg");  
	          
	        //生成随机字串  
	        String verifyCode = VerifyCodeUtils.Verify.generateVerifyCode(4);  
	        //存入会话session  
	        HttpSession session = request.getSession(true);  
	        session.setAttribute("_code", verifyCode.toLowerCase());  
	        //生成图片  
	        int w = 146, h = 33;  
	        VerifyCodeUtils.Verify.outputImage(w, h, response.getOutputStream(), verifyCode);  
		} catch (Exception e) {
			
		}
	}
}
