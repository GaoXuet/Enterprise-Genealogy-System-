package cn.sql.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.sql.mapper.TCorpDistMapper;
import cn.sql.pojo.TCorpDist;

public class Corp_DistDao {
	private SqlSessionFactory sqlSessionFactory;

	// @Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	// @After
	public void tearDown() throws Exception {
		System.out.println("TestEND");
	}

	/**
	 * 查找企业的子公司 子分支
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	// @Test
	public List<TCorpDist> findCorp_Dist(String org, String id, String seq_id) throws Exception {
		setUp();
		SqlSession sqlSession = sqlSessionFactory.openSession();

		TCorpDistMapper tcmapper = sqlSession.getMapper(TCorpDistMapper.class);
		List<TCorpDist> TCorpDists = tcmapper.findTDS(org, id, seq_id);
		for (int k = 0; k < TCorpDists.size(); k++) {
			System.out.println(TCorpDists.get(k).getDistName() + "~" + TCorpDists.get(k).getFarePlace());
		}

		return TCorpDists;
	}

}
