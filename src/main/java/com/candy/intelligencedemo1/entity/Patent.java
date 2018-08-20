package com.candy.intelligencedemo1.entity;

public class Patent {
    private String sqh; //申请号
    private String sqr; // 申请日
    private String gkh; // 公开号
    private String country; // 国别
    private String docType; //文献类型
    private String gkr; //公开日
    private String zflh; //主分类号
    private String qtflh; // 其他分类号
    private String sqren; // 申请人
    private String zlmc; // 专利名称


    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr;
    }

    public String getSqren() {
        return sqren;
    }

    public void setSqren(String sqren) {
        this.sqren = sqren;
    }

    public String getZlmc() {
        return zlmc;
    }

    public void setZlmc(String zlmc) {
        this.zlmc = zlmc;
    }

    public String getSqh() {
        return sqh;
    }

    public void setSqh(String sqh) {
        this.sqh = sqh;
    }

    public String getGkh() {
        return gkh;
    }

    public void setGkh(String gkh) {
        this.gkh = gkh;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getGkr() {
        return gkr;
    }

    public void setGkr(String gkr) {
        this.gkr = gkr;
    }

    public String getZflh() {
        return zflh;
    }

    public void setZflh(String zflh) {
        this.zflh = zflh;
    }

    public String getQtflh() {
        return qtflh;
    }

    public void setQtflh(String qtflh) {
        this.qtflh = qtflh;
    }

    @Override
    public String toString() {
        return "Patent{" +
                "sqh='" + sqh + '\'' +
                ", gkh='" + gkh + '\'' +
                ", country='" + country + '\'' +
                ", docType='" + docType + '\'' +
                ", gkr='" + gkr + '\'' +
                ", zflh='" + zflh + '\'' +
                ", qtflh='" + qtflh + '\'' +
                '}';
    }
}
