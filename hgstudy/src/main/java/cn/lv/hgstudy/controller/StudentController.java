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

import org.springframework.stereotype.Controller;

import cn.lv.hgstudy.service.StudentService;

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
	StudentService stuservice;
}
