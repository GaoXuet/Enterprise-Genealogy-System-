package action;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.sql.dao.Corp_Corp_PertainsDao;
import cn.sql.dao.Corp_Corp_StockDao;
import cn.sql.dao.Corp_DistDao;
import cn.sql.dao.Corp_TouziDao;
import cn.sql.dao.Corp_YisiDao;
import cn.sql.pojo.TCorp;
import cn.sql.pojo.TCorpDist;
import cn.sql.pojo.TCorpPertains;
import cn.sql.pojo.TCorpSimple;
import cn.sql.pojo.TCorpStock;
import util.Constants;
import util.CreateIndex;
import util.StringUtil;

@Controller
@RequestMapping(value = "/InfoController")
public class InfoController implements Serializable {

	// private static ApplicationContext context = new
	// ClassPathXmlApplicationContext("bean.xml");

	/**
	 * 联想功能
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/getShow", method = RequestMethod.POST)
	public void getShow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		Corp_Corp_StockDao ccsDao = new Corp_Corp_StockDao();
		List<String> info = ccsDao.getShow(name);

		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(info));
		out.flush();
		out.close();

	}

	/**
	 * 搜索显示
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	private String search(HttpServletRequest req, HttpServletResponse resp, ModelMap model) throws Exception {
		System.out.println("开始进行search........................");

		req.setCharacterEncoding("utf-8");
		CreateIndex create = new CreateIndex();
		boolean flag = create.createIndex();
		if (flag) {
			String name = req.getParameter("CORP_NAME");
			// System.out.println("**************************************" +
			// name);

			Corp_Corp_StockDao ccsDao = new Corp_Corp_StockDao();

			/**
			 * 分页显示
			 */
			// System.out.println("开始进行获取当前分页........................");
			int currentPage = StringUtil.StringToInt(req.getParameter("currentPage"));
			// System.out.println("第一部分.............currentPage=" +
			// currentPage);
			// int countSize = ccsDao.findCorpbyName_mo(name).size();
			// System.out.println("开始执行第一部分PagingBean.....111.....");
			// System.out.println("开始执行第一部分PagingBean.....222.....");
			// System.out.println("全文检索开始");
			List<TCorp> infos = ccsDao.SearchIndex(name, currentPage);
			// System.out.println(infos.get(0).getCORP_NAME());
			// System.out.println("全文检索成功！"+infos.size());
			int countSize = ccsDao.SearchNum(name, currentPage);
			// System.out.println("全文检索成功！"+infos.size()+","+countSize);

			// List<TCorp> infos = ccsDao.getListByPage(currentPage *
			// Constants.PAGE_SIZE_10, Constants.PAGE_SIZE_10, name);

			// System.out.println("开始执行第一部分PagingBean......333....");
			PagingBean pagingBean = new PagingBean(currentPage, countSize, Constants.PAGE_SIZE_10);
			pagingBean.setPrefixUrl(req.getContextPath() + "/InfoController/findAll/" + name + ".action");
			pagingBean.setAnd(true); // true的时候是&，否是？
			req.setAttribute("infos", infos);
			req.setAttribute("pagingBean", pagingBean);

			int numbers = countSize;

