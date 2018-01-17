/**   
 * @Title: MultipartRequestFilter.java 
 * @Package cn.lv.hgstudy.filter 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年10月27日 下午4:19:55 
 * @version V1.0   
 */
package cn.lv.hgstudy.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/** 
 * @ClassName: MultipartRequestFilter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年10月27日 下午4:19:55 
 *  
 */
public class MultipartRequestFilter implements Filter{
	
	private CommonsMultipartResolver multipartResolver= new CommonsMultipartResolver();
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String enctype = req.getContentType(); 
		if (StringUtils.isNotBlank(enctype) && enctype.contains("multipart/form-data")){
			 MultipartHttpServletRequest multiReq = multipartResolver.resolveMultipart((HttpServletRequest)req);
			 req=multiReq;
			 System.out.println("已转换");
		}
	    chain.doFilter(req, res);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
