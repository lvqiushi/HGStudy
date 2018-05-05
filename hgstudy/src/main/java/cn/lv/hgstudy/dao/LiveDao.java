package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.Live;

import java.util.List;
import java.util.Map;

/**  
  * <p> (这里用一句话描述这个类的作用) </p>
 *   
  * @author: xiucai（xiucai@maihaoche.com） 
  * @date: 2018/2/19 16:07   
 * @since V1.0
 */
public interface LiveDao {

	List<Live> selectAll(Map<String,Object> map);

	Integer selectLiveTotal();

	Live selectById(Integer id);

	Boolean addLive(Live live);

	Boolean openLive(Integer id);

	Boolean exitLive(Integer id);

	Live selectLiveByCouId(Integer couId);
}
