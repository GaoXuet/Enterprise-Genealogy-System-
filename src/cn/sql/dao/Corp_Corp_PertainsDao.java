package cn.sql.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sql.mapper.TMCorpCorpPertainsMapper;
import cn.sql.pojo.TCorp;
import cn.sql.pojo.TCorpPertains;
import cn.sql.pojo.TMCorpCorpPertains;

public class Corp_Corp_PertainsDao {

	private SqlSessionFactory factory;

	// 作用:在测试方法前执行这个方法
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		// 通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/*
	 * 根据公司id，找到所有员工关联关系 然后找出员工 企业族谱
	 */
	@Test
	public List<TCorpPertains> findPertainsbyIds(TCorp tcorp) throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TMCorpCorpPertainsMapper tcsmapper = openSession.getMapper(TMCorpCorpPertainsMapper.class);

		List<TMCorpCorpPertains> tstocks1 = tcsmapper.findCorPertains(tcorp.getOrg(), tcorp.getId(), tcorp.getSeqId());
		// System.out.println(tstocks1.size() + "~~~~~~~~" + tstocks1);

		// TCorpPertainsMapper
		List<TCorpPertains> tstocks2 = tcsmapper.findTCPers1(tstocks1);
		// System.out.println(tstocks2.size() + "~~~~~~~~" + tstocks2);
		// for (int i = 0; i < tstocks2.size(); i++) {
		// System.out.println(tstocks2.get(i).getId() + "!!!");
		// }
		return tstocks2;

	}

}