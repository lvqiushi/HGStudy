package cn.lv.hgstudy.service.imp;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.dao.CourseApplyDao;
import cn.lv.hgstudy.pojo.CourseApply;
import cn.lv.hgstudy.service.CourseApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/15 16:10   
 * @since V1.0
 */
@Service
public class CourseApplyServiceImpl implements CourseApplyService{
	@Autowired
	private CourseApplyDao courseApplyDao;

	@Override
	public Boolean applyCourse(CourseApply apply) {
		return courseApplyDao.insertApply(apply);
	}

	@Override
	public Boolean closeApply(Integer applyId) {
		return courseApplyDao.deleteApply(applyId);
	}

	@Override
	public Page selectApplysByTeaId(String teaId, int start, int pageNumber) {
		Page applys = new Page();
		Map map = new HashMap();
		map.put("teaId",teaId);
		map.put("start",start);
		map.put("pageNumber",pageNumber);
		List<CourseApply> applyList = courseApplyDao.selectAllApply(map);
		Integer count = courseApplyDao.countApply(teaId);
		Page page = new Page(count, start, pageNumber);
		page.setContents(applyList);
		return page;
	}
}
