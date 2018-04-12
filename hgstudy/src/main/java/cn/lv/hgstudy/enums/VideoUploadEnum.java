package cn.lv.hgstudy.enums;

public enum VideoUploadEnum {

	UPLOAD(1, "普通上传"),
	RE_UPLOAD(2, "重新上传");

	private Integer code;
	private String desc;

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}

	VideoUploadEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
