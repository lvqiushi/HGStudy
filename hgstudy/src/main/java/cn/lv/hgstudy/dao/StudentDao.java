package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.Student;

import java.util.List;

public interface StudentDao {

	boolean editinfor(Student stu);

	Student selectStudentById(String stuid);

	boolean editStuHeader(Student stu);

	List<Student> selectStudentsByCId(Integer couId);

	Student selectStudentByEmail(String email);
}
