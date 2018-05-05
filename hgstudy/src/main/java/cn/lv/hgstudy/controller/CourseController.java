package cn.lv.hgstudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.lv.hgstudy.enums.AttentionEnum;
import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.service.StuAttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.service.imp.CourseServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class CourseController {
	@Resource
	CourseServiceImpl courseService;
	@Autowired
	StuAttService stuAttService;

	//分页时每页数量
	private int pageNumber = 6;
	
	/*     
	 * <p> 查询课程 </p>
	 * 
	 * @param [curpage, type, kind, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/selectCourses")
    public String selectCourses(Integer curpage,
			@RequestParam(value = "type", required = false, defaultValue = "0")Integer type,
			@RequestParam(value = "kind", required = false, defaultValue = "1")Integer kind,
			String keyword, Model model){
		try {
			if(null==curpage || curpage<1){
				curpage=1;
			}
			Page courses = courseService.selectCourses((curpage-1)*pageNumber, pageNumber, type, kind,keyword);
			model.addAttribute("pagebean", courses);

			model.addAttribute("kind", kind);
			model.addAttribute("type", type);
			model.addAttribute("curpage", curpage);
		}catch (Exception e){
			e.printStackTrace();
		}
        return "all_course";
    }

	/*    
	 * <p> 搜索课程 </p>
	 *
	 * @param [curpage, type, kind, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/searchCourses")
	public String searchCourses(Integer curpage, String keyword, Model model){
		try {
			if(null==curpage || curpage<1){
				curpage=1;
			}
			Page courses = courseService.searchCourses((curpage-1)*pageNumber, pageNumber,keyword);
			model.addAttribute("pagebean", courses);
			model.addAttribute("keyword", keyword);
			model.addAttribute("curpage", curpage);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "search_result";
	}
	
    /*     
     * <p> 查看课程详情 </p>
     * 
     * @param [couid, model, session]
     * @return java.lang.String 
     */
	@RequestMapping(value = "/selectCourseInfor")
    public String showCourseInfor(Integer couid,Model model,HttpSession session){
    	try {
			String type = (String) session.getAttribute("userType");
			Course course = courseService.selectCourseByID(couid);
			model.addAttribute("cou", course);
			if("student".equals(type)) {
				Student student = (Student) session.getAttribute("user");
				if(stuAttService.selectAttention(student.getStuId(),couid) > 0){
					model.addAttribute("statu", AttentionEnum.CANCEL.getCode());
				}
				else {
					model.addAttribute("statu", AttentionEnum.ATTENTION.getCode());
				}
			}
		}catch (Exception e){
    		e.printStackTrace();
		}
        return "course_detail";
    }

    /*     
     * <p> 跳转到编辑课程页面 </p>
     * 
     * @param [couid, model]
     * @return java.lang.String 
     */
	@RequestMapping(value = "/toEditCourseInfor")
	public String toEditCourseIndex(Integer couid,Model model){

		Course course = courseService.selectCourseByID(couid);
		model.addAttribute("cou", course);
		model.addAttribute("couid", couid);
		return "edit_course_infor";
	}

	/*     
	 * <p> 编辑课程详情接口 </p>
	 * 
	 * @param [cou, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/editCourseInfor")
	public String editCourseInfor(Course cou,Model model){
		boolean b = courseService.EditCourseInfor(cou);
		//model.addAttribute("cou", course);
		model.addAttribute("msg","修改课程信息成功");
		return "redirect:/toEditCourse?couid="+cou.getCouId();
	}

	/*     
	 * <p> 跳转到编辑课程封面页面 </p>
	 * 
	 * @param [couid, model]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toEditCourImg")
	public String toEditCourImg(Integer couid,Model model){
		model.addAttribute("couid",couid);
		return "upload_course_img";
	}

	/*     
	 * <p> 上传课程封面 </p>
	 * 
	 * @param [couid, model, pic, request]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/EditCourImg")
	public String EditCourImg(Integer couid,Model model,@RequestParam("pic") CommonsMultipartFile pic,HttpServletRequest request){
		try {
			String path = request.getSession().getServletContext().getRealPath("/courseimage");
			if(courseService.EditCourseImg(couid,pic,path)){
				model.addAttribute("msg","上传课程封面图片成功");
			}
			else
				model.addAttribute("msg","上传课程封面图片失败");
		}catch (Exception e){
			e.printStackTrace();
		}
		return "redirect:/toEditCourse?couid="+couid;
	}
}
