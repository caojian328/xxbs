package com.zkai.xxbs.service;

import com.zkai.xxbs.dao.DaoFactory;
import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.datamodel.BaseDataModel;
import com.zkai.xxbs.datamodel.PagerModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-22 下午 4:08
 **/
public abstract class AbstractService implements IService{

    @Autowired
    private DaoFactory daoFactory;

    protected abstract IDao getDao();


    @Override
    public void create(BaseDataModel model)throws Exception{

        this.getDao().create(model);
    }

    @Override
    public void update(BaseDataModel model)throws Exception {
        this.getDao().update(model);
    }

    @Override
    public void delete(String id)throws Exception {
        this.getDao().delete(id);
    }

    @Override
    public List<BaseDataModel> queryPaging(PagerModel page)throws Exception {
        return this.getDao().queryPaging(page);
    }

    @Override
    public BaseDataModel queryById(String id) throws Exception {
        return this.getDao().queryById(id);
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
