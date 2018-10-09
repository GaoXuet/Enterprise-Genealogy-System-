package cn.sql.pojo;

public class TCorpPertainsKey {
    private Integer idTCorpPertains;

    private String org;

    private String id;

    private String seqId;

    public Integer getIdTCorpPertains() {
        return idTCorpPertains;
    }

    public void setIdTCorpPertains(Integer idTCorpPertains) {
        this.idTCorpPertains = idTCorpPertains;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

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
}