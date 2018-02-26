package cn.lv.hgstudy.service.imp;

import cn.lv.hgstudy.dao.VideoDao;
import cn.lv.hgstudy.pojo.Video;
import cn.lv.hgstudy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/2/26 11:22   
 * @since V1.0
 */
@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	VideoDao videoDao;

	@Override
	public Boolean uploadVideo(Video video) {
		return videoDao.addVideo(video);
	}

	@Override
	public Boolean reUploadVideo(Video video,Integer oldVideoId) {
		videoDao.delVideo(oldVideoId);
		videoDao.addVideo(video);
		return true;
	}

	@Override
	public Video selectVideo(Integer jointId) {
		return videoDao.selectVideoByJointId(jointId);
	}

	@Override
	public Boolean delVideo(Integer videoId) {
		return videoDao.delVideo(videoId);
	}

}
