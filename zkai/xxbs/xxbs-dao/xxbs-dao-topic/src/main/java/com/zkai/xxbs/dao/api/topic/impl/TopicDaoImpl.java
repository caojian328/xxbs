package com.zkai.xxbs.dao.api.topic.impl;

import com.zkai.xxbs.dao.AbstractDao;
import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.dao.api.topic.TopicDao;
import com.zkai.xxbs.dao.mapper.topic.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 题目接口实现
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-26 上午 9:46
 **/
@Repository("topicDao")
public class TopicDaoImpl extends AbstractDao implements TopicDao {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    protected IDao getMapper() {
        return topicMapper;
    }
}
