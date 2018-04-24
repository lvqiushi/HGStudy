/**   
 * @Title: TeacherService.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO
 * @author lv 
 * @date 2017年9月13日 下午7:28:23 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import cn.lv.hgstudy.pojo.Teacher;

/** 
 * @ClassName: TeacherService 
 * @Description: TODO
 * @author lv
 * @date 2017年9月13日 下午7:28:23 
 *  
 */

public interface TeacherService {
	Teacher showTeacherInfor(String teaid);
	Teacher loginTeacher(String username,String password);
	boolean editTeaHeader(String img,String teaid);
	boolean editTeacher(Teacher tea);
	Teacher findTeaByEmail(String email);
}
