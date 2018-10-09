package cn.sql.mapper;

import cn.sql.pojo.TCorp;
import java.util.List;

public interface TCorpMapper {

	/**
	 * 获取所有企业信息列表
	 */
	public List<TCorp> getTCorpsList();

	/**
	 * 模糊查询 根据企业名称
	 */
	List<TCorp> findByCorpName_mo(String name);

	/**
	 * 根据企业id查找详细信息
	 * 
	 * @param id
	 * @return
	 */
	TCorp findByCorpId(int id);

	/**
	 * 获取分页
	 */
	List<TCorp> getTCorpsListByPage(String name, int start, int size);

	/**
	 * 获取企业名称联想功能的列表
	 */
	List<String> getShow_lian(String name);
}