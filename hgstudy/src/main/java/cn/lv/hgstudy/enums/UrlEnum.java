package cn.lv.hgstudy.enums;

public enum UrlEnum {
	LIVE_URL(1, "rtmp://123.207.189.242/live");

	private Integer code;
	private String desc;

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}

	UrlEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
