package cn.lv.hgstudy.enums;

public enum AttentionEnum {

	ATTENTION(1, "关注"),
	CANCEL(2, "取消关注");

	private Integer code;
	private String desc;

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}

	AttentionEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
