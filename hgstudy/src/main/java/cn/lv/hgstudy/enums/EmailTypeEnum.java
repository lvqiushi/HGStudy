package cn.lv.hgstudy.enums;

public enum EmailTypeEnum {
	//请点击邮件内链接地址重新设定密码  -请重新设置密码
	EDIT_PASSWORD(1, "淮工-请重新设置密码","请点击邮件内链接地址重新设定密码\n%s"),
	PUB_MESSAGE(2, "淮工-来自教师的课程公告","");

	private Integer type;
	private String title;
	private String content;

	public Integer getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	EmailTypeEnum(Integer type, String title, String content) {
		this.type = type;
		this.title = title;
		this.content = content;
	}
}
