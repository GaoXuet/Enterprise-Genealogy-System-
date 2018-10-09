package cn.sql.pojo;

/**
 * 简化的股东表
 * 
 * @author GaoXT
 *
 */
public class TCorpSimple {

	private String csname;// 被投资的企业
	private String proportion;

	public TCorpSimple() {
		super();
	}

	public TCorpSimple(String csname, String proportion) {
		super();
		this.csname = csname;
		this.proportion = proportion;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public String getBelongDistOrg() {
		// TODO Auto-generated method stub
		return null;
	}
}
