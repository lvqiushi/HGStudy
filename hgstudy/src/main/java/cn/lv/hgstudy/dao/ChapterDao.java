package cn.lv.hgstudy.dao;

import java.util.List;
import java.util.Map;

import cn.lv.hgstudy.pojo.Chapter;

public interface ChapterDao {
	List<Chapter> selectChaptersByCouId(Integer couid);

    Chapter selectChapterByCId(int chapterid);
    
	boolean editChapterInfor(Chapter chapter);
	
	boolean deleteChapterById(int chapterid);
	
	boolean addChapter(Chapter chapter);
	
	//���ݿγ�ID����ɾ����
	//boolean deleteChaptersByCouid(int couid);
}
