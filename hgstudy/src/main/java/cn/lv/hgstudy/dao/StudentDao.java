package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.Student;

public interface StudentDao {

	boolean editinfor(Student stu);

	Student selectStudentById(String stuid);

	boolean editStuHeader(Student stu);
}
