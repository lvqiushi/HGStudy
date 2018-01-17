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
import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.StudentDao;
import cn.lv.hgstudy.pojo.Student;

/** 
 * @ClassName: StudentServiceImp 
 * @Description:
 * @author lv
 * @date 2017年9月14日 下午2:15:18 
 *  
 */
@Service
public class StudentServiceImp implements StudentService {
	@Resource
	StudentDao sdao;
	
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.StudentService#showStudentInfor(java.lang.String)
	 */
	@Override
	public Student showStudentInfor(String stuid) {
		// TODO Auto-generated method stub
		return sdao.selectStudentById(stuid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.StudentService#loginTudent(java.lang.String, java.lang.String)
	 */
	@Override
	public Student loginStudent(String username, String password) {
		// TODO Auto-generated method stub
		Student stu = sdao.selectStudentById(username);
		if(null == stu)
			return null;
		
		if(password.equals(stu.getStuPassword())){
			return stu;
		}
		else
			return null;
	}

}
