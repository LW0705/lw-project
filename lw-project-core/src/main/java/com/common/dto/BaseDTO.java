package com.common.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/13
 * @Description: com.common.dto
 * @version: 1.0
 */
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -4588801059212998523L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 业务类型
     * 用于区分业务，数据隔离
     */
    private Integer bizType;

    /**
     * 扩展字段(存储为json字符串)
     */
    private String extAtt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator(){
        return creator;
    }

    public void setCreator(String creator){
        this.creator=creator;
    }

    public String getOperator(){
        return operator;
    }

    public void setOperator(String operator){
        this.operator=operator;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified=gmtModified;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getExtAtt() {
        return extAtt;
    }

    public void setExtAtt(String extAtt) {
        this.extAtt = extAtt;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
