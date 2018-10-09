package cn.sql.mapper;

import java.util.List;

import cn.sql.pojo.TCYSgx;

public interface TCYSgxMapper {
	/**
	 * 主要人员在外投资
	 */
	List<TCYSgx> getRYTZ(String i, String j, String k);

	/**
	 * 主要人员在外任职
	 */
	List<TCYSgx> getYSRZ(String i, String j, String k);
}
