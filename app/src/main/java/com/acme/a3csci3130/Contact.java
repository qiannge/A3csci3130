package com.acme.a3csci3130;


import java.io.Serializable;

public class Contact implements Serializable {
    public String name;
    public String businessNumber;
    public String primaryBusiness;
    public String address;
    public String province;
    public String id;

    public Contact(){

    }

    public Contact(String name,String businessNumber, String primaryBusiness, String address, String province, String id) {
        this.name = name;
        this.businessNumber = businessNumber;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getPrimaryBusiness() {
        return primaryBusiness;
    }

    public void setPrimaryBusiness(String primaryBusiness) {
        this.primaryBusiness = primaryBusiness;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
