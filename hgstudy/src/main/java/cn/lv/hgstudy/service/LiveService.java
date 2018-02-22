package cn.lv.hgstudy.service;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Live;

import java.util.List;

/**  
  * <p> (这里用一句话描述这个类的作用) </p>
 *   
  * @author: xiucai（xiucai@maihaoche.com） 
  * @date: 2018/2/19 16:39   
 * @since V1.0
 */
public interface LiveService {

	Page selectAll(int start,int pageNumber);

	Live selectById(Integer id);

	Boolean addLive(Live live);

	Boolean openLive(Integer id);

	Boolean exitLive(Integer id);
}
