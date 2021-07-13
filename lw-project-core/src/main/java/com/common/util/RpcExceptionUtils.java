package com.common.util;

import com.common.constants.CommonErrorCodeEnum;
import com.common.exception.BaseException;
import com.common.result.SntResult;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.common.util
 * @version: 1.0
 */
public class RpcExceptionUtils {

    public static SntResult getSntResult(Exception e){
        if (e instanceof BaseException){
            return SntResult.fail((BaseException) e);
        }else{
            return SntResult.fail(new BaseException(CommonErrorCodeEnum.UNKNOWN_EXCEPTION.getCode(),CommonErrorCodeEnum.UNKNOWN_EXCEPTION.getDesc()));
        }
    }
}
