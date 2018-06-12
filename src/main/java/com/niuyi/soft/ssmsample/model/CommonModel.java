package com.niuyi.soft.ssmsample.model;


import com.niuyi.soft.ssmsample.util.ConstantUtil;

/**
 * 名称: CommonModel
 * 作者: 牛毅
 * 日期: 2018/6/11 11:12
 * 描述: 状态码和状态信息封装
 */
public class CommonModel {

    private int code;//0:接口请求成功，有数据；1:接口请求成功，无数据

    private String message;//接口请求返回提示信息

    private Object data;//接口请求返回数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess() {
        setCode(ConstantUtil.CODE_SUCCESS);
        setMessage(ConstantUtil.MSG_SUCCESS);
    }

    public void setFail() {
        setCode(ConstantUtil.CODE_FAIL);
        setMessage(ConstantUtil.MSG_FAIL);
    }
}
