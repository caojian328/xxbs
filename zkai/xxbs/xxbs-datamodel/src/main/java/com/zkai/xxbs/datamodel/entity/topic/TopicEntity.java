package com.zkai.xxbs.datamodel.entity.topic;

import com.zkai.xxbs.datamodel.BaseDataModel;
import lombok.Data;

/**
 * 题目
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-23 下午 6:01
 **/
@Data
public class TopicEntity extends BaseDataModel {

    private static final long serialVersionUID = 13403453451253453L;

    private String uid;

    //类别ID
    private String cid;

    private String topicType;

    private String topicName;

    //附件
    private String attachment;

    private int state;

    //提示
    private String prompt;

    //题目解析
    private String analysis;

}
