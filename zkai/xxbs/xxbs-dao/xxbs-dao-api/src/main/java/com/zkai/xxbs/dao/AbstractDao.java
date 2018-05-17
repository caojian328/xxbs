package com.zkai.xxbs.dao;

import com.zkai.xxbs.datamodel.BaseDataModel;
import com.zkai.xxbs.datamodel.PagerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-22 上午 11:57
 **/
public abstract class AbstractDao implements IDao {

    protected abstract IDao getMapper();

    @Override
    public void create(BaseDataModel model) throws Exception {
        this.getMapper().create(model);
    }

    @Override
    public void update(BaseDataModel model) throws Exception {
        this.getMapper().update(model);
    }

    @Override
    public void delete(@Param("id") String id) throws Exception {
        this.getMapper().delete(id);
    }

    @Override
    public List<BaseDataModel> queryPaging(PagerModel page) throws Exception {
        return this.getMapper().queryPaging(page);
    }

    @Override
    public BaseDataModel queryById(@Param("id") String id) throws Exception {
        return this.getMapper().queryById(id);
    }
}
