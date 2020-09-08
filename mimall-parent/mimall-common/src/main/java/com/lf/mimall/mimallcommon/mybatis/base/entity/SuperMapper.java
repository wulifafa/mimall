package com.lf.mimall.mimallcommon.mybatis.base.entity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.lf.mimall.mimallcommon.mybatis.EntityMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuperMapper<T> extends BaseMapper<T> {
    Page<T> pageList(Page<T> page, @Param("ew") Wrapper<?> wrapper);

    List<EntityMap> getEntityMap(@Param("ew") Wrapper<?> wrapper);


}
