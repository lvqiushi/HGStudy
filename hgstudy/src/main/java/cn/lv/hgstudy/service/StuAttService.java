package cn.lv.hgstudy.service;

import cn.lv.hgstudy.pojo.StuAttention;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/26 14:02   
 * @since V1.0
 */
public interface StuAttService {
	Boolean AttCourse(String userId,Integer couId);

	Boolean cancelAtt(String userId,Integer couId);

	Integer selectAttention(String userId,Integer couId);
}
