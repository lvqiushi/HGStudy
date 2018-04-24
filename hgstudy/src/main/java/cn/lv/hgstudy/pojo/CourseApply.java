package cn.lv.hgstudy.pojo;

import java.time.LocalDateTime;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/15 15:48   
 * @since V1.0
 */
public class CourseApply {
	private Integer applyId;
	private String teaId;
	private String couresName;
	private Integer courseType;
	private LocalDateTime creatTime;
	private LocalDateTime modifiedTime;
	private Integer isDeleted;
	private String teaName;
	private String teaSchool;
	private Integer status;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getCouresName() {
		return couresName;
	}

	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}

	public LocalDateTime getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(LocalDateTime creatTime) {
		this.creatTime = creatTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaSchool() {
		return teaSchool;
	}

	public void setTeaSchool(String teaSchool) {
		this.teaSchool = teaSchool;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCourseType() {
		return courseType;
	}

	public void setCourseType(Integer courseType) {
		this.courseType = courseType;
	}
}
