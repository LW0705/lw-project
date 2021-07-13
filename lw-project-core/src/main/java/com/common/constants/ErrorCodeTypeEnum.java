package com.common.constants;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.common.constants
 * @version: 1.0
 *
 * 错误码类型
 * 系统|业务|其他
 */
public enum ErrorCodeTypeEnum {

    SYSTEM("SYS","系统"),
    BIZ("BIZ","业务"),
    PARAMETER("PARM","参数"),
    OTHER("O","其他"),
    ;

    private String code;
    private String desc;


    ErrorCodeTypeEnum(String code, String desc) {
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
