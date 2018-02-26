package cn.lv.hgstudy.service;

import cn.lv.hgstudy.pojo.Video;

/**  
  * <p> (这里用一句话描述这个类的作用) </p>
 *   
  * @author: xiucai（xiucai@maihaoche.com） 
  * @date: 2018/2/26 11:21   
 * @since V1.0
 */
public interface VideoService {
	Boolean uploadVideo(Video video);

	Boolean reUploadVideo(Video video,Integer oldVideoId);

	Video selectVideo(Integer jointId);

	Boolean delVideo(Integer videoId);
}
