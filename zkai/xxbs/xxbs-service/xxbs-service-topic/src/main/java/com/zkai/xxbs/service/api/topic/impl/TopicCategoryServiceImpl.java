package com.zkai.xxbs.service.api.topic.impl;

import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.service.AbstractService;
import com.zkai.xxbs.service.api.topic.TopicCategoryService;
import org.springframework.stereotype.Service;

/**
 * 类别服务接口实现
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:45
 **/
@Service("topicCategoryService")
public class TopicCategoryServiceImpl extends AbstractService implements TopicCategoryService {

    protected IDao getDao() {

        return this.getDaoFactory().getTopicCategoryDao();
    }


}
