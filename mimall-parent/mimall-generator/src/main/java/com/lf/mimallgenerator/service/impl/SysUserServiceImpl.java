package com.lf.mimallgenerator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lf.mimall.mimallcommon.mybatis.EntityMap;
import com.lf.mimall.mimallcommon.mybatis.base.query.CriteriaQuery;
import com.lf.mimall.mimallcommon.mybatis.base.service.impl.BaseServiceImpl;
import com.lf.mimallgenerator.entity.SysUser;
import com.lf.mimallgenerator.mapper.SysUserMapper;

import com.lf.mimallgenerator.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 服务实现类
 *
 * @author lf
 * @date 2020-09-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Page pageList(CriteriaQuery<?> wrapper) {
        return null;
    }

    @Override
    public EntityMap getEntityMap(CriteriaQuery<?> wrapper) {
        return null;
    }

    @Override
    public List<EntityMap> listEntityMaps(CriteriaQuery<?> wrapper) {
        return null;
    }

    @Override
    public List<EntityMap> selectListEntityMap(String statement, EntityMap map) {
        return null;
    }

    @Override
    public List<EntityMap> selectListEntityMap(EntityMap map) {
        return null;
    }

    @Override
    public List<EntityMap> selectListEntityMap(String statement, CriteriaQuery<?> wrapper) {
        return null;
    }

    @Override
    public List<EntityMap> selectListEntityMap(CriteriaQuery<?> wrapper) {
        return null;
    }
}
