/**   
 * @Title: TeacherServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月13日 下午7:28:50 
 * @version V1.0   
 */
package cn.lv.hgstudy.service.impl;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.TeacherService;
import org.springframework.stereotype.Service;

import cn.lv.hgstudy.dao.TeacherDao;
import cn.lv.hgstudy.pojo.Teacher;

/** 
 * @ClassName: TeacherServiceImp 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月13日 下午7:28:50 
 *  
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Resource
	TeacherDao tdao;
	
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#showTeacherInfor(int)
	 */
	public Teacher showTeacherInfor(String teaid) {
		// TODO Auto-generated method stub
		return tdao.selectTeaInforById(teaid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#loginTeacher(int)
	 */
	public Teacher loginTeacher(String teaid,String password) {
		// TODO Auto-generated method stub
		Teacher tea = tdao.selectTeacherById(teaid);
		if(null == tea)
			return null;
		
		if(password.equals(tea.getTeaPassword())){
			return tea;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#editTeacher(cn.lv.hgstudy.pojo.Teacher)
	 */
	public boolean editTeacher(Teacher tea) {
		// TODO Auto-generated method stub
		return tdao.editinfor(tea);
	}

}
