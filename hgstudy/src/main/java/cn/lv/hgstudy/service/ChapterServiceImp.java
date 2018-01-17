/**   
 * @Title: ChapterServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月15日 下午2:25:37 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.ChapterDao;
import cn.lv.hgstudy.pojo.Chapter;

/** 
 * @ClassName: ChapterServiceImp 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月15日 下午2:25:37 
 *  
 */
@Service
public class ChapterServiceImp implements ChapterService{

	@Resource
	ChapterDao chdao;
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.ChapterService#selectChaptersByCouId(int)
	 */
	public List<Chapter> selectChaptersByCouId(String couid) {
		// TODO Auto-generated method stub		
		return chdao.selectChaptersByCouId(couid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.ChapterService#selectChapterByCId(int)
	 */
	public Chapter selectChapterByCId(int chapterid) {
		// TODO Auto-generated method stub
		return chdao.selectChapterByCId(chapterid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.ChapterService#editChapterInfor(cn.lv.hgstudy.pojo.Chapter)
	 */
	public boolean editChapterInfor(Chapter chapter) {
		// TODO Auto-generated method stub
		return chdao.editChapterInfor(chapter);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.ChapterService#deleteChapterById(int)
	 */
	public boolean deleteChapterById(int chapterid) {
		// TODO Auto-generated method stub
		return chdao.deleteChapterById(chapterid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.ChapterService#addChapter(cn.lv.hgstudy.pojo.Chapter)
	 */
	public boolean addChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chdao.addChapter(chapter);
	}

}
