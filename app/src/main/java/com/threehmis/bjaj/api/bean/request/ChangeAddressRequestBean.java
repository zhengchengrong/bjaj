package com.threehmis.bjaj.api.bean.request;

/**
 * Created by llz on 2018/1/9.
 */

public class ChangeAddressRequestBean {

    /**
     * city : 广州市
     * province : 广东省
     */

    private String city;
    private String province;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
