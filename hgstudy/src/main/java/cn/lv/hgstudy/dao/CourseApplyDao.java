package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.CourseApply;

import java.util.List;
import java.util.Map;

/**  
  * <p> (这里用一句话描述这个类的作用) </p>
 *   
  * @author: xiucai（xiucai@maihaoche.com） 
  * @date: 2018/4/15 15:51   
 * @since V1.0
 */
public interface CourseApplyDao {
	Boolean insertApply(CourseApply apply);

	Boolean deleteApply(Integer applyId);

	List<CourseApply> selectAllApply(Map map);

	Integer countApply(String teaId);
}
