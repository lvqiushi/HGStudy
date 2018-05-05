/**
 * All rights Reserved, Designed By www.maihaoche.com
 * <p>
 *  * @Package com.mhc.gwsaleen.base.exception
 *  * @author: xiucai（xiucai@maihaoche.com）
 *  * @date:   2017/11/29 23:37
 *  * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 *  * 注意：本内容仅限于卖好车内部传阅，禁止外泄以及用于其他的商业目
 */
package cn.lv.hgstudy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**  
 * <p> 全局统一异常处理类 </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2017/11/29 23:37   
 * @since V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res,Exception e) throws Exception {

        //ajax
        if (req.getHeader("accept").contains("application/json") || (req.getHeader("X-Requested-With") != null && req.getHeader("X-Requested-With").contains("XMLHttpRequest"))) {
            String jsonErrorResult = null;

            jsonErrorResult = "Ajax响应错误";

            try {
                res.setContentType("application/json;charset=utf-8");
                PrintWriter writer = res.getWriter();
                writer.write(jsonErrorResult);
                writer.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            return new ModelAndView();
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", "系统发生错误");
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
