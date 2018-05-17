package com.zkai.financial.em;


public enum ResponseStatus {

    SUCCESS("0", "操作成功"),
    FAIL("-1", "操作失败");

    private final String code;
    
    private final String msg;

    private ResponseStatus(String val, String info) {
        this.code = val;
        this.msg = info;

    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
