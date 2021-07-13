package com.common.manager;

import com.common.dao.BaseDAO;
import com.common.exception.BaseException;
import com.common.util.EmptyUtils;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/25
 * @Description: com.common.manager
 * @version: 1.0
 */
public class BaseManager<DAO extends BaseDAO<DO, Query>, DTO, DO, Query> {
    //若使用private 则其子类无法使用该dao
    protected final DAO dao;
    private Class<DTO> dto;
    private Class<DO> d;

    public BaseManager(DAO dao, Class<DTO> dto, Class<DO> d) {
        this.dao = dao;
        this.dto = dto;
        this.d = d;
    }

    public DTO emptyDTO() {
        try {
            return this.dto.newInstance();
        } catch (Exception e) {
            throw new BaseException(e);
        }
    }

    public DO emptyDO() {
        try {
            return this.d.newInstance();
        } catch (Exception e) {
            throw new BaseException(e);
        }
    }

    public Integer insert(DO d) {
        return this.dao.insert(d);
    }

    public Integer delete(Long id) {
        return this.dao.delete(id);
    }

    public Integer update(DO d) {
        return this.dao.update(d);
    }

    public List<DO> query(Query q) {
        return this.dao.query(q);
    }

    public Integer queryCount(Query q) {
        return this.dao.queryCount(q);
    }

    /**
     * DAO extends BaseDAO时必须注明BaseDAO<DO,Query>的原因：
     * 不注明则说明BaseDAO里可以是object类型，在调用dao.queryById时返回的类型只能是object，
     * 返回DO则报错
     *
     * @param id
     * @return
     */
    public DO queryById(Long id) {
        EmptyUtils.dealEmptyData(id, "id不能为空!");
        return this.dao.queryById(id);
    }
}
