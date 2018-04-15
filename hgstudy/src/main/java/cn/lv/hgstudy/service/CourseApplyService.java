package cn.lv.hgstudy.service;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.CourseApply;

import java.util.List;
import java.util.Map;

/**  
  * <p> (这里用一句话描述这个类的作用) </p>
 *   
  * @author: xiucai（xiucai@maihaoche.com） 
  * @date: 2018/4/15 16:07   
 * @since V1.0
 */
public interface CourseApplyService {

	Boolean applyCourse(CourseApply apply);

	Boolean closeApply(Integer applyId);

	Page selectApplysByTeaId(String teaId,int start,int pageNumber);
}
