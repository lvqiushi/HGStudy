package cn.lv.hgstudy.enums;

public enum LiveStatusEnum {

	START(1, "开始直播"),
	STOP(0, "关闭直播");

	private Integer code;
	private String desc;

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}

	LiveStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
