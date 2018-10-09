package cn.sql.mapper;

import java.util.List;

import cn.sql.pojo.TCorp;
import cn.sql.pojo.TCorpSimple;
import cn.sql.pojo.TCorpStock;

public interface TCorpTZMapper {
	/**
	 * 通过A公司主键 找所有A公司的股东
	 */
	List<TCorpStock> findstocks(String i, String j, String k);

	/**
	 * t根据公司名称 找所以股东 return List<String>
	 */
	List<String> findStockNameByStockName(String name);

	/**
	 * 通过A公司主键 找所有A公司投资的公司
	 */
	List<TCorp> findTZ(String i, String j, String k);

	/**
	 * 仅存储 对外投资 公司名称 投资比例
	 */
	List<TCorpSimple> findTZ1(String i, String j, String k);

	/**
	 * 根据公司名称 查找 对外投资的 公司名称 return List<String>
	 */
	List<String> findCorpNameByStockName(String name);

	/**
	 * 根据人名 查找 所在的 公司名称 return List<String>
	 */
	List<String> findCorpNameByPersonName(String name);

}
