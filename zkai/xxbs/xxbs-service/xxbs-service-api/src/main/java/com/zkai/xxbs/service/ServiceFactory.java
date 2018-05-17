package com.zkai.xxbs.service;

import com.zkai.xxbs.service.api.topic.TopicAnswerService;
import com.zkai.xxbs.service.api.topic.TopicCategoryService;
import com.zkai.xxbs.service.api.topic.TopicService;
import com.zkai.xxbs.service.api.user.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 服务工厂
 *
 * @author 曹健【11539178@qq.com】
 * @create 2017-06-28 上午 9:39
 **/
@Data
@Component
public class ServiceFactory {

    @Autowired
    private UserService userService;

    @Autowired
    private TopicAnswerService topicAnswerService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicCategoryService topicCategoryService;
}
