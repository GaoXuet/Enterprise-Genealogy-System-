package cn.sql.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;

import cn.sql.mapper.TCorpMapper;
import cn.sql.mapper.TCorpTZMapper;
import cn.sql.mapper.TMCorpCorpStockMapper;
import cn.sql.pojo.TCorp;
import cn.sql.pojo.TCorpStock;
import cn.sql.pojo.TMCorpCorpStock;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;

public class Corp_Corp_StockDao {

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
	 * 根据公司id查找出的TMCorpCorpStock主键，生成list list 包含股东名称 和股份
	 */
	// @Test
	public List<TCorpStock> findStockbyCorpIds(TCorp tcorp) throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpTZMapper tctzmapper = openSession.getMapper(TCorpTZMapper.class);

		// System.out.println("开始进行查找三个表的主键关系。。。。。。。");
		// List<TMCorpCorpStock> tstocks = tcsmapper.findStocks(tcorp.getOrg(),
		// tcorp.getId(), tcorp.getSeqId());
		// System.out.println(tstocks.size() + "~~~~~~~~" + tstocks);
		// for (int i = 0; i < tstocks.size(); i++) {
		// System.out.println(tstocks.get(i).getSubId());
		// }

		System.out.println("开始进行查找股东。。。。。。。");

		List<TCorpStock> realtstock = tctzmapper.findstocks(tcorp.getOrg(), tcorp.getId(), tcorp.getSeqId());
		// for (int i = 0; i < realtstock.size(); i++) {
		// System.out.println(realtstock.get(i).getCountry() + "~" +
		// realtstock.get(i).getId());
		// }
		// System.out.println("股东" + realtstock.size());
		return realtstock;
	}

	/**
	 * 根据企业名称模糊查询
	 */

	// @Test
	public List<TCorp> findCorpbyName_mo(String name) throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpMapper tcsmapper = openSession.getMapper(TCorpMapper.class);

		List<TCorp> tcorp = tcsmapper.findByCorpName_mo(name);
		/**
		 * for (int i = 0; i < tcorp.size(); i++) {
		 * System.out.println(tcorp.get(i).getCorpName()); }
		 */
		openSession.close();
		return tcorp;

	}

	/**
	 * 根据企业id进行详细查询
	 */

	// @Test
	public TCorp findByCorpId(int no) throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpMapper tcsmapper = openSession.getMapper(TCorpMapper.class);

		TCorp tcorp = tcsmapper.findByCorpId(no);
		// System.out.println(tcorp);
		openSession.close();
		return tcorp;
	}

	/**
	 * 获取每一个分页的数据
	 */
	public List<TCorp> getListByPage(@Param("start") int start, @Param("size") int size, @Param("name") String name)
			throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpMapper tcsmapper = openSession.getMapper(TCorpMapper.class);

		List<TCorp> infos = tcsmapper.getTCorpsListByPage(name, start, size);
		for (int i = 0; i < infos.size(); i++) {
			System.out.println(infos.get(i).getCorpName());
		}
		return infos;
	}

	/**
	 * 获取每一个分页的数据
	 */
	public List<TCorp> getListAll() throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpMapper tcsmapper = openSession.getMapper(TCorpMapper.class);

		List<TCorp> infos = tcsmapper.getTCorpsList();
		// for (int i = 0; i < infos.size(); i++) {
		// System.out.println(infos.get(i).getCorpName());
		// }
		return infos;
	}

	/**
	 * 全文检索
	 * 
	 * @param keyword：关键词
	 * @param field：搜索字段
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws InvalidTokenOffsetsException
	 * @throws java.text.ParseException
	 */
	public List<TCorp> SearchIndex(String keyword, int start)
			throws IOException, ParseException, InvalidTokenOffsetsException, java.text.ParseException {
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// System.out.println("开始"+start);
		String url ="C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//index";
		//String url = "E://java my eclipse//Pedigree_tt//WebRoot//index";
		List<TCorp> infos = new ArrayList<TCorp>();
		List<TCorp> in = new ArrayList<TCorp>();

		List<String> field = new ArrayList<String>();

		field.add("id_T_CORP");
		field.add("CORP_NAME");
		field.add("ADDR");
		field.add("OPER_MAN_NAME");
		field.add("EMAIL");
		field.add("REG_CAPI");
		field.add("START_DATE");
		field.add("CORP_STATUS");

		for (String str : field) {
			System.out.println("*************" + str);
			FSDirectory dir = FSDirectory.open(Paths.get(url));
			System.out.println("路径url");
			IndexReader reader = DirectoryReader.open(dir);
			IndexSearcher searcher = new IndexSearcher(reader);// 创建搜索器
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser parser = new QueryParser(str, analyzer);
			parser.setDefaultOperator(QueryParser.AND_OPERATOR);
			Query query = parser.parse(keyword);

			// 关键字高亮显示
			QueryScorer scorer = new QueryScorer(query, str);
			SimpleHTMLFormatter fors = new SimpleHTMLFormatter("<span style=\"color:red;\">", "</span>");
			Highlighter highlighter = new Highlighter(fors, scorer);

			TopDocs hits = searcher.search(query, 2000); // 查找操作

			for (ScoreDoc scoreDoc : hits.scoreDocs) {
				Document doc = searcher.doc(scoreDoc.doc);

				TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), scoreDoc.doc, str,
						analyzer);
				Fragmenter fragment = new SimpleSpanFragmenter(scorer);
				highlighter.setTextFragmenter(fragment);
				// 高亮news_title域
				String str2 = highlighter.getBestFragment(tokenStream, doc.get(str));// 获取高亮的片段，可以对其数量进行限制
				// System.out.println("高亮title："+str2);
				String[] s = new String[8];
				for (int m = 0; m < s.length; m++) {
					s[m] = doc.get(field.get(m));
					if (FID(str) == m) {
						s[m] = str2;
					}
				}
				TCorp info = new TCorp();

				info.setIdTCorp(Integer.parseInt(s[0]));
				info.setCorpName(s[1]);
				info.setAddr(s[2]);
				info.setOperManName(s[3]);
				info.setEmail(s[4]);
				info.setRegCapi(s[5]);
				info.setStartDate(s[6]);
				info.setCorpStatus(s[7]);

				//System.out.println("5555"+doc.get(field.get(1)));
				infos.add(info);

			}

		}

		// System.out.println("总数"+infos.size());
		if (infos.size() - start >= 9) {
			in = infos.subList(start, 9 + start);
		} else {
			in = infos.subList(start, infos.size());
		}
		// System.out.println("数量+"+in.size());
		return in;
	}

	public int SearchNum(String keyword, int start)
			throws IOException, ParseException, InvalidTokenOffsetsException, java.text.ParseException {

		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List<TCorp> infos = new ArrayList<TCorp>();

		List<String> field = new ArrayList<String>();

		field.add("id_T_CORP");
		field.add("CORP_NAME");
		field.add("ADDR");
		field.add("OPER_MAN_NAME");
		field.add("EMAIL");
		field.add("REG_CAPI");
		field.add("START_DATE");
		field.add("CORP_STATUS");

		for (String str : field) {
			//FSDirectory dir = FSDirectory.open(Paths.get("E://java my eclipse//Pedigree_tt//WebRoot//index"));
			FSDirectory dir = FSDirectory.open(Paths.get("C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//index"));
			IndexReader reader = DirectoryReader.open(dir);
			IndexSearcher searcher = new IndexSearcher(reader);// 创建搜索器
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser parser = new QueryParser(str, analyzer);
			parser.setDefaultOperator(QueryParser.AND_OPERATOR);
			Query query = parser.parse(keyword);

			// System.out.println("query:" + query.toString());

			TopDocs hits = searcher.search(query, 2000); // 查找操作

			for (ScoreDoc scoreDoc : hits.scoreDocs) {
				Document doc = searcher.doc(scoreDoc.doc);
				TCorp info = new TCorp();

				info.setIdTCorp(Integer.parseInt(doc.get(field.get(0))));
				info.setCorpName(doc.get(field.get(1)));
				info.setAddr(doc.get(field.get(2)));
				info.setOperManName(doc.get(field.get(3)));
				info.setEmail(doc.get(field.get(4)));
				info.setRegCapi(doc.get(field.get(5)));

				//Date date = sdf.parse(doc.get(field.get(6)));

				info.setStartDate(doc.get(field.get(6)));
				info.setCorpStatus(doc.get(field.get(7)));

				infos.add(info);
			}

		}
		return infos.size();
	}

	public int FID(String str) {
		int index = 0;

		List<String> field = new ArrayList<String>();

		field.add("id_T_CORP");
		field.add("CORP_NAME");
		field.add("ADDR");
		field.add("OPER_MAN_NAME");
		field.add("EMAIL");
		field.add("REG_CAPI");
		field.add("START_DATE");
		field.add("CORP_STATUS");

		for (int a = 0; a < field.size(); a++) {
			if (field.get(a).equals(str)) {
				index = a;
			}
		}
		// System.out.println(index);
		return index;
	}

	/**
	 * 联想功能
	 */
	/**
	 * 获取企业名称联想功能的列表
	 * 
	 * @throws Exception
	 */
	public List<String> getShow(String name) throws Exception {
		setUp();
		SqlSession openSession = factory.openSession();
		TCorpMapper tcsmapper = openSession.getMapper(TCorpMapper.class);

		List<String> tcorp = tcsmapper.getShow_lian(name);

		openSession.close();
		return tcorp;
	}

}