			model.addAttribute("name", name);
			model.addAttribute("numbers", numbers);
		} else {
			model.addAttribute("numbers", 0);
		}
		return "/AgainMain";
	}

	/**
	 * 分页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/findAll/{name}", method = RequestMethod.GET)
	private String findAll(@PathVariable("name") String name, HttpServletRequest req, HttpServletResponse resp,
			ModelMap model) throws Exception {
		req.setCharacterEncoding("utf-8");
		// System.out.println("开始进行findall........................");

		// name = new String(name.getBytes("ISO-8859-1"), "utf8");
		// System.out.println("名称name........................" + name);

		int C = StringUtil.StringToInt(req.getParameter("currentPage"));
		Corp_Corp_StockDao ccsDao = new Corp_Corp_StockDao();
		// int countSize = ccsDao.findCorpbyName_mo(name).size();
		// System.out.println("全文检索开始");
		List<TCorp> infos = ccsDao.SearchIndex(name, C * Constants.PAGE_SIZE_10);
		// System.out.println("全文检索成功！");
		int countSize = ccsDao.SearchNum(name, C * Constants.PAGE_SIZE_10);

		PagingBean pagingBean = new PagingBean(C, countSize, Constants.PAGE_SIZE_10);

		// List<TCorp> infos = ccsDao.getListByPage(C * Constants.PAGE_SIZE_10,
		// Constants.PAGE_SIZE_10, name);

		// System.out.println("2:"+req.getContextPath()+"/InfoController/findAll/"+name+".action");
		pagingBean.setPrefixUrl(req.getContextPath() + "/InfoController/findAll/" + name + ".action");
		pagingBean.setAnd(true); // true的时候是&，否是？

		req.setAttribute("infos", infos);
		req.setAttribute("pagingBean", pagingBean);

		int numbers = countSize;

		model.addAttribute("name", name);
		model.addAttribute("numbers", numbers);

		return "/AgainMain";

	}

	@RequestMapping(value = "/showDetails/{idTCorp}", method = RequestMethod.GET)
	public String showDetails(@PathVariable("idTCorp") String id, HttpServletRequest req, HttpServletResponse resp,ModelMap model)
			throws Exception {
		req.setCharacterEncoding("utf-8");
		int ID = Integer.parseInt(id);
		Corp_Corp_StockDao ccsDao = new Corp_Corp_StockDao();
		TCorp info = ccsDao.findByCorpId(ID);

		req.getSession().setAttribute("info", info);

		String name = info.getCorpName();// 企业名称

		if(name.equals("江苏天冠科技开发公司")){
		/*
		 * 股权结构，存储到json中
		 */
		String BOSS, BSS;
		String max;
		List<TCorpStock> tcorpstock = ccsDao.findStockbyCorpIds(info);
		BSS = guquan(tcorpstock);
		BOSS = BSS.substring(0, BSS.indexOf("|"));
		max = BSS.substring(BSS.indexOf("|") + 1, BSS.length());

		/*
		 * 企业图谱
		 */
		Corp_Corp_PertainsDao ccp = new Corp_Corp_PertainsDao();
		List<TCorpPertains> listQ = ccp.findPertainsbyIds(info);
		createQiye(listQ, name);

		/*
		 * 投资族谱
		 */
		Corp_TouziDao ctd = new Corp_TouziDao();
		List<String> dlist = ctd.getCorp_DWTouziList(info.getCorpName());
		List<String> glist = ctd.getCorp_GuDongList(info.getCorpName());
		touzi(info.getCorpName(), dlist, glist);

		/*
		 * 疑似关系
		 */
		createYisi(name);

		/**
		 * 分支公司
		 */

		List<TCorpDist> listD = fengongsi(info.getOrg(), info.getId(), info.getSeqId());
		req.getSession().setAttribute("listD", listD);

		/**
		 * 分公司地图显示
		 */
		map(listD);
		req.getSession().setAttribute("BOSS", BOSS);
		req.getSession().setAttribute("max", max);
		model.addAttribute("error", "yes");
		}else{
			model.addAttribute("error", "error");
		}
		return "/searchDetails";

	}

	/**
	 * 企业图谱
	 */
	public static void createQiye(List<TCorpPertains> list, String name) {
		String qiye = "";///////////////////////////// 需要从给出的list中组装成一种结构
		JSONObject json = new JSONObject(new LinkedHashMap());
		/**
		 * 董事，法人代表，总经理，高管，监事，执行董事兼股东，副总经理
		 */
		String[] info = new String[1000];
		int[] rela = new int[1000];
		for (int n = 0; n < rela.length; n++) {
			rela[n] = -1;
		}

		// 将list中的职称和人名均放到info数组中
		info[0] = name;
		info[1] = "董事长";
		info[2] = "法人";
		info[3] = "总经理";
		info[4] = "高管";
		info[5] = "监事";
		info[6] = "裁判文书";
		info[7] = "副总经理";
		info[8] = "副董事长";
		System.out.println("list.size:" + list.size());
		for (int i = 9; i < list.size() + 9; i++) {// list从这里引用
			// System.out.println("i:"+i);
			info[i] = list.get(i - 9).getPersonName();
		}

		/*
		 * System.out.println("info数组为："); int n=0; while(info[n]!=null){
		 * System.out.println(info[n]); n++; }
		 */

		/*-------------------开始---------------------------------*/
		/*-------------------categories---------------------------------*/
		JSONArray categories = new JSONArray();
		for (int i = 0; i < 9; i++) {
			JSONObject c = new JSONObject();
			c.put("name", info[i]);
			categories.add(c);
		}

		/*-------------------nodes---------------------------------*/
		JSONArray nodes = new JSONArray();
		String s = "";
		int i = 0;
		while (info[i] != null) {
			JSONObject n2 = new JSONObject();
			if (i >= 9) {
				// s=findShen(list,info[i]);
				// System.out.println("8之后：s为："+s);
				// System.out.println("对应的下标："+findIndex(info, s));
				n2.put("name", info[i]);

				n2.put("category", findIndex(info, findShen(list, info[i])));
				nodes.add(n2);

			} else {
				n2.put("name", info[i]);
				n2.put("category", i);
				nodes.add(n2);

			}
			i++;
		}

		/*-------------------links---------------------------------*/
		JSONArray links = new JSONArray();
		// 然后循环z，查找相应的序号
		int line = 0;
		i = 9;
		while (info[i] != null) {
			rela[i] = findIndex(info, findShen(list, info[i]));
			i++;
		}
		/*-------------------rela---------------------------------*/
		int u = 1;
		while (u <= 8) {
			JSONObject l2 = new JSONObject();
			l2.put("source", 0);
			l2.put("target", u);
			links.add(l2);
			u++;
		}
		int j = 9;
		while (rela[j] != -1) {
			// 找连接点
			JSONObject l = new JSONObject();
			l.put("source", rela[j]);
			l.put("target", j);
			links.add(l);
			j++;
		}

		json.put("type", "force");
		json.put("categories", categories);
		json.put("nodes", nodes);
		json.put("links", links);

		/*-------------------字符串输出---------------------------------*/
		qiye = json.toString();

		// System.out.println(qiye);
		// write(qiye, "E://java my
		// eclipse//Pedigree_tt//WebRoot//data//qiye//qiye.json");
		//write(qiye, "E://java my eclipse//Pedigree_tt//WebRoot//data//qiye//qiye.json");
		write(qiye, "C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//data//qiye//qiye.json");

	}

	public static String findShen(List<TCorpPertains> list, String name) {
		String shenfen = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPersonName().equals(name)) {
				shenfen = list.get(i).getPersonType();
			}
		}
		// System.out.println("findShen:" + shenfen);
		return shenfen;
	}

	public static int findIndex(String[] str, String name) {
		int index = 0;
		int m = 0;
		while (str[m] != null) {
			if (str[m].equals(name)) {
				index = m;

				break;
			}
			m++;
		}

		// System.out.println("得到下标：" + index);
		return index;
	}

	public static void write(String content, String url) {
		try {
			File file = new File(url);
			if (!file.exists()) {
				file.createNewFile();
				// System.out.println("123");
			}
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			writer.write(content);
			writer.close();
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 疑似关系
	 * 
	 * @throws Exception
	 */
	public static void createYisi(String name) throws Exception {

		// 传送回一个邻接矩阵

		Corp_YisiDao ysd = new Corp_YisiDao();
		List<String> no = ysd.getNo(name);// 节点
		String[][] edge = ysd.getYISI(name, no);// 疑似关系矩阵

		// System.out.println("。。。。。。。。。。。。no的长度为：" + no.size());
		// System.out.println("。。。。。。。。。。。。edge的长度为：" + edge.length);

		/**
		 * // 定义结点 String[] no = new String[9]; no[0] = "江苏星网软件有限公司"; no[1] =
		 * "江苏星网资讯有限公司"; no[2] = "南京韩微云计算技术有限公司"; no[3] = "江苏汉微系统集成有限公司"; no[4]
		 * = "南京星网投资管理企业（有限合伙）"; no[5] = "周炜"; no[6] = "周炜2"; no[7] = "与小郑";
		 * no[8] = "金伟国";
		 * 
		 * // 定义图，即邻接矩阵 String[][] edge = new String[9][9]; for (int i = 0; i <
		 * 9; i++) { for (int j = 0; j < 9; j++) { edge[i][j] = "无"; } }
		 * edge[0][2] = "股东"; edge[5][0] = "股东，法定代表人"; edge[5][1] =
		 * "法定代表人，股东，执行董事，总经理"; edge[6][0] = "执行董事兼总经理"; edge[6][3] = "";
		 * edge[7][1] = "股东"; edge[7][4] = "股东"; edge[7][0] = "股东"; edge[7][3] =
		 * "股东"; edge[7][2] = "法定代表人，董事兼总经理"; edge[8][0] = "监事"; edge[8][2] =
		 * "监事"; edge[8][3] = "";
		 * 
		 */
		String yisi = "";///////////////////////////// 需要从给出的list中组装成一种结构
		JSONObject json = new JSONObject(new LinkedHashMap());

		String[] info = new String[1000];
		int[] rela = new int[1000];
		for (int n = 0; n < rela.length; n++) {
			rela[n] = -1;
		}

		info[0] = name;// name
		info[1] = "公司";
		info[2] = "代表人";

		/*-------------------开始---------------------------------*/
		/*-------------------categories---------------------------------*/
		JSONArray categories = new JSONArray();
		for (int i = 0; i < 3; i++) {
			JSONObject c = new JSONObject(new LinkedHashMap());
			c.put("name", info[i]);
			categories.add(c);
		}

		/*-------------------nodes---------------------------------*/
		JSONArray nodes = new JSONArray();
		for (int i = 0; i < no.size(); i++) {
			JSONObject n2 = new JSONObject(new LinkedHashMap());
			if (i == 0) {
				n2.put("name", name);
				n2.put("symbolSize", 100);
				n2.put("category", 0);
				nodes.add(n2);
			} else {

				n2.put("name", no.get(i));
				// n2.put("symbolSize", 比例);
				n2.put("category", isPeo(no.get(i)));
				nodes.add(n2);
			}
		}

		/*-------------------links---------------------------------*/
		JSONArray links = new JSONArray();
		for (int u = 0; u < no.size(); u++) {
			for (int uu = 0; uu < no.size(); uu++) {
				JSONObject l2 = new JSONObject(new LinkedHashMap());
				if (!(edge[u][uu].equals("") || edge[u][uu] == null)) {// 还需初始化为“无”
					l2.put("source", u);
					l2.put("target", uu);
					l2.put("value", edge[u][uu]);
					links.add(l2);
				}
			}
		}

		json.put("type", "force");
		json.put("categories", categories);
		json.put("nodes", nodes);
		json.put("links", links);

		/*-------------------字符串输出---------------------------------*/
		yisi = json.toString();

		// System.out.println(yisi);
		// write(yisi, "E://java my
		// eclipse//Pedigree_tt//WebRoot//data//yisi//yisi.json");
		//write(yisi, "E://java my eclipse//Pedigree_tt//WebRoot//data//yisi//yisi.json");
		write(yisi, "C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//data//yisi//yisi.json");

	}

	/**
	 * 判断是公司还是人员
	 * 
	 * @param s
	 * @return
	 */
	public static int isPeo(String s) {
		int a = 2;// 表示人名
		if (s.length() > 3) { // 表示公司
			a = 1;
		}
		return a;
	}

	public String guquan(List<TCorpStock> list) {
		// 初始化,之后用list代替
		System.out.println("...................guquan函数" + list.size());
		String a[] = new String[list.size() + 3];
		double Z = 0;
		double Q = 0;
		double D = 0;// 表示三种股东类型分别总计的认缴金额
		a[0] = "自然人股东";
		a[1] = "企业股东";
		a[2] = "大股东";

		double max = 0;
		String name1 = "";
		for (int j = 0; j < list.size(); j++) {
			// max=(max>Double.parseDouble(list.get(j).getStockPercent())?max:Double.parseDouble(list.get(j).getStockPercent()));
			if (max < Double.parseDouble(list.get(j).getStockCapi())) {
				max = Double.parseDouble(list.get(j).getStockCapi());
				name1 = list.get(j).getStockName();
			}
		}
		D = max;

		for (int i = 3; i < list.size() + 3; i++) {

			// System.out.println("。。。。。。。。。。。list stock 现在开始判断股东类型：" +
			// list.get(i - 3).getStockType());

			a[i] = list.get(i - 3).getStockName();
			// System.out.println("。。。。。。。。。。。list stock 现在开始判断认缴金额：" +
			// list.get(i - 3).getStockCapi());

			// 对三种股东类型进行认缴金额的统计
			if ((list.get(i - 3).getStockType().equals("1")) && (!list.get(i - 3).getStockName().equals(name1))) {
				// System.out.println("。。。。。。。。。。。list stock 认缴金额：" + list.get(i
				// - 3).getStockCapi());
				// Z += Double.parseDouble(list.get(i - 3).getStockPercent());
				Z += Double.parseDouble(list.get(i - 3).getStockCapi());
			} else if ((!(list.get(i - 3).getStockType().equals("1")))
					&& (!list.get(i - 3).getStockName().equals(name1))) {
				Q += Double.parseDouble(list.get(i - 3).getStockCapi());
			}
		}

		String guquan = "";
		JSONObject json = new JSONObject();
		// ------------------元素--------------------------
		JSONArray arr = new JSONArray();
		for (int i = 0; i < a.length; i++) {
			JSONObject eobj = new JSONObject();
			eobj.put("name", a[i]);
			arr.add(eobj);
		}

		// ------------------内圈--------------------------
		JSONArray brr = new JSONArray();
		JSONObject eobj3 = new JSONObject();
		eobj3.put("name", "大股东");
		eobj3.put("value", D);
		brr.add(eobj3);

		JSONObject eobj78 = new JSONObject();
		eobj78.put("name", "自然人股东");
		eobj78.put("value", Z);
		brr.add(eobj78);

		JSONObject eobj2 = new JSONObject();
		eobj2.put("name", "企业股东");
		eobj2.put("value", Q);
		brr.add(eobj2);

		// ------------------外圈--------------------------
		JSONArray crr = new JSONArray();
		// 大股东优先
		JSONObject eob1 = new JSONObject();
		eob1.put("name", name1);
		eob1.put("value", max);
		crr.add(eob1);

		// 自然人股东其次
		for (int j = 3; j < a.length; j++) {
			if ((list.get(j - 3).getStockType().equals("1")) && (!a[j].equals(name1))) {
				JSONObject eob = new JSONObject();
				eob.put("name", a[j]);
				/*
				 * System.out.println( "................j" + j +
				 * "list.get(j-3).getStockCapi()" + list.get(j -
				 * 3).getStockCapi());
				 */
				eob.put("value", list.get(j - 3).getStockCapi());
				crr.add(eob);
			}
		}
		// 企业股东最后
		for (int j = 3; j < a.length; j++) {
			if ((!(list.get(j - 3).getStockType().equals("1"))) && (!a[j].equals(name1))) {
				JSONObject eob = new JSONObject();
				eob.put("name", a[j]);
				eob.put("value", list.get(j - 3).getStockCapi());
				crr.add(eob);
			}
		}

		// JSONObject eob = new JSONObject();
		// eob.put("name", "李慧");
		// eob.put("value", 1233);
		// crr.add(eob);

		json.put("c", crr);
		json.put("a", arr);
		json.put("b", brr);

		guquan = json.toString();

		// System.out.println("输出。。。。Z:" + Z + "。。。。。。Q:" + Q + " D:" + D);
		// WebContent/data/1guquan.json
		// write(guquan, "E://java my
		// eclipse//Pedigree_tt//WebRoot//data//guquan//guquan.json");
		//write(guquan, "E://java my eclipse//Pedigree_tt//WebRoot//data//quguan//guquan.json");
		write(guquan, "C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//data//guquan//guquan.json");
		return (name1 + "|" + max);
	}

	/**
	 * 投资族谱
	 * 
	 * @param name，指的是企业名称
	 * @throws Exception
	 */
	public static void touzi(String name, List<String> tlist, List<String> glist) throws Exception {
		System.out.println("开始对外投资...............");
		// System.out.println("infocontroller中的touzi对外投资。。。。。。list1" +
		// list1.size() + "..........." + list1);
		// System.out.println("infocontroller中的touzi股东。。。。。。。list2" +
		// list2.size() + "........." + list2);
		Corp_TouziDao ctd = new Corp_TouziDao();

		String touzi = "";
		JSONObject json = new JSONObject(new LinkedHashMap());
		JSONArray all = new JSONArray();

		/*-----------------对外投资--------------------------*/
		JSONObject duiwai = new JSONObject(new LinkedHashMap());
		JSONArray dui = new JSONArray();// 直接带[]

		List<String> tz1 = new ArrayList<String>();

		for (int i = 0; i < tlist.size(); i++) {// list1:对外投资list
			JSONObject e = new JSONObject(new LinkedHashMap());

			tz1 = ctd.getCorp_DWTouziList(tlist.get(i));

			// System.out.println(tlist.get(i)+"的大小：" + tz1.size());
			/*
			 * for (int j = 0; j < tz1.size(); j++) {
			 * System.out.println("......" + j + "......" + tz1.get(j)); }
			 */

			if (tz1.size() > 0) {// 如果有子节点
				System.out.println("可以找对外投资");
				e.put("name", tlist.get(i));
				e.put("children", getChild(tlist.get(i), 3));

			} else {// 如果无子节点
				System.out.println("不可找对外投资");
				e.put("name", tlist.get(i));
			}
			tz1.clear();
			dui.add(e);
		}

		duiwai.put("name", "对外投资");
		duiwai.put("children", dui);

		/*-----------------股东--------------------------*/
		JSONObject gudong = new JSONObject(new LinkedHashMap());
		JSONArray gu = new JSONArray();// 直接带[]
		List<String> gd1 = new ArrayList<String>();
		for (int i = 0; i < glist.size(); i++) {// list2:股东list
			JSONObject e = new JSONObject(new LinkedHashMap());

			gd1 = ctd.getCorp_GuDongList(glist.get(i));
			System.out.println("大小：" + gd1.size());

			if (gd1.size() > 0) {// 如果是公司作为股东 可能会有子节点
				System.out.println("可找股东：" + gd1.size());
				e.put("name", glist.get(i));
				e.put("children", getChild2(glist.get(i), 3));
			} else {// 如果无股东子节点
				System.out.println("不可找股东");
				e.put("name", glist.get(i));
			}
			gd1.clear();
			gu.add(e);
		}

		gudong.put("name", "股东");
		gudong.put("children", gu);

		all.add(duiwai);
		all.add(gudong);

		json.put("name", name);
		json.put("children", all);
		touzi = JSON.toJSONString(json, SerializerFeature.DisableCircularReferenceDetect);

		// WebContent/data/1guquan.json
		// write(touzi, "E://java my
		// eclipse//Pedigree_tt//WebRoot//data//touzi//touzi.json");
		//write(touzi, "E://java my eclipse//Pedigree_tt//WebRoot//data//touzi//touzi.json");
		write(touzi, "C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//data//touzi//touzi.json");
	}

	/**
	 * 递归查找相应公司的子节点 对外投资找对外投资 股东找股东
	 * 
	 * @param name
	 * @param n,表示递归的限制为最多3层
	 * @return
	 * @throws Exception
	 */
	public static JSONArray getChild(String name, int n) throws Exception {
		Corp_TouziDao ctd = new Corp_TouziDao();
		List<String> list = ctd.getCorp_DWTouziList(name);

		n--;

		JSONArray js = new JSONArray();

		if (n > 0) {

			/*
			 * 得到此name企业的结点list:命名为list3
			 */
			// System.out.println("list数量："+list.size());
			for (int i = 0; i < list.size(); i++) {
				JSONObject j = new JSONObject();
				System.out.println(name + "的子投资分别为：" + list.get(i));
				// System.out.println(list.get(i)+"的大小:" +
				// (ctd.getCorp_DWTouziList(list.get(i))).size());
				if ((ctd.getCorp_DWTouziList(list.get(i))).size() > 0) {// 如果是企业
					System.out.println("有");
					j.put("name", list.get(i));
					j.put("children", getChild(list.get(i), n));
					System.out.println("单（有）：" + j.toString());

				} else {// 如果是人名
					System.out.println("无");
					j.put("name", list.get(i));
					System.out.println("单（无）：" + j.toString());
				}
				System.out.println("总何在：" + j.toString());
				System.out.println("总何改变：" + JSON.toJSONString(j, SerializerFeature.DisableCircularReferenceDetect));
				js.add(j);
				System.out.println(name + "的child孩子：" + js.toString());
			}

			return js;
		}

		return null;
	}

	/**
	 * 股东找股东
	 * 
	 * @param name
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static JSONArray getChild2(String name, int n) throws Exception {
		Corp_TouziDao ctd = new Corp_TouziDao();
		List<String> tsocks = ctd.getCorp_GuDongList(name);

		n--;

		JSONArray js2 = new JSONArray();
		if (n > 0) {

			/*
			 * 得到此name企业的结点list:命名为list3
			 */
			// System.out.println("list股数量："+tsocks.size());
			for (int i = 0; i < tsocks.size(); i++) {
				JSONObject j2 = new JSONObject();
				// System.out.println("股分别为："+tsocks.get(i));
				// System.out.println(tsocks.get(i)+"的大小："+ctd.getCorp_GuDongList(tsocks.get(i)).size());
				if ((ctd.getCorp_GuDongList(tsocks.get(i)).size()) > 0) {
					// 如果是企业
					if (!(tsocks.get(i).equals("") || tsocks.get(i) == null)) {
						j2.put("name", tsocks.get(i));
						j2.put("children", getChild2(tsocks.get(i), n));

						js2.add(j2);
					} //
				} else {// 如果是人名
					j2.put("name", tsocks.get(i));

					js2.add(j2);
				}

				// System.out.println(name+"的child2孩子："+js2.toString());
			}
			return js2;
		}

		return null;
	}

	public void map(List<TCorpDist> list) {
		String map = "";
		JSONObject json = new JSONObject();

		JSONArray arr = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject eobj = new JSONObject();
			String str = list.get(i).getFarePlace();
			eobj.put("name", str.substring(0, str.indexOf("市")));
			eobj.put("value", 10);
			arr.add(eobj);
		}
		json.put("a", arr);

		map = json.toString();
		// write(map, "E://java my
		// eclipse//Pedigree_tt//WebRoot//data//map//map.json");
		//write(map, "E://java my eclipse//Pedigree_tt//WebRoot//data//map//map.json");
		write(map, "C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//data//map//map.json");

	}

	/**
	 * 查询相应的分公司
	 * 
	 * @param corp_NAME
	 * @throws Exception
	 */

	public List<TCorpDist> fengongsi(String org, String id, String seq_id) throws Exception {
		// TODO Auto-generated method stub
		Corp_DistDao cdd = new Corp_DistDao();
		List<TCorpDist> listD = cdd.findCorp_Dist(org, id, seq_id);

		return listD;
	}

}
