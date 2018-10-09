package cn.sql.mapper;

import java.util.List;

import cn.sql.pojo.TCorpDist;

public interface TCorpDistMapper {
	// 获取子公司
	public List<TCorpDist> findTDS(String a, String b, String c);
}
