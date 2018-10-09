package cn.sql.pojo;

import java.util.Date;

public class TCorpStock extends TCorpStockKey {
    
	private Integer idTCorpStock;

    private String stockType;

    private String country;

    private String certificateType;

    private String certificateNo;

    private String stockName;

    private String stockCapiType;

    private String stockCapi;

    private String stockCapiDollar;

    private String stockCapiRmb;

    private String stockPercent;

    private String stockRateRmb;

    private String stockRateDollar;

    private Date createDate;

    public Integer getIdTCorpStock() {
        return idTCorpStock;
    }

    public void setIdTCorpStock(Integer idTCorpStock) {
        this.idTCorpStock = idTCorpStock;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType == null ? null : stockType.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getStockCapiType() {
        return stockCapiType;
    }

    public void setStockCapiType(String stockCapiType) {
        this.stockCapiType = stockCapiType == null ? null : stockCapiType.trim();
    }

    public String getStockCapi() {
        return stockCapi;
    }

    public void setStockCapi(String stockCapi) {
        this.stockCapi = stockCapi == null ? null : stockCapi.trim();
    }

    public String getStockCapiDollar() {
        return stockCapiDollar;
    }

    public void setStockCapiDollar(String stockCapiDollar) {
        this.stockCapiDollar = stockCapiDollar == null ? null : stockCapiDollar.trim();
    }

    public String getStockCapiRmb() {
        return stockCapiRmb;
    }

    public void setStockCapiRmb(String stockCapiRmb) {
        this.stockCapiRmb = stockCapiRmb == null ? null : stockCapiRmb.trim();
    }

    public String getStockPercent() {
        return stockPercent;
    }

    public void setStockPercent(String stockPercent) {
        this.stockPercent = stockPercent == null ? null : stockPercent.trim();
    }

    public String getStockRateRmb() {
        return stockRateRmb;
    }

    public void setStockRateRmb(String stockRateRmb) {
        this.stockRateRmb = stockRateRmb == null ? null : stockRateRmb.trim();
    }

    public String getStockRateDollar() {
        return stockRateDollar;
    }

    public void setStockRateDollar(String stockRateDollar) {
        this.stockRateDollar = stockRateDollar == null ? null : stockRateDollar.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}