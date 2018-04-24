/**   
 * @Title: StudentServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月14日 下午2:15:18 
 * @version V1.0   
 */
package cn.lv.hgstudy.service.imp;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.StudentService;
import cn.lv.hgstudy.util.BASE64Encode;
import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.StudentDao;
import cn.lv.hgstudy.pojo.Student;

import java.util.List;

/** 
 * @ClassName: StudentServiceImp 
 * @Description:
 * @author lv
 * @date 2017年9月14日 下午2:15:18 
 *  
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao sdao;
	
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.StudentService#showStudentInfor(java.lang.String)
	 */
	@Override
	public Student showStudentInfor(String stuid) {
		return sdao.selectStudentById(stuid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.StudentService#loginTudent(java.lang.String, java.lang.String)
	 */
	@Override
	public Student loginStudent(String username, String password) {
		Student stu = sdao.selectStudentById(username);
		if(null == stu)
			return null;
		
		if(password.equals(stu.getStuPassword())){
			return stu;
		}
		else
			return null;
	}

	@Override
	public Boolean editStuHeader(String img, String stuId) {
		String imageName = BASE64Encode.DecoderImage(img.split(",")[1]);

		Student student = new Student();
		student.setStuImage(imageName);
		student.setStuId(stuId);
		return sdao.editStuHeader(student);
	}

	@Override
	public Boolean editStudentInfor(Student student) {
		return sdao.editinfor(student);
	}


	@Override
	public List<Student> selectStudentsByCId(Integer couId) {
		return sdao.selectStudentsByCId(couId);
	}

	@Override
	public Student findStuByEmail(String email) {
		return sdao.selectStudentByEmail(email);
	}
}
