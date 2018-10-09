package cn.sql.mapper;

import cn.sql.pojo.TCYSgx;
import cn.sql.pojo.TCorpPertains;
import cn.sql.pojo.TMCorpCorpPertains;
import cn.sql.pojo.TMCorpCorpPertainsExample;
import cn.sql.pojo.TMCorpCorpPertainsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMCorpCorpPertainsMapper {

	// 查找员工信息
	List<TCorpPertains> findTCPers1(List<TMCorpCorpPertains> tstocks);

	// 查找员工关联
	List<TMCorpCorpPertains> findCorPertains(String i, String j, String k);

	// 通过企业 找到员工的大致信息
	public List<TCorpPertains> findTCPers(String org, String id, String seqid);

	// 主要人员在外任职情况
	public List<TCYSgx> getYSRZ(String org, String id, String seqid);

	// 主要人员在外投资情况
	public List<TCYSgx> getRYTZ(String org, String id, String seqid);
}