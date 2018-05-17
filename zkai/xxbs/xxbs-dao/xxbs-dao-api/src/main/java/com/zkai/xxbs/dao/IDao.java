package com.zkai.xxbs.dao;

import com.zkai.xxbs.datamodel.BaseDataModel;
import com.zkai.xxbs.datamodel.PagerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-10 上午 9:53
 **/
public interface IDao {

    /**
     * 创建对象
     * @param model
     */
    void create(BaseDataModel model) throws Exception;

    /**
     * 修改对象
     * @param model
     */
    void update(BaseDataModel model) throws Exception;

    /**
     * 删除对象
     * @param id
     */
    void delete(@Param("id") String id) throws Exception;

    /**
     * 分页查询对象
     * @return
     */
    List<BaseDataModel> queryPaging(PagerModel page) throws Exception;


    /**
     * 按ID查询
     * @param id
     * @return
     */
    BaseDataModel queryById(@Param("id") String id) throws Exception;
}
