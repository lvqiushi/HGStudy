package cn.lv.hgstudy.pojo;



public class Joint implements java.io.Serializable {

	private Integer jid;
	private Integer chapterid;
	private Video video;
	private Integer jointIndex;
	private String jointTitle;
	private String jointInfor;

	public Joint() {
	}

	public Joint(Integer chapter, Video video, Integer jointIndex,
			String jointTitle, String jointInfor) {
		this.chapterid = chapter;
		this.video = video;
		this.jointIndex = jointIndex;
		this.jointTitle = jointTitle;
		this.jointInfor = jointInfor;
	}

	public Integer getJid() {
		return this.jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public Integer getChapterid() {
		return chapterid;
	}

	public void setChapterid(Integer chapterid) {
		this.chapterid = chapterid;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Integer getJointIndex() {
		return this.jointIndex;
	}

	public void setJointIndex(int jointIndex) {
		this.jointIndex = jointIndex;
	}

	public String getJointTitle() {
		return this.jointTitle;
	}

	public void setJointTitle(String jointTitle) {
		this.jointTitle = jointTitle;
	}

	public String getJointInfor() {
		return this.jointInfor;
	}

	public void setJointInfor(String jointInfor) {
		this.jointInfor = jointInfor;
	}

}
