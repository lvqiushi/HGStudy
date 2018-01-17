/**   
 * @Title: TeacherServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月13日 下午7:28:50 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lv.hgstudy.dao.TeacherDao;
import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.util.BASE64Encode;

/** 
 * @ClassName: TeacherServiceImp 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年9月13日 下午7:28:50 
 *  
 */
@Service
public class TeacherServiceImp implements TeacherService{
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

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#editTeaHeader(cn.lv.hgstudy.pojo.Teacher)
	 */
	@Transactional
	public boolean editTeaHeader(String img,String teaid) {
		// TODO Auto-generated method stub
		BASE64Encode baseEncoude = new BASE64Encode();
		String imageName = baseEncoude.DecoderImage(img.split(",")[1]);
		System.out.println(imageName);
		Teacher tea = new Teacher();
		tea.setTeaId(teaid);
		tea.setTeaImage(imageName);
		return tdao.editTeaHeader(tea);
	}

}
