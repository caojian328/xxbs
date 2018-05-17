package com.zkai.xxbs.dao.api.topic.impl;

import com.zkai.xxbs.dao.AbstractDao;
import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.dao.api.topic.TopicCategoryDao;
import com.zkai.xxbs.dao.mapper.topic.TopicCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 类别接口实现
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-26 上午 9:46
 **/
@Repository("topicCategoryDao")
public class TopicCategoryDaoImpl extends AbstractDao implements TopicCategoryDao {

    @Autowired
    private TopicCategoryMapper topicCategoryMapper;

    @Override
    protected IDao getMapper() {

        return this.topicCategoryMapper;
    }
}
