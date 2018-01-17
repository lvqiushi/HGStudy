package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lv.hgstudy.dao.CourseDao;
import cn.lv.hgstudy.dao.CoursewareDao;
import cn.lv.hgstudy.dao.TeacherDao;
import cn.lv.hgstudy.pojo.Course;
import cn.lv.hgstudy.pojo.Courseware;
import cn.lv.hgstudy.service.imp.CourseServiceImp;
import cn.lv.hgstudy.service.imp.CoursewareServiceImp;

public class TestDao {
	static CourseDao cdao;
	static TeacherDao tdao;
	static CoursewareDao csdao;
	static CoursewareServiceImp cservice;
	static CourseServiceImp cervice;
	@BeforeClass
    public static void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //tdao=ctx.getBean(TeacherDao.class);
        csdao=ctx.getBean(CoursewareDao.class);
        cservice=ctx.getBean(CoursewareServiceImp.class);
    }
	
	@Test
	public void test01(){
		/*Teacher tea = tdao.selectTeacherById(100);
		System.out.println(tea.getTeaName());
		System.out.println(tea.getTeaPassword());
		Teacher tea1 = tdao.selectTeaInforById(100);
		System.out.println("tea1 til"+tea1.getTeaTil());
		System.out.println("tea1 "+tea1.getTeaName());
		System.out.println("tea1 "+tea1.getTeaImage());
		System.out.println("tea1 "+tea1.getTeaPassword());*/
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 0);
		map.put("pagenumber", 4);
		map.put("teaid", 100);
		map.put("sort", "cou.evaluate");
		List<Course> clist = new ArrayList<Course>();
		clist=	cdao.selectCourses(map);
		System.out.println(clist.size());
		for (Course cou : clist) {
			System.out.println(cou.getCouName());
		}
		
	}
	@Test
	public void test02(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 0);
		map.put("pagenumber", 4);
		map.put("couid", 1);
		List<Courseware> cslist = csdao.selectCoursewareByCouid(map);
		for (Courseware cou : cslist) {
			System.out.println(cou.getFileName());
		}
	}
}
