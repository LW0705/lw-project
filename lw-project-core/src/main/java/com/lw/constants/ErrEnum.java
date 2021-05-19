package com.lw.constants;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/15
 * @Description: com.lw.constants
 * @version: 1.0
 *
 * 异常枚举
 */
public enum ErrEnum {
    PARAM("10000","参数[%s]缺失,请重新输入!"),
    PARAM_CHECK("10000","参数[%s]不能修改,请重新输入"),
    PARAM_ERROR("10000","参数校验异常，请重新输入"),
    PARAM_INPUT_ERROR("10000","参数[%s]入参不正确,请重新输入"),
    NO_PARAM_ERROR("10000","参数不能为空,请重新输入"),
    NOT_FOUND("10001","数据不存在,请刷新重试"),
    NOT_FOUND_ERROR("10001","[%s]数据不存在，请刷新重试"),
    DATA_EXISTS("10002","数据已存在,请重新输入"),
    DATA_EXISTS_ERROR("10002","[%s]数据已存在,请刷新重试"),
    NOT_SESSION("10003","无法获取session,请重新登陆"),
    JSON_PARSE_ERROR("10004","JSON转换异常,请联系管理员"),
    EXCEL_SHEET_ERROR("10005", "上传的excel不能为空"),
    NOT_EDITABLE("10006", "[%s]不可编辑,请重新修改"),
    COMMON("10007","%s"),
    ;

    private final String code;
    private final String msg;

    ErrEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
