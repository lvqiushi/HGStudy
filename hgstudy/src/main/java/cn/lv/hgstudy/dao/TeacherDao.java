package cn.lv.hgstudy.dao;

import java.util.List;

import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.pojo.Course;

public interface TeacherDao {
	boolean editinfor(Teacher tea);
	boolean editTeaHeader(Teacher tea);
	Teacher selectTeacherById(String teaid);
	Teacher selectTeaInforById(String teaid);
	Teacher selectTeaByEmail(String email);
}
