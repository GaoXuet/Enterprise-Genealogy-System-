package cn.sql.dao;

import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.sql.mapper.TCorpTZMapper;
import cn.sql.pojo.TCorp;
import cn.sql.pojo.TCorpSimple;
import cn.sql.pojo.TCorpStock;

public class Corp_TouziDao {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 获得对外投资族谱 list
	 * 
	 * @throws Exception
	 */
	@Test
	public List<TCorpSimple> getCorp_DuiwaiList(TCorp info) throws Exception {
		setUp();
		// 投资族谱
		// a对外投资
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCorpTZMapper TZmapper = sqlSession.getMapper(TCorpTZMapper.class);
		// 1把A公司作为本函数的参数
		// 把A公司的三个主键作为findTZ的主键
		// List<TCorp> TCorps = TZmapper.findTZ(info.getOrg(), info.getId(),
		// info.getSeqId());
		// 2 A.setTCorpchilds

		// List<TCorpSimple> TCorps = TZmapper.findTZ1(info.getOrg(),
		// info.getId(), info.getSeqId());

		List<TCorpSimple> TCorps = TZmapper.findTZ1(info.getOrg() + "", info.getId() + "", info.getSeqId() + "");

		/**
		 * int sumMoney=0;
		 * 
		 * List<TCorpSimple> tcs = new ArrayList<TCorpSimple>(); for(int
		 * i=0;i<TCorps.size();i++) { sum+=TCorps.get(i).get9 }
		 **/

		// System.out.println("~~~~~~~~~~~~" + info.getCorpName() +
		// "公司的所有投资公司~~~~~~~~~~~~~");
//		for (int i = 0; i < TCorps.size(); i++) {
//			System.out.println(TCorps.get(i).getBelongDistOrg() + "~~~" + TCorps.get(i).getCsname());
//		}

		return TCorps;
	}

	/**
	 * 获得股东 list
	 * 
	 * @throws Exception
	 */
	@Test
	public List<TCorpStock> getCorp_StockList(String org, String id, String seq_id) throws Exception {
		setUp();
		// 投资族谱
		// a对外投资
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCorpTZMapper TZmapper = sqlSession.getMapper(TCorpTZMapper.class);
		// 1把A公司作为本函数的参数

		List<TCorpStock> TCorpStocks = TZmapper.findstocks(org, id, seq_id);
		// System.out.println("A公司的所有股东");
//		for (int i = 0; i < TCorpStocks.size(); i++) {
//			System.out.println(
//					TCorpStocks.get(i).getStockName() + "出资百分比--数据库未填写" + TCorpStocks.get(i).getStockPercent());
//		}

		sqlSession.close();
		return TCorpStocks;
	}

	// @After
	// public void tearDown() throws Exception {
	// System.out.println("TestEND");
	// }

	// @Test
	public List<String> getCorp_DWTouziList(String name) throws Exception {
		setUp();
		// 投资族谱
		// a对外投资
		// 循环递归
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCorpTZMapper TZmapper = sqlSession.getMapper(TCorpTZMapper.class);
		// 1把A公司作为本函数的参数

		List<String> TCorps = TZmapper.findCorpNameByStockName(name);
		// System.out.println(name + "公司的所有对外投资");
		// for (int i = 0; i < TCorps.size(); i++) {
		// System.out.println(TCorps.get(i));
		// }
		LinkedHashSet<String> set = new LinkedHashSet<String>(TCorps.size());
		set.addAll(TCorps);
		TCorps.clear();
		TCorps.addAll(set);

//		System.out.println(name + "公司的所有对外投资。。。。。。。。。去重");
//		for (int i = 0; i < TCorps.size(); i++) {
//			System.out.println(TCorps.get(i));
//		}
		sqlSession.close();
		return TCorps;
	}

	// @Test
	public List<String> getCorp_GuDongList(String name) throws Exception {
		setUp();
		// 投资族谱
		// b股东列表
		// 循环递归
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCorpTZMapper TZmapper = sqlSession.getMapper(TCorpTZMapper.class);
		// 1把A公司作为本函数的参数

		List<String> TStocks = TZmapper.findStockNameByStockName(name);
		// System.out.println(name + "公司的所有所有股东");
		// for (int i = 0; i < TStocks.size(); i++) {
		// System.out.println(TStocks.get(i));
		// }

		LinkedHashSet<String> set = new LinkedHashSet<String>(TStocks.size());
		set.addAll(TStocks);
		TStocks.clear();
		TStocks.addAll(set);

//		System.out.println(name + "公司的所有所有股东。。。。。。。。。。去重");
//		for (int i = 0; i < TStocks.size(); i++) {
//			System.out.println(TStocks.get(i));
//		}

		sqlSession.close();
		return TStocks;
	}

	// @Test
	public List<String> getGuDong_CorpList(String name) throws Exception {
		setUp();
		// 投资族谱
		// b人的股东列表
		// 循环递归
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCorpTZMapper TZmapper = sqlSession.getMapper(TCorpTZMapper.class);
		// 1把A公司作为本函数的参数

		List<String> TCorps = TZmapper.findCorpNameByPersonName(name);
//		System.out.println(name + "公司的所有所有股东");
//		for (int i = 0; i < TCorps.size(); i++) {
//			System.out.println(TCorps.get(i));
//		}

		sqlSession.close();
		return TCorps;
	}
}
