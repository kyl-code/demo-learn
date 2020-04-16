package org.example.model.form;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author Adam_Guo
 * @Date 2020/4/11
 * @Version 1.0
 **/
public class UploadFileForm implements Serializable {

    private static final long serialVersionUID = -4814037032008550461L;

    private String ecifNo;
    private String phoneNo;
    private Map<String, Object > param1;
    private Map<String, Object > param2;
    private Map<String, Object > param3;
    private Map<String, Object > param4;
    private Map<String, Object > param5;

    public String getEcifNo() {
        return ecifNo;
    }

    public void setEcifNo(String ecifNo) {
        this.ecifNo = ecifNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Map<String, Object> getParam1() {
        return param1;
    }

    public void setParam1(Map<String, Object> param1) {
        this.param1 = param1;
    }

    public Map<String, Object> getParam2() {
        return param2;
    }

    public void setParam2(Map<String, Object> param2) {
        this.param2 = param2;
    }

    public Map<String, Object> getParam3() {
        return param3;
    }

    public void setParam3(Map<String, Object> param3) {
        this.param3 = param3;
    }

    public Map<String, Object> getParam4() {
        return param4;
    }

    public void setParam4(Map<String, Object> param4) {
        this.param4 = param4;
    }

    public Map<String, Object> getParam5() {
        return param5;
    }

    public void setParam5(Map<String, Object> param5) {
        this.param5 = param5;
    }
}
