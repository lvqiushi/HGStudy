/**   
 * @Title: ChapterService.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月15日 下午2:24:25 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import java.util.List;

import cn.lv.hgstudy.pojo.Chapter;

/** 
 * @ClassName: ChapterService 
 * @Description:
 * @author lv
 * @date 2017年9月15日 下午2:24:25 
 *  
 */
public interface ChapterService {
	List<Chapter> selectChaptersByCouId(String couid);
	
    Chapter selectChapterByCId(int chapterid);
    
	boolean editChapterInfor(Chapter chapter);
	
	boolean deleteChapterById(int chapterid);
	
	boolean addChapter(Chapter chapter);
}
