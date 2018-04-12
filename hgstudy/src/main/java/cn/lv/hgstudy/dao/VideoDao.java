package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.Video;

public interface VideoDao {
	Boolean addVideo(Video video);

	Boolean updateVideo(Video video);

	Boolean delVideo(Integer videoId);

	Video selectVideoByJointId(Integer jointId);
}
