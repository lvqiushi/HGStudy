package cn.lv.hgstudy.pojo;

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
	private String creatTime;
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

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
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
}
