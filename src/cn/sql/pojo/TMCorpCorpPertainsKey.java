package cn.sql.pojo;

public class TMCorpCorpPertainsKey {
    private String id;

    private String seqId;

    private String org;

    private String subOrg;

    private String subId;

    private String subSeqId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId == null ? null : seqId.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getSubOrg() {
        return subOrg;
    }

    public void setSubOrg(String subOrg) {
        this.subOrg = subOrg == null ? null : subOrg.trim();
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
    }

    public String getSubSeqId() {
        return subSeqId;
    }

    public void setSubSeqId(String subSeqId) {
        this.subSeqId = subSeqId == null ? null : subSeqId.trim();
    }
}