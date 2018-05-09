/**   
 * @Title: CoursewareController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年10月25日 下午4:26:17 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Courseware;
import cn.lv.hgstudy.service.imp.CoursewareServiceImpl;

/** 
 * @ClassName: CoursewareController 
 * @Description:
 * @author lv
 * @date 2017年10月25日 下午4:26:17 
 *  
 */
@Controller
public class CoursewareController {
	@Resource CoursewareServiceImpl cousewareService;
	//分页时每页数量
	private int pageNumber = 6;
		
	/*     
	 * <p> 跳转到下载课件页面 </p>
	 * 
	 * @param [couid, curpage, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toDownloadCourseware")
    public String toDownloadCourseware(String couid,Integer curpage,Model model){
		if(null==curpage || curpage<1){
			curpage=1;
		}
		Page courseware = cousewareService.selectCousewareByCouid(couid,(curpage-1)*pageNumber, pageNumber);
		model.addAttribute("pagebean", courseware);
		model.addAttribute("couid", couid);
		return "courseware_download";
	}
	
	/*     
	 * <p> 下载课件 </p>
	 * 
	 * @param [fileid, model, request, response]
	 * @return void 
	 */
	@RequestMapping(value = "/DownloadCourseware")
    public void DownloadCourseware(String fileid,Model model,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Courseware courseware = cousewareService.selectCousewareById(fileid);
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/courseware");
		String filepath = ctxPath + File.separator +courseware.getFilePath();
		//设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		//response.setContentType("multipart/form-data");
		response.setContentType("application/x-msdownload");
		String newNmae = "";
		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
			newNmae = URLEncoder.encode(courseware.getFileName(), "UTF-8");
		} else {
			newNmae = new String(courseware.getFileName().getBytes("UTF-8"), "ISO8859-1");
		}
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ newNmae);
		//new String(courseware.getFileName().getBytes("utf-8"),"iso-8859-1")
		//用于记录以完成的下载的数据量，单位是byte
		long downloadedLength = 0L;
		try {
			//打开本地文件流
			InputStream inputStream = new FileInputStream(filepath);
			//激活下载操作
			OutputStream os = response.getOutputStream();
			//循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
				downloadedLength += b.length;
			}
			// 这里主要关闭。
			os.close();
			inputStream.close();
		} catch (Exception e){
			throw e;
		}
	}
	
	/*     
	 * <p> 根据课程展示课件列表 </p>
	 * 
	 * @param [couid, curpage, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/showCourseware")
    public String showCourseware(String couid,Integer curpage,Model model){
		if(null==curpage || curpage<1){
			curpage=1;
		}
		Page courseware = cousewareService.selectCousewareByCouid(couid,(curpage-1)*pageNumber, pageNumber);
		model.addAttribute("pagebean", courseware);
		model.addAttribute("couid", couid);
        return "show_kejian";
    }
	
    /*     
     * <p> 上传课件 </p>
     * 
     * @param [crsware, courseware, request]
     * @return java.lang.String 
     */
	@RequestMapping(value = "/addCourseware")
    public String addCourseware(Courseware crsware,@RequestParam("courseware") CommonsMultipartFile courseware,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("/courseware");
		cousewareService.addCouseware(crsware,courseware,path);
        return "redirect:/showCourseware?couid="+crsware.getCouId();
    }

    /*     
     * <p> 删除课件 </p>
     * 
     * @param [coursewareid, couid]
     * @return java.lang.String 
     */
	@RequestMapping(value = "/delectCourseware")
    public String delectCourseware(String coursewareid,String couid){
		cousewareService.delectCouseware(coursewareid);
        return "redirect:/showCourseware?couid="+couid;
    }
}
