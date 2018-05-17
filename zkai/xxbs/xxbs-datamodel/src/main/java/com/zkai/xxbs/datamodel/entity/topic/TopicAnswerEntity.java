package com.zkai.xxbs.datamodel.entity.topic;

import com.zkai.xxbs.datamodel.BaseDataModel;
import lombok.Data;

/**
 * 答案
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-23 下午 6:02
 **/
@Data
public class TopicAnswerEntity extends BaseDataModel {

    private static final long serialVersionUID = 13153452451253453L;

    private String tid;

    private String content;

    private String attachment;

    private int isCorrect;

}
