package com.zkai.xxbs.datamodel.entity.topic;

import com.zkai.xxbs.datamodel.BaseDataModel;
import lombok.Data;

/**
 * 题目分类
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-23 下午 6:01
 **/
@Data
public class TopicCategoryEntity extends BaseDataModel {

    private static final long serialVersionUID = 13453423451253453L;

    private String uid;

    private String pid;

    private String name;

    private String imageUrl;

}
