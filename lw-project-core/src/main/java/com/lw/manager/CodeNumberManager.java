package com.lw.manager;

import com.lw.dao.CodeNumberDAO;
import com.lw.entity.CodeNumberDO;
import com.lw.query.CodeNumberQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class CodeNumberManager  {

    @Autowired
    private CodeNumberDAO codeNumberDAO;

    public CodeNumberDO getCodeByName(CodeNumberQuery query){
        return codeNumberDAO.getCodeByName(query);
    }

    public Integer updateCodeByName(CodeNumberDO codeNumberDO){
        return codeNumberDAO.updateCodeByName(codeNumberDO);
    }

}
