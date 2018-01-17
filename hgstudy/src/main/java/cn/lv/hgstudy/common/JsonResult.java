package cn.lv.hgstudy.common;

public class JsonResult<T> {
	private boolean success;
	private T content;
	private String message;
	private String otherinfor;
	
	public JsonResult() {
		this.success = true;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOtherinfor() {
		return otherinfor;
	}
	public void setOtherinfor(String otherinfor) {
		this.otherinfor = otherinfor;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
