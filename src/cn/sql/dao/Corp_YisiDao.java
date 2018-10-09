package cn.sql.dao;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.support.IdTimestampMessageHeaderInitializer;

import cn.sql.mapper.TCYSgxMapper;
import cn.sql.pojo.TCYSgx;

/*
 Test1通过企业联合主键找到   企业-股东的联合主键
 投资疑似
 */

public class Corp_YisiDao {
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

	@Test
	/**
	 * 在外投资情况
	 * 
	 * @throws Exception
	 */
	public void test() throws Exception {
		setUp();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		TCYSgxMapper TZmapper = sqlSession.getMapper(TCYSgxMapper.class);
		System.out.println("在外投资情况");
		List<TCYSgx> ZWTZs = TZmapper.getRYTZ("876", "19191", "9");

		for (int i = 0; i < ZWTZs.size(); i++) {
			System.out.println(ZWTZs.get(i).getCorpname() + "!" + ZWTZs.get(i).getPersonType() + "!"
					+ ZWTZs.get(i).getPersonName());
		}
		System.out.println("在外任职情况");
		// 999999是因为数据表没有设置为19191
		List<TCYSgx> ZWRZs = TZmapper.getYSRZ("876", "999999", "9");
		for (int i = 0; i < ZWRZs.size(); i++) {
			System.out.println(ZWRZs.get(i).getCorpname() + "!" + ZWRZs.get(i).getPersonType() + "!"
					+ ZWRZs.get(i).getPersonName());
		}

		sqlSession.close();
	}

	/**
	 * 1.传过来企业的名字 2.在对外投资的dao里获取对外投资链表 获取股东链表 3.相加个数得n 生成n*n维矩阵 4.遍历对外投资的链表
	 * 获取每一个的对外投资以及股东 5.查找关联 若匹配 则为 1
	 * 
	 * @throws Exception
	 */

	public List<String> getNo(String name) throws Exception {
		Corp_TouziDao ctd = new Corp_TouziDao();
		List<String> no = new ArrayList<String>();
		no.add(name);
		List<String> dw1 = ctd.getCorp_DWTouziList(name);
		List<String> gd1 = ctd.getCorp_GuDongList(name);
		for (int i = 0; i < dw1.size(); i++) {
			no.add(dw1.get(i));
		}
		for (int i = 0; i < gd1.size(); i++) {
			no.add(gd1.get(i));
		}

		System.out.println("..........................矩阵的长度为" + dw1.size());
		return no;
	}

	public String[][] getYISI(String name, List<String> no) throws Exception {
		//System.out.println("开始找"+name+"的疑似关系：");
		Corp_TouziDao ctd = new Corp_TouziDao();
		//System.out.println("................这是" + name + "的对外投资。。。。。。");
		List<String> dw1 = ctd.getCorp_DWTouziList(name);//对外投资
		//System.out.println("对外投资list:");
		for (int i = 0; i <dw1.size(); i++) {
				System.out.println(dw1.get(i));

		}
		//System.out.println("................这是" + name + "的股东。。。。。。");
		List<String> gd1 = ctd.getCorp_GuDongList(name);//股东
		//System.out.println("股东list:");
		for (int i = 0; i <gd1.size(); i++) {
			System.out.println(gd1.get(i));
	}

		int n = dw1.size() + gd1.size();

		int m = no.size();
		//System.out.println("节点数量："+m+"，矩阵中n="+n);
		String[][] yisi = new String[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++)
				yisi[i][j] = "";

		}
		for(int i=1;i<dw1.size();i++){
			yisi[0][i]="对外投资";
		}
		for(int i=dw1.size()+1;i<m;i++){
			yisi[0][i]="股东";
		}
		//System.out.println("在dao里面.......................m......的长度为" + m);

		List<String> list1 = null;
		List<String> list2 = null;
		int index = -1;

		for (int i = 1; i < dw1.size(); i++) {
			//System.out.println("。。。。。。。。这是第" + i + "个对外投资 <"+dw1.get(i)+"> 企业来找股东....");
			list1 = ctd.getCorp_GuDongList(dw1.get(i));
			//System.out.println("。。。。。。。。***" + dw1.get(i) + "****....");

			Collection<String> exists = new ArrayList<String>(list1);
			Collection<String> notexists = new ArrayList<String>(list1);

			exists.removeAll(gd1);
			notexists.removeAll(exists);
			//System.out.println("@@@@@@@@@@@@@@" + notexists);

			for (int j = 0; j < notexists.size(); j++) {
				index = gd1.indexOf(notexists);
				//System.out.println("&&&&&&&&&&&&&&&&&&" + index);
				//System.out.println("存在股东关系，在 "+i+"与"+(j + dw1.size() + +1));
				yisi[i][j + dw1.size() + 1] += "股东";
			}
			list1.clear();
		}
		list1.clear();

		for (int i = 1; i < gd1.size(); i++) {
			//System.out.println("。。。。。。。。这是第" + i + "个股东来找投资企业" + "....");

			list2 = ctd.getCorp_DWTouziList(gd1.get(i));
			//System.out.println("。。。。。。。。***" + gd1.get(i) + "****....");

			Collection<String> exists = new ArrayList<String>(list2);
			Collection<String> notexists = new ArrayList<String>(list2);

			exists.removeAll(dw1);
			notexists.removeAll(exists);
			//System.out.println(notexists);

			for (int j = 0; j < notexists.size(); j++) {
				index = dw1.indexOf(notexists);
				//System.out.println("存在对外投资关系，在 "+(i + dw1.size())+"与"+j);
				yisi[i + dw1.size()][j + 1] += "对外投资";
			}

			list2.clear();
		}
		list2.clear();

		//输出矩阵
	/*	for (int i = 0; i < m; i++) {
			System.out.println((i+1)+","+no.get(i));
			for (int j = 0; j < m; j++)
				System.out.println(yisi[i][j]);
		}*/
		
		
		return yisi;

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TestEND");
	}
}