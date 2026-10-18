package com.liuqiang.jd.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 13:16 星期四 13:16
 * @Description: 京东商品实体类
 * @version: 1.0
 **/

@Data
@TableName("jd_item")
public class JdItem implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("spu")
    private Long spu;
    @TableField("sku")
    private Long sku;
    @TableField("title")
    private String title;
    @TableField("price")
    private Double price;
    @TableField("url")
    private String url;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
