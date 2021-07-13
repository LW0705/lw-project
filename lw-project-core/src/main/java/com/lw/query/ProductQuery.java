package com.lw.query;

import com.common.query.BaseQuery;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/24
 * @Description: com.lw.query
 * @version: 1.0
 */
@Data
public class ProductQuery extends BaseQuery {

    private static final long serialVersionUID = 2798368490001231228L;

    /**
     * 产品guid
     */
    private String productGuid;

    /**
     * 产品条形码
     */
    private String productBarCode;

    /**
     * 财务编码
     */
    private String financialCode;

    /**
     * 产品名称（简称）
     */
    private String productName;

    /**
     * 产品名称（全称）
     */
    private String productFullName;

    /**
     * wms发货单名称
     */
    private String wmsProductName;

    /**
     * 拼音码
     */
    private String queryPymCode;

    /**
     * 五笔码
     */
    private String queryWbmCode;

    /**
     * 产品属性[system_data_dict表(type=product_property)的value]
     */
    private String productProperty;

    /**
     * 财务编码生成序号
     */
    private Integer financialCodeNumber;

    /**
     * 口味
     */
    private String taste;

    /**
     * 分类id[system_classify的id]
     */
    private Long classifyId;

    /**
     * 产品组合状态[0-单品|1-组合|2-礼包]
     */
    private Integer assembleStatus;

    /**
     * 库存控制[0-非库存产品|1-库存产品]
     */
    private Integer stockStatus;

    /**
     * 产品规格
     */
    private String productSpec;

    /**
     * 净含量(kg)
     */
    private BigDecimal netWeight;

    /**
     * 毛重(kg)
     */
    private BigDecimal grossWeight;

    /**
     * 产品体积(cm3)
     */
    private BigDecimal productVolume;

    /**
     * 产品长度(cm)
     */
    private BigDecimal productLength;

    /**
     * 产品宽度(cm)
     */
    private BigDecimal productWidth;

    /**
     * 产品高度(cm)
     */
    private BigDecimal productHeight;

    /**
     * 整箱体积(cm3)
     */
    private BigDecimal fullBoxVolume;

    /**
     * 整箱长度(m)
     */
    private BigDecimal fullBoxLength;

    /**
     * 整箱宽度(m)
     */
    private BigDecimal fullBoxWidth;

    /**
     * 整箱高度(m)
     */
    private BigDecimal fullBoxHeight;

    /**
     * 整箱重量(kg)
     */
    private String fullBoxWeight;

    /**
     * 大单位
     */
    private String bigUnit;

    /**
     * 小单位
     */
    private String smallUnit;

    /**
     * 箱规
     */
    private BigDecimal changeScale;

    /**
     * 销售方式[计件/计重]
     */
    private String salesType;

    /**
     * 质量保质期
     */
    private Integer qualityPeriod;

    /**
     * 最小质量保质期（安全保质期）
     */
    private Integer minQualityPeriod;

    /**
     * 发货外箱状态[0-不是外箱|1-发货外箱]
     */
    private Integer containerStatus;

    /**
     * 是否有外包装[0-没有|1-有]
     */
    private Integer outerPackStatus;

    /**
     * 成本单价（含税）
     */
    private BigDecimal salesPrice;

    /**
     * 定额单价（不含税）=salesPrice/(1+taxScale)
     */
    private BigDecimal quotaPrice;

    /**
     * 税率
     */
    private String taxScale;

    /**
     * 税率值
     */
    private BigDecimal taxRate;

    /**
     * 产品来源[1:OEM|2:成品|3:分装]
     */
    private Integer productSource;

    /**
     * 电子发票产品类别
     */
    private String invoiceType;

    /**
     * 电子发票编码
     */
    private String invoiceCode;

    /**
     * 验收上限
     */
    private Integer inspectUpper;

    /**
     * 验收下限
     */
    private Integer inspectLower;

    /**
     * check_num
     */
    private Integer checkNum;

    /**
     * 商品SKU[0:是|1：否]
     */
    private Integer productSku;

    /**
     * 单品SKU[0:是|1：否]
     */
    private Integer singleSku;

    /**
     * 风味SKU[0:是|1：否]
     */
    private Integer flavourSku;

    /**
     * 产品标签[A:爆款|B:普通|C:非爆款]
     */
    private String productMark;

    /**
     * 新品SKU[0:是|1：否]
     */
    private Integer newSku;

    /**
     * 财务审核类型[system_data_dict表(type=account_type)的code]
     */
    private Integer accountType;

    /**
     * 产品类型[0:成品|1:包辅料]
     */
    private Integer productType;

    /**
     * 礼包类型[1:常规礼包|2:巨型零食]
     */
    private Integer giftType;

    /**
     * 审批来源[apply:正常申请|dubbo:接口推送|web:无需审批]
     */
    private String auditSource;

    /**
     * 审批状态[-1:审核不通过|0:初始化|1:提交申请|2:产品审核|3:财务审核|4:审核通过]
     */
    private Integer auditStatus;

    /**
     * 是否生效[0:已生效|1:未生效]
     */
    private Integer applyStatus;

    /**
     * 停用状态[0:使用|1:停用]
     */
    private Integer stopStatus;

    /**
     * 是否同步wms[0:已同步|1:未同步]
     */
    private Integer syncStatus;

    /**
     * 版本号，组合礼包专用
     */
    private String dataVersion;

    /**
     * 总览二级目录
     */
    private Long sonCategoryId;

    /**
     * 总览一级目录
     */
    private Long parentCategoryId;

    /**
     * 总览全code
     */
    private String categoryFullCode;

    /**
     * 品牌[system_data_dict（type=belong_company）的code]
     */
    private Integer belongCompany;


    /***********************额外字段***********************/
    /**
     * 箱规(Integer)
     */
    private Integer integerChangeScale;

    public Integer getIntegerChangeScale() {
        if (changeScale != null) {
            return changeScale.intValue();
        }
        return null;
    }

    public void setIntegerChangeScale(BigDecimal changeScale) {
        if (changeScale != null) {
            this.integerChangeScale = changeScale.intValue();
        }
    }
}
