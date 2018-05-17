package com.zkai.xxbs.dao.api.topic.impl;

import com.zkai.xxbs.dao.AbstractDao;
import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.dao.api.topic.TopicAnswerDao;
import com.zkai.xxbs.dao.mapper.topic.TopicAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 答案接口实现
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-26 上午 9:46
 **/
@Repository("topicAnswerDao")
public class TopicAnswerDaoImpl extends AbstractDao implements TopicAnswerDao {

    @Autowired
    private TopicAnswerMapper topicAnswerMapper;

    @Override
    protected IDao getMapper() {

        return this.topicAnswerMapper;
    }
}
