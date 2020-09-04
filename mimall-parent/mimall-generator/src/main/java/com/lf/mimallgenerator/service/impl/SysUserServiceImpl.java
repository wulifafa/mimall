package com.lf.mimallgenerator.service.impl;

import com.lf.mimallgenerator.entity.SysUser;
import com.lf.mimallgenerator.mapper.SysUserMapper;
import com.lf.mimallgenerator.mybatis.base.service.impl.BaseServiceImpl;
import com.lf.mimallgenerator.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *  服务实现类
 *
 * @author lf
 * @date 2020-09-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
