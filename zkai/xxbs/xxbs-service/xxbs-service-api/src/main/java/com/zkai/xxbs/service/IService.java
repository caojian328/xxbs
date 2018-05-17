package com.zkai.xxbs.service;

import com.zkai.xxbs.datamodel.BaseDataModel;
import com.zkai.xxbs.datamodel.PagerModel;

import java.util.List;

/**
 * 服务总接口
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:39
 **/
public interface IService {


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
    void delete(String id) throws Exception;

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
    BaseDataModel queryById(String id) throws Exception;

}

