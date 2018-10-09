package cn.sql.pojo;

import java.util.Date;
import java.util.List;

public class TCorpPertains extends TCorpPertainsKey {
    private String certificateType;

    private String personName;

    private String personType;

    private String certificateNo;

    private String selectType;

    private Date holdpostStart;

    private Date holdpostEdn;

    private String sex;

    private String age;

    private String country;

    private Date createDate;

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType == null ? null : personType.trim();
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType == null ? null : selectType.trim();
    }

    public Date getHoldpostStart() {
        return holdpostStart;
    }

    public void setHoldpostStart(Date holdpostStart) {
        this.holdpostStart = holdpostStart;
    }

    public Date getHoldpostEdn() {
        return holdpostEdn;
    }

    public void setHoldpostEdn(Date holdpostEdn) {
        this.holdpostEdn = holdpostEdn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}