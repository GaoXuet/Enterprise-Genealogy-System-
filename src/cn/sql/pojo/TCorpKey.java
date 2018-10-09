package cn.sql.pojo;

public class TCorpKey {
    private String org;

    private String id;

    private String seqId;

    private Integer idTCorp;

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

    public Integer getIdTCorp() {
        return idTCorp;
    }

    public void setIdTCorp(Integer idTCorp) {
        this.idTCorp = idTCorp;
    }
}