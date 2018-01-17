package cn.lv.hgstudy.pojo;

import java.sql.Date;


public class Course implements java.io.Serializable {

	private Integer couId;
	private String couName;
	private String couType;
	private Teacher tea;
	private Integer evaluate;
	private String couImg;
	private String couinfor;
	private String couSchool;
	private Date creatTime;
	private String outline;
	private String outview;
	
	public Course() {
	}

	public Course(String couName, String couType, 
			Integer evaluate, String couImg, String couinfor,String couSchool,String couTeaName) {
		this.couName = couName;
		this.couType = couType;
		this.evaluate = evaluate;
		this.couImg = couImg;
		this.couinfor = couinfor;
		this.couSchool=couSchool;
	}

	public Integer getCouId() {
		return this.couId;
	}

	public void setCouId(Integer couId) {
		this.couId = couId;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouType() {
		return this.couType;
	}

	public void setCouType(String couType) {
		this.couType = couType;
	}


	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public Integer getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(Integer evaluate) {
		this.evaluate = evaluate;
	}

	public String getCouImg() {
		return this.couImg;
	}

	public void setCouImg(String couImg) {
		this.couImg = couImg;
	}

	public String getCouinfor() {
		return this.couinfor;
	}

	public void setCouinfor(String couinfor) {
		this.couinfor = couinfor;
	}


	public String getCouSchool() {
		return couSchool;
	}

	public void setCouSchool(String couSchool) {
		this.couSchool = couSchool;
	}
	
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getOutview() {
		return outview;
	}

	public void setOutview(String outview) {
		this.outview = outview;
	}
	
		
}
