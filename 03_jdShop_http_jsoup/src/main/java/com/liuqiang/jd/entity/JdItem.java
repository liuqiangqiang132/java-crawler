package com.liuqiang.jd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 13:16 星期四 13:16
 * @Description:
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
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
}
