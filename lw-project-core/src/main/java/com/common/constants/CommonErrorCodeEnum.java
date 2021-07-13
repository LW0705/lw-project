package com.common.constants;

import com.common.util.ErrorCodeUtils;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.common.constants
 * @version: 1.0
 */
public enum CommonErrorCodeEnum {

    DING_TALK_SEND_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.OTHER, ErrorCodeSourceEnum.OTHER, "999992"), "钉钉发送异常"),
    DB_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999993"), "数据库异常"),
    INVALID_PARAM(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.PARAMETER, ErrorCodeSourceEnum.INTERNAL, "999994"), "参数不合法"),
    SIGN_NOT_CORRECT(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999995"), "签名校验失败"),
    TOKEN_NOT_CORRECT(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999996"), "Token校验失败"),
    NO_PERMISSION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999997"), "没有权限"),
    NO_SESSION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999998"), "没有登陆"),
    UNKNOWN_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999999"), "未知异常"),
    FLOW_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999990"), "请求过于频繁，请稍后重试（限流了）。"),
    DEGRADE_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999989"), "系统熔断降级，请稍后重试（熔断了）。"),
    PARAMFLOW_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "9999898"), "热点限流，请稍后重试（热点限流了）。"),
    AUTHORITY_EXCEPTION(ErrorCodeUtils.getErrorCode(ErrorCodeTypeEnum.SYSTEM, ErrorCodeSourceEnum.OTHER, "999987"), "授权限制了（限流了）。"),
    ;

    private String code;

    private String desc;

    CommonErrorCodeEnum(String code, String desc) {
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
