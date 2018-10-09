package util;

import java.nio.file.Paths;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;

import cn.sql.dao.Corp_Corp_StockDao;
import cn.sql.pojo.TCorp;

import org.apache.lucene.analysis.Analyzer;
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
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;

public class CreateIndex {

	/**
	 * 创建索引
	 * 
	 * @return
	 */

	public static boolean createIndex() {
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = false;
		try {
			Corp_Corp_StockDao infoDao = new Corp_Corp_StockDao();
			List<TCorp> list = infoDao.getListAll();
			//Directory dir = FSDirectory.open(Paths.get("E://java my eclipse//Pedigree_tt//WebRoot//index")); // 存储索引的路径
			Directory dir = FSDirectory.open(Paths.get("C://Program Files//Tomcat 8.0//webapps//Pedigree_tt//index")); // 存储索引的路径

			Analyzer analyzer = new StandardAnalyzer(); // 无参构造函数
			IndexWriterConfig iwc = new IndexWriterConfig(analyzer); // 新的IndexWriter配置类
			iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE); // 创建模式打开
			// iwc.setRAMBufferSizeMB(256.0); //
			// 设置内存缓存的大小，提高索引效率，不过如果修改过大的值，需要修改JVM的内存值
			IndexWriter writer = new IndexWriter(dir, iwc); // 创建IndexWriter

			for (TCorp item : list) {

				Document doc = new Document();
				doc.add(new TextField("id_T_CORP", item.getIdTCorp() + "", Field.Store.YES));
				doc.add(new TextField("CORP_NAME", item.getCorpName(), Field.Store.YES));
				doc.add(new TextField("ADDR", item.getAddr(), Field.Store.YES));
				doc.add(new TextField("OPER_MAN_NAME", item.getOperManName(), Field.Store.YES));
				doc.add(new TextField("EMAIL", item.getEmail(), Field.Store.YES));
				doc.add(new TextField("REG_CAPI", item.getRegCapi() + "", Field.Store.YES));
				doc.add(new TextField("START_DATE", item.getStartDate(), Field.Store.YES));
				doc.add(new TextField("CORP_STATUS", item.getCorpStatus(), Field.Store.YES));

				writer.addDocument(doc);
			}

			writer.close();
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}
