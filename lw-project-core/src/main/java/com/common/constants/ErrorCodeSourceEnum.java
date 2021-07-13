package com.common.constants;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.common.constants
 * @version: 1.0
 *
 * 错误源
 * 内部，外部，其他
 */
public enum ErrorCodeSourceEnum {

    INTERNAL("IN","内部"),
    OUTER("OUT","外部"),
    OTHER("O","其他"),
    ;

    private String code;
    private String desc;

    ErrorCodeSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
