package com.common.service;

import com.common.dao.BaseDAO;
import com.common.dto.BaseDTO;
import com.common.entity.BaseDO;
import com.common.manager.BaseManager;
import com.common.query.BaseQuery;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/26
 * @Description: com.common.service
 * @version: 1.0
 */
public interface BaseService<M extends BaseManager<DAO, DTO, DO, Query>, DTO extends BaseDTO, DO extends BaseDO, Query extends BaseQuery, DAO extends BaseDAO<DO, Query>> {
    M getManager();

    default Integer save(DTO dto){
        DO d = this.getManager().emptyDO();
        BeanUtils.copyProperties(dto,d);
        return this.getManager().insert(d);
    }

    default Integer delete(Long id){
        return this.getManager().delete(id);
    }

    default Integer update(DTO dto){
        DO d = this.getManager().emptyDO();
        BeanUtils.copyProperties(dto,d);
        return this.getManager().update(d);
    }

    default List<DTO> query(Query query){
        List<DO> doList = this.getManager().query(query);
        List<DTO> dtoList=new ArrayList<>();
        for(DO d : doList) {
            DTO dto = this.getManager().emptyDTO();
            BeanUtils.copyProperties(d,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    default Integer queryCount(Query query){
        return this.getManager().queryCount(query);
    }

    default DTO getById(Long id) {
        DO d = this.getManager().queryById(id);
        if (null == d) {
            return null;
        }
        DTO dto = this.getManager().emptyDTO();
        BeanUtils.copyProperties(d, dto);
        return dto;
    }
}
