package com.mezo.athena.demain;

public class AthenaOrgan {
    private Integer id;

    private String organId;

    private String organName;

    private Byte organLevel;

    private String organAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public Byte getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(Byte organLevel) {
        this.organLevel = organLevel;
    }

    public String getOrganAddress() {
        return organAddress;
    }

    public void setOrganAddress(String organAddress) {
        this.organAddress = organAddress == null ? null : organAddress.trim();
    }
}