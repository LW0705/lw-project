package com.common.util;

import com.common.exception.BaseException;
import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/27
 * @Description: com.common.util
 * @version: 1.0
 */
public class ParamUtils {

    /**
     * bean类型转换
     *
     * @param targetBean
     * @param destClass
     * @param <T>
     * @param <D>
     * @return
     */
    public static <T, D> D convert(T targetBean, Class<D> destClass) {
        if (null == targetBean) {
            return null;
        }

        try {
            D d = destClass.newInstance();
            BeanUtils.copyProperties(targetBean, d);
            return d;
        } catch (Exception e) {
            throw new BaseException("convert error!", e);
        }

    }

    /**
     * bean类型转换
     *
     * @param targetList
     * @param destClass
     * @param <T>
     * @param <D>
     * @return
     */
    public static <T, D> List<D> convert(List<T> targetList, Class<D> destClass) {
        if (EmptyUtils.isEmpty(targetList)) {
            return Collections.emptyList();
        }

        List<D> destList = new ArrayList<>();
        try {
            for (T targetBean : targetList) {
                D d = destClass.newInstance();
                BeanUtils.copyProperties(targetBean, d);
                destList.add(d);
            }

        } catch (Exception e) {
            throw new BaseException("convert error!", e);
        }
        return destList;

    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 根据财务编码获取版本号
     *
     * @param financialCode
     * @param dataVersion
     * @return
     */
    public static String getDataVersion(String financialCode, String dataVersion) {
        if (EmptyUtils.isEmpty(financialCode)) {
            return null;
        }
        String newVersion;
        if (EmptyUtils.isEmpty(dataVersion)) {
            dataVersion = DateUtils.date2Str(new Date(), DateUtils.DATE_FORMAT_MTH);
            newVersion = String.format("%s%s001", financialCode, dataVersion);
        } else {
            //版本号+1
            int minusLength = dataVersion.length() - financialCode.length();
            if (minusLength == 6) {
                //老版本
                String num = String.format("%03d", Integer.valueOf(dataVersion.substring(dataVersion.length() - 2)) + 1);
                newVersion = String.format("%s%s", dataVersion.substring(0, dataVersion.length() - 2), num);
            } else {
                String num = String.format("%03d", Integer.valueOf(dataVersion.substring(dataVersion.length() - 3)) + 1);
                newVersion = String.format("%s%s", dataVersion.substring(0, dataVersion.length() - 3), num);
            }
        }
        return newVersion;
    }

}
