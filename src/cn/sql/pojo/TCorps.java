package cn.sql.pojo;

import java.util.Date;

//企业所有信息
public class TCorps extends TCorp {

	/** 企业地址 **/
	private String addr;
	/** 登记机关 **/
	private String belongOrg;

	/** 所属行业 **/
	private String belongTrade;
	/** 公司类型 **/
	private String econKind;
	/** 企业大类 **/
	private String admitMain;
	/** 成立日期 **/
	private String startDate;
	/** 核准日期 **/
	private Date checkDate;

	/** 经营状态（01-在业，02-注销，03-吊销，04-迁出） **/
	private String corpStatus;
	/** 注册资金（单位：万元） **/
	private String regCapi;
	/** 经营期限（起） **/
	private Date fareTermStart;
	/** 经营期限（止） **/
	private String fareTermEnd;
	/** 经营范围 **/
	private String fareScope;
	/** 注册号 **/
	private String uniScid;
	/** 电话 **/
	private String tel;
	/** 官网 **/
	private String webUrl;
	/** 邮箱 **/
	private String email;
	/** 从业人数 **/
	private String pracPersonNum;
	/** 组织机构代码 **/
	private String orgInstCode;
	/** 纳税人识别号 **/
	private String taxpayNum;
	/** 人员规模 **/
	private String staffSize;
	/** 英文名 **/
	private String englishName;
	/** 曾用名 **/
	private String formerName;
	/** 创建时间 **/
	private Date createDate;
	/** 创建机构代码 **/
	private String createOrg;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBelongOrg() {
		return belongOrg;
	}

	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}

	public String getBelongTrade() {
		return belongTrade;
	}

	public void setBelongTrade(String belongTrade) {
		this.belongTrade = belongTrade;
	}

	public String getEconKind() {
		return econKind;
	}

	public void setEconKind(String econKind) {
		this.econKind = econKind;
	}

	public String getAdmitMain() {
		return admitMain;
	}

	public void setAdmitMain(String admitMain) {
		this.admitMain = admitMain;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCorpStatus() {
		return corpStatus;
	}

	public void setCorpStatus(String corpStatus) {
		this.corpStatus = corpStatus;
	}

	public String getRegCapi() {
		return regCapi;
	}

	public void setRegCapi(String regCapi) {
		this.regCapi = regCapi;
	}

	public Date getFareTermStart() {
		return fareTermStart;
	}

	public void setFareTermStart(Date fareTermStart) {
		this.fareTermStart = fareTermStart;
	}

	public String getFareTermEnd() {
		return fareTermEnd;
	}

	public void setFareTermEnd(String fareTermEnd) {
		this.fareTermEnd = fareTermEnd;
	}

	public String getFareScope() {
		return fareScope;
	}

	public void setFareScope(String fareScope) {
		this.fareScope = fareScope;
	}

	public String getUniScid() {
		return uniScid;
	}

	public void setUniScid(String uniScid) {
		this.uniScid = uniScid;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPracPersonNum() {
		return pracPersonNum;
	}

	public void setPracPersonNum(String pracPersonNum) {
		this.pracPersonNum = pracPersonNum;
	}

	public String getOrgInstCode() {
		return orgInstCode;
	}

	public void setOrgInstCode(String orgInstCode) {
		this.orgInstCode = orgInstCode;
	}

	public String getTaxpayNum() {
		return taxpayNum;
	}

	public void setTaxpayNum(String taxpayNum) {
		this.taxpayNum = taxpayNum;
	}

	public String getStaffSize() {
		return staffSize;
	}

	public void setStaffSize(String staffSize) {
		this.staffSize = staffSize;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getFormerName() {
		return formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

}