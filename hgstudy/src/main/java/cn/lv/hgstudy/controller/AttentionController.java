package cn.lv.hgstudy.controller;

import cn.lv.hgstudy.common.JsonResult;
import cn.lv.hgstudy.enums.AttentionEnum;
import cn.lv.hgstudy.pojo.Student;
import cn.lv.hgstudy.service.StuAttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/26 13:49   
 * @since V1.0
 */
@RestController
public class AttentionController {
	@Autowired
	StuAttService stuAttService;

	@RequestMapping(value = "/AttentionCou")
	public JsonResult AttentionCou(Integer couid,Integer oper,HttpSession session){
		JsonResult jsonResult = new JsonResult();
		try {
			Student stu = (Student) session.getAttribute("user");
			if(AttentionEnum.ATTENTION.getCode().equals(oper)){
				jsonResult.setSuccess(stuAttService.AttCourse(stu.getStuId(),couid));
				jsonResult.setMessage("关注课程成功");
				jsonResult.setOtherinfor(AttentionEnum.ATTENTION.getCode().toString());
			}
			else {
				jsonResult.setSuccess(stuAttService.cancelAtt(stu.getStuId(),couid));
				jsonResult.setMessage("取消关注课程成功");
				jsonResult.setOtherinfor(AttentionEnum.CANCEL.getCode().toString());
			}
		}catch (Exception e){
			jsonResult.setSuccess(false);
			jsonResult.setMessage("关注课程失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
}
