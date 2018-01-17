/**   
 * @Title: CousewareServiceImp.java 
 * @Package cn.lv.hgstudy.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lv 
 * @date 2017年10月25日 下午4:27:14 
 * @version V1.0   
 */
package cn.lv.hgstudy.service.imp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import cn.lv.hgstudy.service.CoursewareService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.lv.hgstudy.common.Page;
import cn.lv.hgstudy.dao.CoursewareDao;
import cn.lv.hgstudy.pojo.Courseware;

/** 
 * @ClassName: CousewareServiceImp 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lv
 * @date 2017年10月25日 下午4:27:14 
 *  
 */
@Service
public class CoursewareServiceImp implements CoursewareService {

	@Resource
	CoursewareDao coursewaredao;
	
	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.CoursewareService#selectCousewareById(java.lang.String)
	 */
	@Override
	public Courseware selectCousewareById(String coureswareid) {
		return coursewaredao.selectCoursewareById(coureswareid);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.CoursewareService#selectCousewareByCouid(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page selectCousewareByCouid(String couid, Integer start,
			Integer pageNumber) {
		Map map = new HashMap<String, Object>();
		map.put("couid", couid);
		map.put("start", start);
		map.put("pagenumber", pageNumber);
		int number = coursewaredao.selectCourswareTotal(couid);
		Page coursewares = new Page(number, start, pageNumber);
		coursewares.setContents(coursewaredao.selectCoursewareByCouid(map));
		return coursewares;
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.CoursewareService#addCouseware(cn.lv.hgstudy.pojo.Courseware)
	 */
	@Override
	public boolean addCouseware(Courseware crsware,CommonsMultipartFile courseware,String path){
		System.out.println("paht "+path);
		System.out.println("crs "+crsware.getUploader().getTeaId());
		String fileName = courseware.getOriginalFilename();
		String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
		String filename = crsware.getUploader().getTeaId()+System.currentTimeMillis()+"."+prefix;
		File newFile=new File(path+File.separator+filename);
		try {
			courseware.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} catch (IOException e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		crsware.setFileName(courseware.getOriginalFilename());
		crsware.setFilePath(filename);
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		crsware.setTime(date.format(format));
		return coursewaredao.addCourseware(crsware);
	}

	/* (non-Javadoc)
	 * @see cn.lv.hgstudy.service.CoursewareService#delectCouseware(java.lang.String)
	 */
	@Override
	public boolean delectCouseware(String coureswareid) {
		return coursewaredao.deleteCourseware(coureswareid);
	}

}
