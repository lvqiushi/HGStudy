package cn.lv.hgstudy.dao;

import cn.lv.hgstudy.pojo.StuAttention;

public interface StuAttDao {
	Boolean addAttention(StuAttention stuAttention);

	Boolean delAttention(StuAttention stuAttention);

	Integer selectAttention(StuAttention stuAttention);
}
