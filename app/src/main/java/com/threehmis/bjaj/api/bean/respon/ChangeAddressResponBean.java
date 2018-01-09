package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

/**
 * Created by llz on 2018/1/9.
 */

public class ChangeAddressResponBean {


    /**
     {
     "unitName": "广州市南沙建设工程质量安全监督站",
     "interfaceUrl": "0"
     }
     */

    public String unitName;
    public String interfaceUrl;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }
}
