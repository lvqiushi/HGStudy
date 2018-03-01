/**   
 * @Title: JointController.java 
 * @Package cn.lv.hgstudy.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月19日 下午10:22:35 
 * @version V1.0   
 */
package cn.lv.hgstudy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lv.hgstudy.pojo.Joint;
import cn.lv.hgstudy.service.JointService;

/** 
 * @ClassName: JointController 
 * @Description:
 * @author lv
 * @date 2017年9月19日 下午10:22:35 
 *  
 */

@Controller
public class JointController {
	@Resource
	JointService jointservice;
	
	/*     
	 * <p> 跳转到添加小节页面 </p>
	 * 
	 * @param [model, chapterid, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toaddjoint")
    public String toaddjoint(Model model,String chapterid,String couid){
		model.addAttribute("chapterid", chapterid);
		model.addAttribute("couid", couid);
		return "add_joint";
	}
	
	/*     
	 * <p> 新增小节 </p>
	 * 
	 * @param [model, joint, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/addjoint")
    public String addjoint(Model model,Joint joint,String couid){
		jointservice.addJoint(joint);
		return "redirect:/toEditCourse?couid="+couid;
	}
	
	/*     
	 * <p> 跳转到编辑小节页面 </p>
	 * 
	 * @param [model, jointid, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/toeditjoint")
    public String toeditjoint(Model model,Integer jointid,String couid){
		model.addAttribute("joint", jointservice.selectJointByJId(jointid));
		model.addAttribute("couid", couid);
		return "edit_joint";
	}
	
	/*     
	 * <p> 编辑小节 </p>
	 * 
	 * @param [model, joint, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/editjoint")
    public String editjoint(Model model,Joint joint,String couid){
		try {
			if(1==jointservice.editJoint(joint))
				return "redirect:/toEditCourse?couid="+couid;
			else
				return "redirect:/toEditCourse?couid="+couid;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/*     
	 * <p> 删除小节 </p>
	 * 
	 * @param [model, jointid, couid]
	 * @return java.lang.String 
	 */
	@RequestMapping(value = "/delejoint")
    public String delejoint(Model model,Integer jointid,String couid){
		if(1==jointservice.deleteJoint(jointid))
			return "redirect:/toEditCourse?couid="+couid;
		else
			return "error";
	}
}
