package com.common.util;

import com.common.constants.ErrorCodeSourceEnum;
import com.common.constants.ErrorCodeTypeEnum;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.common.util
 * @version: 1.0
 * <p>
 * 错误码
 */
public class ErrorCodeUtils {

    /**
     * 获取错误码
     * @param app               应用名
     * @param type              错误码类型
     * @param source            错误源
     * @param errorCode         业务定义的errorCode
     * @return
     *
     * @Deprecated:若某个类或某方法加上该注解后，表示此类或此方法不建议使用，
     * 调用时会出现删除线，但并不代表不能用，只是不推荐使用了。
     */
    @Deprecated
    public static String getErrorCode(String app, ErrorCodeTypeEnum type, ErrorCodeSourceEnum source, String errorCode) {
        return app + "#" + type.getCode() + "#" + source.getCode() + "#" + errorCode;
    }
    
    public static String getErrorCode(String app,String type,String source,String errorCode){
        return app+"#"+type+"#"+source+"#"+errorCode;
    }
    
    public static String getErrorCode(String type,String source,String errorCode){
        String projectName = System.getProperty("project.name");
        if (EmptyUtils.isEmpty(projectName)){
            projectName = "UNKNOWN";
        }
        return getErrorCode(projectName,type,source,errorCode);
    }

    public static String getErrorCode(ErrorCodeTypeEnum type,ErrorCodeSourceEnum source,String errorCode){
        //根据标识的key获取当前系统的属性
        String projectName = System.getProperty("project.name");
        if (EmptyUtils.isEmpty(projectName)){
            projectName="UNKNOWN";
        }
        return getErrorCode(projectName,type.getCode(),source.getCode(),errorCode);
    }


}
