package com.common.query;

import com.common.exception.BaseException;
import com.lw.constants.ErrEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/14
 * @Description: com.common.query
 * @version: 1.0
 */
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 784387099544242021L;

    //一页最大显示的数量
    private static final Integer MAX_PAGE_SIZE = 5000;

    //默认一页显示的数量
    private static final Integer DEFAULT_PAGE_SIZE = 1000;

    //升序
    private static final String ASC = "ASC";

    //降序
    private static final String DESC = "DESC";

    //字段
    private String column;

    //排序
    private String sort;

    //当前页
    private Integer currentPage;

    //每页的记录数
    private Integer pageSize;

    //总记录条数
    private Integer totalRecord;

    //主键
    private Long id;

    //创建人
    private String creator;

    //编辑人
    private String operator;

    public String getColumn() {
        if (StringUtils.isBlank(column)) {
            return column;
        }

        Field[] fields = this.getClass().getDeclaredFields();
        column=column.toUpperCase();
        //Stream.of():返回包含单个元素的顺序Stream
        //o->Stream.of(o.getName().split(""):将每个字段分割成单独的字符并封装成Stream流
        //Character.isUpperCase(char ch):判断字符是否是大写字母
        //String toLowerCase():将指定字符串转为全小写
        boolean b = Stream.of(fields).map(
                o -> Stream.of(o.getName().split("")).map(
                        s -> Character.isUpperCase(s.charAt(0)) ? "_" + s.toLowerCase() : s).reduce(String::concat)
                        .get()
        ).anyMatch(f -> column.equals(f.toUpperCase()));

        if (!b) {
            throw new BaseException(ErrEnum.PARAM_ERROR.getCode(), "排序字段必须为该表对应对象字段!");
        }

        return column;

    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSort() {
        if (StringUtils.isBlank(sort)) {
            return sort;
        }
        sort = sort.toUpperCase();
        if (!ASC.equals(sort) && !DESC.equals(sort)) {
            throw new BaseException(ErrEnum.PARAM_ERROR, "排序值必须是ASC或者DESC!");
        }
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getCurrentPage() {
        return (currentPage == null || currentPage < 1) ? 1 : currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return (pageSize == null || pageSize < 1) ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = DEFAULT_PAGE_SIZE;
            return;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
            return;
        }
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    /**
     * 注：总页数和跳过的条数由现有属性计算而来，不应该被用户填写，
     * 故总页数和跳过的条数不设置为BaseQuery的属性
     * 而mybatis根据代理类反射去获取实体类的反射对象的所有get方法，
     * 所以没有该属性，在mybatis的各具体的实现类的xml文件中也可以使用总页数和跳过的条数
     * eg:
     * <if test="column != null and sort != null">
     *     order by ${column} ${sort}
     * </if>
     */

    /**
     * 总页数
     *
     * @return
     */
    public Integer getTotalPage() {
        if (totalRecord == null || totalRecord < 1) {
            return 0;
        }
        Integer tp = totalRecord / getPageSize();
        if (totalRecord % getPageSize() > 0) {
            tp += 1;
        }
        return tp;
    }

    /**
     * 跳过的条数
     *
     * @return
     */
    public Integer getOffset() {
        return (getCurrentPage() - 1) * getPageSize();
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

}
