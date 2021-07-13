package com.lw.service.impl;

import com.common.exception.BaseException;
import com.common.util.EmptyUtils;
import com.common.util.ParamUtils;
import com.common.util.PinYinUtils;
import com.common.util.PreconditionsUtils;
import com.lw.constants.Constants;
import com.lw.constants.ErrEnum;
import com.lw.dto.ProductDTO;
import com.lw.entity.*;
import com.lw.manager.*;
import com.lw.query.CodeNumberQuery;
import com.lw.query.ProductQuery;
import com.lw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/22
 * @Description: com.lw.service.impl
 * @version: 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductManager productManager;

    @Autowired
    private CodeNumberManager codeNumberManager;

    @Autowired
    private ProductAssembleManager productAssembleManager;

    @Autowired
    private ProductClassifyManager productClassifyManager;

    @Autowired
    private ProductSourceManager productSourceManager;

    @Autowired
    private ProductAssembleVersionManager productAssembleVersionManager;

    @Autowired
    private ProductAssembleLogManager productAssembleLogManager;

    @Autowired
    private ProductCodeManager productCodeManager;

    @Autowired
    private ProductGuidCodeManager productGuidCodeManager;

    @Override
    public ProductManager getManager() {
        return productManager;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(ProductDTO dto) {

        /**
         * 1.校验
         */
        //基础参数校验
        this.checkBaseParam(dto, true);
        //获取登录人信息
        //TODO
        String loginId = "";
        //组合数据校验
        this.checkAssembleList(dto, loginId);
        //分类数据校验
        this.checkClassifyList(dto, loginId);
        //来源数据校验
        this.checkSouceList(dto, loginId);

        /**
         * 2.处理
         */
        //产品条形码处理
        this.codeHandle(dto, loginId,true);
        ProductQuery query = new ProductQuery();
        query.setProductBarCode(dto.getProductBarCode());
        query.setProductName(dto.getProductName());
        ProductDO productDO = productManager.checkExists(query);
        if (EmptyUtils.isNotEmpty(productDO)) {
            throw new BaseException(ErrEnum.DATA_EXISTS_ERROR, "产品名称或条形码");
        }
        //财务编码处理
        this.codeHandle(dto,loginId,false);

        /**
         * 3.数据处理
         */
        if (EmptyUtils.isNotEmpty(dto.getSubList())){
            //批量新增数据至组合礼包表
            productAssembleManager.batchInsert(ParamUtils.convert(dto.getSubList(), ProductAssembleDO.class));
        }
        if (EmptyUtils.isNotEmpty(dto.getClassifyList())){
            //批量新增数据至产品分类表
            productClassifyManager.batchInsert(ParamUtils.convert(dto.getClassifyList(), ProductClassifyDO.class));
        }
        if (EmptyUtils.isNotEmpty(dto.getSourceList())){
            //批量新增数据至产品来源表
            productSourceManager.batchInsert(ParamUtils.convert(dto.getSourceList(), ProductSourceDO.class));
        }

        //礼包组合版本记录
        this.assembleVersionHandler(dto,loginId);
        productDO = ParamUtils.convert(dto, ProductDO.class);
        //新增数据至产品表
        Integer row = productManager.insert(productDO);

        //获取产品编码
        this.getProductCode(dto.getProductGuid());

        //TODO：加入缓存
        ProductDTO cacheDTO = ParamUtils.convert(productDO, ProductDTO.class);

        return row;
    }


    /**
     * 基础参数校验
     *
     * @param dto
     * @param isSave
     * @return
     */
    public boolean checkBaseParam(ProductDTO dto, boolean isSave) {
        PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getProductName()), "productName");
        PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getProductFullName()), "productFullName");

        if (isSave) {
            //生成guid
            dto.setProductGuid(ParamUtils.getUUID());
        } else {
            //校验条形码不能为空
            PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getProductBarCode()), "productCode");
        }

        //校验guid不能为空
        PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getProductGuid()), "productGuid");

        //设置wms发货名称
        if (EmptyUtils.isEmpty(dto.getWmsProductName())) {
            dto.setWmsProductName(dto.getProductName());
        }

        //设置拼音码
        dto.setQueryPymCode(PinYinUtils.getUpperCase(dto.getProductName(), false));
        return true;
    }

    /**
     * 产品组合状态校验
     *
     * @param dto
     * @param loginId
     * @return
     */
    public boolean checkAssembleList(ProductDTO dto, String loginId) {
        PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getAssembleStatus()), "assembleStatus");

        Integer assembleStatus = dto.getAssembleStatus();
        //是否是单品
        boolean isSingle = Constants.ProductAssembleStatusEnum.SINGLE.getKey() == assembleStatus ? true : false;
        //产品组合状态为单品时，组合明细必须为空
        if (isSingle && EmptyUtils.isNotEmpty(dto.getSubList())) {
            throw new BaseException(ErrEnum.PARAM_ERROR);
        }

        //产品组合状态不为单品时，组合明细必须有值
        if (!isSingle && EmptyUtils.isEmpty(dto.getSubList())) {
            throw new BaseException(ErrEnum.PARAM, "subList");
        }

        if (!isSingle) {
            //若为组合，则assembleType的组合状态为单品；为礼包，则assembleType的组合状态为礼包
            String assembleType = assembleStatus == Constants.ProductAssembleStatusEnum.ASSEMBLE.getKey() ?
                    Constants.ProductAssembleTypeEnum.SINGLE.getKey() :
                    Constants.ProductAssembleTypeEnum.GIFTS.getKey();

            dto.getSubList().forEach(item -> {
                item.setAssembleType(assembleType);
                item.setPProductGuid(dto.getProductGuid());
                item.setCreator(loginId);
                item.setOperator(loginId);
            });
        }

        return true;
    }

    /**
     * 分类数据校验
     *
     * @param dto
     * @param loginId
     * @return
     */
    public boolean checkClassifyList(ProductDTO dto, String loginId) {
        PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(dto.getClassifyList()), "classifyList");

        dto.getClassifyList().forEach(item -> {
            PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(item.getClassifyId()), "classifyId");
            PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(item.getClassifyType()), "classifyType");

            item.setCreator(loginId);
            item.setOperator(loginId);
            item.setProductGuid(dto.getProductGuid());

            //如果存在分类列表的元素的分类类型为product,则将该元素的分类id赋给dto
            if (Constants.classifyEnum.PRODUCT.getKey().equals(item.getClassifyType())) {
                dto.setClassifyId(item.getClassifyId());
            }
        });

        return true;
    }

    /**
     * 来源数据校验
     *
     * @param dto
     * @param loginId
     * @return
     */
    public boolean checkSouceList(ProductDTO dto, String loginId) {
        if (EmptyUtils.isNotEmpty(dto.getSourceList())) {
            dto.getSourceList().forEach(item -> {
                PreconditionsUtils.checkArgument(EmptyUtils.isNotEmpty(item.getProductSource()), "productSource");
                item.setCreator(loginId);
                item.setOperator(loginId);
                item.setProductGuid(dto.getProductGuid());
            });
        }

        return true;
    }

    /**
     * 产品条形码/财务编码处理
     *
     * @param dto
     * @param loginId
     * @param isProductBarCode true:productBarCode     false:financial
     */
    public void codeHandle(ProductDTO dto, String loginId, boolean isProductBarCode) {
        if (EmptyUtils.isNotEmpty(dto.getProductBarCode()) && isProductBarCode) {
            return;
        }

        CodeNumberQuery codeNumberQuery = new CodeNumberQuery();
        if (isProductBarCode) {
            codeNumberQuery.setCodeType(Constants.CodeTypeEnum.PRODUCT_BAR_CODE.getKey());
        } else {
            codeNumberQuery.setCodeType(Constants.CodeTypeEnum.FINANCIAL_CODE.getKey());
        }
        codeNumberQuery.setFullName(dto.getProductFullName());
        CodeNumberDO codeNumber = codeNumberManager.getCodeByName(codeNumberQuery);

        if (null == codeNumber || EmptyUtils.isEmpty(codeNumber.getPrefix()) || null == codeNumber.getSize() || null == codeNumber.getCodeNumber()) {
            String msg = isProductBarCode == true ? "产品条形码" : "财务编码";
            throw new BaseException(ErrEnum.COMMON, String.format("该分类下%s生成规则未设置,请联系管理员!", msg));
        }

        Integer number = codeNumber.getCodeNumber() + 1;
        //eg:若codeNumber.getSize()=9，codeNumber.getPrefix()=6，number=220，则该表达式为"%s%09d",即字符串类型开头，数字前面补0，0+数字共九位，
        //所以该表达式为10位数，结果：6000000220
        String code = String.format("%s%0" + codeNumber.getSize() + "d", codeNumber.getPrefix(), number);
        if (isProductBarCode) {
            //设置产品条形码
            dto.setProductBarCode(code);
        } else {
            //设置财务编码
            dto.setFinancialCode(code);
        }

        codeNumber.setCodeNumber(number);
        codeNumber.setOperator(loginId);
        //更新编码
        codeNumberManager.updateCodeByName(codeNumber);

    }

    /**
     * 礼包组合版本记录
     *
     * @param dto
     */
    public void assembleVersionHandler(ProductDTO dto,String loginId){
        String productGuid = dto.getProductGuid();
        //查询该guid对应的最大的版本号
        String version = productAssembleVersionManager.getMaxDataVersion(productGuid);
        String dataVersion = ParamUtils.getDataVersion(dto.getFinancialCode(), version);
        if (EmptyUtils.isEmpty(dataVersion)){
            throw new BaseException(ErrEnum.COMMON,"销售bom版本号生成异常,请联系管理员!");
        }

        //赋值当前版本
        dto.setDataVersion(dataVersion);
        //插入版本记录
        ProductAssembleVersionDO versionDO = ParamUtils.convert(dto, ProductAssembleVersionDO.class);
        versionDO.setDataType(Constants.ProductAssembleVersionEnum.COMMON.getKey());
        versionDO.setCreator(loginId);
        versionDO.setOperator(loginId);
        productAssembleVersionManager.insert(versionDO);

        //插入历史记录
        List<ProductAssembleLogDO> logDOList = ParamUtils.convert(dto.getSubList(), ProductAssembleLogDO.class);
        logDOList.forEach(o->{
            o.setPProductGuid(productGuid);
            o.setDataVersion(dataVersion);
            o.setCreator(loginId);
            o.setOperator(loginId);
        });
        productAssembleLogManager.batchInsert(logDOList);
    }

    public void getProductCode(String productGuid){
        //获取当前可用的编码
        ProductCodeDO codeDO = productCodeManager.getCode();
        //将该编码禁用（代表该编码已经使用过了）
        codeDO.setStatus(0);
        //更新编码
        productCodeManager.update(codeDO);

        ProductGuidCodeDO productGuidCodeDO=new ProductGuidCodeDO();
        productGuidCodeDO.setCode(codeDO.getCode());
        productGuidCodeDO.setProductGuid(productGuid);
        //新增产品编码映射关系数据
        productGuidCodeManager.insert(productGuidCodeDO);
    }

    @Override
    public Integer update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Integer insert(ProductDTO dto) {
        return productManager.insert(ParamUtils.convert(dto,ProductDO.class));
    }


}
