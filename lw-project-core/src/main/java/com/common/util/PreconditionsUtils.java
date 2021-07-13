package com.common.util;

import com.common.exception.BaseException;
import com.lw.constants.ErrEnum;
import reactor.util.annotation.Nullable;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/29
 * @Description: com.common.util
 * @version: 1.0
 */
public class PreconditionsUtils {

    /**
     * @Nullable作用： 1.该方法接收空值
     * 2.消除空指针异常
     */
    public static void checkArgument(boolean expression, @Nullable Object... errorArgs) {
        if (!expression) {
            throw new BaseException(ErrEnum.PARAM.getCode(), String.format(ErrEnum.PARAM.getMsg(), errorArgs));
        }
    }

    public static void checkError(boolean expression, @Nullable Object... errorArgs) {
        if (!expression) {
            throw new BaseException(ErrEnum.COMMON.getCode(), String.format(ErrEnum.COMMON.getMsg(), errorArgs));
        }
    }
}
