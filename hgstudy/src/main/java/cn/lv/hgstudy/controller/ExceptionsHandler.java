/**   
 * @Title: ExceptionsHandler.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年11月6日 下午9:35:50 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @ClassName: ExceptionsHandler 
 * @Description:
 * @author lv
 * @date 2017年11月6日 下午9:35:50 
 *  
 */

@ControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler
	// 不指明异常类会自动映射
	public ModelAndView allExceptionHandler(Exception exception) {
		ModelAndView modelAndView = new ModelAndView("unitive_error");
		modelAndView.addObject("errMsg", "this is Exception.class");
		return modelAndView;
	}
}
