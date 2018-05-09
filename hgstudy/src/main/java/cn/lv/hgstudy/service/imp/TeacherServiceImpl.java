/**   
 * @Title: TeacherServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年9月13日 下午7:28:50 
 * @version V1.0   
 */
package cn.lv.hgstudy.service.imp;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lv.hgstudy.dao.TeacherDao;
import cn.lv.hgstudy.pojo.Teacher;
import cn.lv.hgstudy.util.BASE64Encode;

/** 
 * @ClassName: TeacherServiceImp 
 * @Description:
 * @author lv
 * @date 2017年9月13日 下午7:28:50 
 *  
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Resource
	private TeacherDao tdao;
	
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#showTeacherInfor(int)
	 */
	@Override
	public Teacher showTeacherInfor(String teaid) {
		return tdao.selectTeaInforById(teaid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#loginTeacher(int)
	 */
	@Override
	public Teacher loginTeacher(String teaid,String password) {
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
	@Override
	public boolean editTeacher(Teacher tea) {
		return tdao.editinfor(tea);
	}

	@Override
	public Teacher findTeaByEmail(String email) {
		return tdao.selectTeaByEmail(email);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.TeacherService#editTeaHeader(cn.lv.hgstudy.pojo.Teacher)
	 */
	@Transactional
	@Override
	public boolean editTeaHeader(String img,String teaid) {
		String imageName = BASE64Encode.DecoderImage(img.split(",")[1]);

		Teacher tea = new Teacher();
		tea.setTeaId(teaid);
		tea.setTeaImage(imageName);
		return tdao.editTeaHeader(tea);
	}

}
