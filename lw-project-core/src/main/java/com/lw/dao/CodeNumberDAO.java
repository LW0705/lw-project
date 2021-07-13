package com.lw.dao;

import com.lw.entity.CodeNumberDO;
import com.lw.query.CodeNumberQuery;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface CodeNumberDAO {

    /**
     * 根据名称获取编码
     *
     * @param query
     * @return
     */
    CodeNumberDO getCodeByName(CodeNumberQuery query);

    /**
     * 更新编码
     *
     * @param codeNumberDO
     * @return
     */
    Integer updateCodeByName(CodeNumberDO codeNumberDO);
}
