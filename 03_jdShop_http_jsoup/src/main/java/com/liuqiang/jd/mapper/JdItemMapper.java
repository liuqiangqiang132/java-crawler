package com.liuqiang.jd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.jd.entity.JdItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 13:15 星期四 13:15
 * @Description:
 * @version: 1.0
 **/
@Mapper
public interface JdItemMapper extends BaseMapper<JdItem> {


    /**
     * 有了mybatis-plus能完成基本的增删改查,那还需要mybatis的原生干嘛
     * @return
     */
    public List<JdItem> getALlJdItemList();
}
