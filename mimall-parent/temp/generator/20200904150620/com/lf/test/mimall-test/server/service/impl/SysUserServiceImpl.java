package com.lf.test.mimall-test.server.service.impl;

import com.lf.test.mimall-test.client.model.entity.SysUser;
import com.lf.test.mimall-test.server.mapper.SysUserMapper;
import com.lf.test.mimall-test.server.service.SysUserService;
import com.jiuair.cloud.data.common.core.mybatis.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

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
