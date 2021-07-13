package com.common.result;

import com.common.dto.BaseDTO;
import com.common.exception.BaseException;
import com.common.query.BaseQuery;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/25
 * @Description: com.common.result
 * @version: 1.0
 * <p>
 * 用于封装像客户端响应结果的类
 */
public class SntResult<T> implements Serializable {

    private static final long serialVersionUID = 5757469067730393446L;

    private static final Pattern MOBILE_PATTERN = Pattern.compile("^1[3-9][0-9]{9}$");

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 查询信息
     */
    private BaseQuery query;

    /**
     * 错误编码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseQuery getQuery() {
        return query;
    }

    public void setQuery(BaseQuery query) {
        this.query = query;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static <T> SntResult ok(T data, BaseQuery query) {
        SntResult sntResult = new SntResult();
        sntResult.setSuccess(true);
        sntResult.setData(data);
        sntResult.setQuery(query);
        return sntResult;
    }

    public static <T> SntResult ok(T data) {
        return ok(data, null);
    }

    public static SntResult ok() {
        return ok(null);
    }

    public static <T> SntResult okOfFormat(T data, BaseQuery query, boolean desensitization) {
        return ok(format(data, desensitization), query);
    }

    public static <T> SntResult okOfFormat(T data, BaseQuery query) {
        return ok(format(data, false), query);
    }

    public static <T> SntResult okOfFormat(T data, boolean desensitization) {
        return okOfFormat(data, null, desensitization);
    }

    public static <T> SntResult okOfFormat(T data) {
        return okOfFormat(data, null);
    }

    public static SntResult fail(String errCode, String errMsg) {
        SntResult sntResult = new SntResult();
        sntResult.setSuccess(false);
        sntResult.setErrCode(errCode);
        sntResult.setErrMsg(errMsg);
        return sntResult;
    }

    public static SntResult fail(BaseException e) {
        return fail(e.getCode(), e.getMsg());
    }


    public static <T> Object format(T data, boolean desensitization) {
        if (null == data) {
            return null;
        }

        if (data instanceof BaseDTO) {
            return dto2MapAndFormat((BaseDTO) data, desensitization);
        }

        if (data instanceof List && ((List) data).size() > 0) {
            List list = new ArrayList<>(((List) data).size());
            ((List) data).forEach(o -> {
                if (null == o) {
                } else if (o instanceof BaseDTO) {
                    list.add(dto2MapAndFormat((BaseDTO) o, desensitization));
                } else if (o instanceof List) {
                    list.add(format(o, desensitization));
                } else {
                    list.add(o);
                }
            });
            return list;
        }
        return data;
    }

    public static Map dto2MapAndFormat(BaseDTO dto, boolean desensitization) {
        if (null == dto) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        //利用反射获取类中的属性
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dto);
        Stream.of(descriptors).map(descriptor -> descriptor.getName()).filter(name -> !"class".equals(name))
                .forEach(name -> {
                    try {
                        Object v = propertyUtilsBean.getNestedProperty(dto, name);
                        if (null == v) {
                        }
                        //js中，数值>9007199254740992会丢失精度
                        else if (v instanceof Long && (Long) v >= 9007199254740992L) {
                            v = v.toString();
                        } else if (v instanceof BigDecimal) {
                            v = v.toString();
                        }
                        //手机号脱敏
                        else if ("loginId".equals(name) || "mobile".equals(name)) {
                            try {
                                String mobile = v.toString();
                                if (desensitization && MOBILE_PATTERN.matcher(mobile).matches()) {
                                    v = mobile.substring(0, 3) + "****" + mobile.substring(7);
                                }
                            } catch (Exception e) {
                            }
                        } else if (v instanceof Date) {
                            v = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(v);
                        } else if (v instanceof BaseDTO) {
                            v = dto2MapAndFormat((BaseDTO) v, desensitization);
                        } else if (v instanceof List) {
                            List tempList = new ArrayList();
                            Iterator iterator = ((List) v).iterator();
                            while (iterator.hasNext()) {
                                Object item = iterator.next();
                                if (null != item && item instanceof BaseDTO) {
                                    iterator.remove();
                                    tempList.add(dto2MapAndFormat((BaseDTO) v, desensitization));
                                }
                            }
                            ((List) v).addAll(tempList);
                        }
                        map.put(name, v);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return map;
    }
}
