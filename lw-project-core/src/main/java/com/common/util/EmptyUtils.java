package com.common.util;

import com.common.exception.BaseException;
import com.common.result.SntResult;
import com.lw.constants.ErrEnum;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/25
 * @Description: com.common.util
 * @version: 1.0
 */
@Slf4j
public class EmptyUtils {

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        } else if (obj instanceof StringBuffer && ((StringBuffer) obj).length() == 0) {
            return true;
        } else if (obj instanceof StringBuilder && ((StringBuilder) obj).length() == 0) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 非空校验并打印错误日志
     *
     * @param obj
     * @param checkMessage
     * @return true:空  false:非空
     */
    public static boolean checkEmprt(Object obj, String checkMessage) {
        if (isEmpty(obj)) {
            log.error(checkMessage);
            return true;
        }
        return false;
    }

    /**
     * 非空校验，空则抛出异常
     * 非空不返回数据
     *
     * @param obj
     * @param errMsg
     */
    public static void dealEmptyData(Object obj, String errMsg) {
        if (isEmpty(obj)) {
            throw new BaseException(ErrEnum.PARAM_ERROR.getCode(), errMsg);
        }
    }

    /**
     * 非空校验,空则抛出异常
     * 非空返回数据
     *
     * @param obj
     * @param errMsg
     * @param <T>
     * @return
     */
    public static <T> T dealEmptyDataReturn(T obj, String errMsg) {
        dealEmptyData(obj, errMsg);
        return obj;
    }

    /**
     * 非空校验，空则抛出异常
     * 非空返回结果
     *
     * @param obj
     * @param errMsg
     * @return
     */
    public static SntResult dealEmptyDataResult(Object obj, String errMsg) {
        dealEmptyData(obj, errMsg);
        return SntResult.ok(obj);
    }


}
