package com.zkai.xxbs.dao;

import com.zkai.xxbs.dao.api.topic.TopicAnswerDao;
import com.zkai.xxbs.dao.api.topic.TopicCategoryDao;
import com.zkai.xxbs.dao.api.topic.TopicDao;
import com.zkai.xxbs.dao.api.user.UserDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DAO工厂
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-28 上午 10:16
 **/
@Data
@Component
public class DaoFactory {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private TopicAnswerDao topicAnswerDao;

    @Autowired
    private TopicCategoryDao topicCategoryDao;

}
