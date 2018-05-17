package com.zkai.xxbs.service.api.topic.impl;

import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.service.AbstractService;
import com.zkai.xxbs.service.api.topic.TopicAnswerService;
import org.springframework.stereotype.Service;

/**
 * 答案服务接口实现
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:45
 **/
@Service("topicAnswerService")
public class TopicAnswerServiceImpl extends AbstractService implements TopicAnswerService {

    protected IDao getDao() {

        return this.getDaoFactory().getTopicAnswerDao();
    }


}
