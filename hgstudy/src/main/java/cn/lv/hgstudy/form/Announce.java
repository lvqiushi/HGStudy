package cn.lv.hgstudy.form;

/**   
 * <p> 发送公告表单类 </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/30 22:26   
 * @since V1.0
 */
public class Announce {
	private Integer couId;

	private String content;

	private String title;

	private String teaId;

	public Integer getCouId() {
		return couId;
	}

	public void setCouId(Integer couId) {
		this.couId = couId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}
}
