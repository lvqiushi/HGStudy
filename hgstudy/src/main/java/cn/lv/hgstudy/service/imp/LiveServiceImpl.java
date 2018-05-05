package cn.lv.hgstudy.service.imp;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.dao.LiveDao;
import cn.lv.hgstudy.pojo.Live;
import cn.lv.hgstudy.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/19 16:40   
 * @since V1.0
 */
@Service
public class LiveServiceImpl implements LiveService{

	@Resource
	LiveDao liveDao;

	@Override
	public Page selectAll(int start, int pageNumber) {
		List lives;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		lives = liveDao.selectAll(map);
		int total = liveDao.selectLiveTotal();
		Page page = new Page(total, start, pageNumber);
		page.setContents(lives);
		return page;
	}

	@Override
	public Live selectById(Integer id) {
		return liveDao.selectById(id);
	}

	@Override
	public Boolean addLive(Live live) {
		return liveDao.addLive(live);
	}

	@Override
	public Boolean openLive(Integer id) {
		return liveDao.openLive(id);
	}

	@Override
	public Boolean exitLive(Integer id) {
		return liveDao.exitLive(id);
	}

	@Override
	public Live selectLiveByCouId(Integer couId) {
		return liveDao.selectLiveByCouId(couId);
	}
}
