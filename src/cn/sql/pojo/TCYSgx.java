package cn.sql.pojo;

public class TCYSgx {
	// 说明A公司而言：
	// 在对外投资处personType是A公司的该人员职位
	// 在在外任职处personType是B公司的该人员职位
	private String corpname;// corpname ,personName,personType
	private String personName;

	private String personType;

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}
}