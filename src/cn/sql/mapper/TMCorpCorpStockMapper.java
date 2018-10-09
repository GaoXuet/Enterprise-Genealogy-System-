package cn.sql.mapper;

import cn.sql.pojo.TCorpStock;
import cn.sql.pojo.TMCorpCorpStock;
import java.util.List;

public interface TMCorpCorpStockMapper {

	/**
	 * 根据三个企业主键找到股东主键
	 */
	List<TMCorpCorpStock> findStocks(String i, String j, String k);

	/**
	 * 根据股东主键找到股东链表
	 */
	List<TCorpStock> findStocksByCorp_Stock_IDs(List<TMCorpCorpStock> tstocks);
}