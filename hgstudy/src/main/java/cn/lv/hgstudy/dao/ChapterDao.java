package cn.lv.hgstudy.dao;

import java.util.List;

import cn.lv.hgstudy.pojo.Chapter;

public interface ChapterDao {
	List<Chapter> selectChaptersByCouId(String couid);
    Chapter selectChapterByCId(int chapterid);
    
	boolean editChapterInfor(Chapter chapter);
	
	boolean deleteChapterById(int chapterid);
	
	boolean addChapter(Chapter chapter);

	//boolean deleteChaptersByCouid(int couid);
}
