package com.zkai.xxbs.datamodel;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据模型基类
 *
 * @author 曹健【115359178@qq.com】
 * @create 201702 上午 9:49
 **/
@Data
public class BaseDataModel implements Serializable {

    protected String id;

    protected Date createTime;

    protected Date lastUpdateTime;

}
