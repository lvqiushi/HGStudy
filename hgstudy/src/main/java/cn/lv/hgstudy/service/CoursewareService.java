/**   
 * @Title: CoursewareService.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年10月25日 下午3:39:47 
 * @version V1.0   
 */
package cn.lv.hgstudy.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.pojo.Courseware;

/** 
 * @ClassName: CoursewareService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年10月25日 下午3:39:47 
 *  
 */
public interface CoursewareService {
	Courseware selectCousewareById(String coureswareid);
	Page selectCousewareByCouid(String couid,Integer start,Integer pageNumber);
	boolean addCouseware(Courseware couresware,CommonsMultipartFile courseware,String path);
	boolean delectCouseware(String coureswareid);
}
