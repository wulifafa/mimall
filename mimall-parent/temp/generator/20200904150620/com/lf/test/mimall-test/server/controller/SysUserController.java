package com.lf.test.mimall-test.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiuair.cloud.data.common.core.entity.vo2.PageParams;
import com.jiuair.cloud.data.common.core.entity.vo2.Result;
import com.jiuair.cloud.data.common.core.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.lf.test.mimall-test.client.model.entity.SysUser;
import com.lf.test.mimall-test.server.service.SysUserService;
/**
 *  前端控制器
 *
 * @author lf
 * @date 2020-09-04
 */
@Api(value = "", tags = "")
    @RestController
@RequestMapping("sysUser")
    public class SysUserController {

    @Autowired
    private SysUserService targetService;

    /**
    * 获取分页数据
    *
    * @return
    */
    @ApiOperation(value = "获取分页数据-", notes = "获取分页数据")
    @GetMapping(value = "/list")
    public Result<IPage<SysUser>>list(@RequestParam(required = false) Map map){
        PageParams pageParams = new PageParams(map);
        SysUser query = pageParams.mapToObject(SysUser.class);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        return Result.ok().data(targetService.page(pageParams,queryWrapper));
    }

    /**
     * 根据ID查找数据
     */
    @ApiOperation(value = "根据ID查找数据-", notes = "根据ID查找数据")
    @ResponseBody
    @RequestMapping("/get")
    public Result<SysUser> get(@RequestParam("id") Long id){
        SysUser entity = targetService.getById(id);
        return Result.ok().data(entity);
    }

    /**
    * 添加数据
    * @return
    */
    @ApiOperation(value = "添加数据-", notes = "添加数据")
    @ApiImplicitParams({
         @ApiImplicitParam(name = "name", required = true, value = "姓名", paramType = "form"),
         @ApiImplicitParam(name = "sex", required = true, value = "性别，0：男性，1：女生", paramType = "form"),
         @ApiImplicitParam(name = "birthday", required = true, value = "出生日期", paramType = "form"),
         @ApiImplicitParam(name = "create_time", required = true, value = "创建时间", paramType = "form"),
         @ApiImplicitParam(name = "create_by", required = true, value = "创建人", paramType = "form"),
         @ApiImplicitParam(name = "update_time", required = true, value = "更新时间", paramType = "form"),
         @ApiImplicitParam(name = "update_by", required = true, value = "更新人", paramType = "form"),
        @ApiImplicitParam(name = "del_flag", required = true, value = "删除标记，0：未删除，1：已删除", paramType = "form")
            })
    @PostMapping("/add")
    public Result add(
        @RequestParam(value = "name") String name,
        @RequestParam(value = "sex") Integer sex,
        @RequestParam(value = "birthday") LocalDate birthday,
        @RequestParam(value = "create_time") Date create_time,
        @RequestParam(value = "create_by") String create_by,
        @RequestParam(value = "update_time") Date update_time,
        @RequestParam(value = "update_by") String update_by,
        @RequestParam(value = "del_flag") Integer del_flag
            ){
        SysUser entity = new SysUser();
        entity.setName(name);
        entity.setSex(sex);
        entity.setBirthday(birthday);
        entity.setCreate_time(create_time);
        entity.setCreate_by(create_by);
        entity.setUpdate_time(update_time);
        entity.setUpdate_by(update_by);
        entity.setDel_flag(del_flag);
        targetService.save(entity);
        return Result.ok();
    }

    /**
    * 新增数据
    * @return
    */
    @ApiOperation(value = "保存数据-", notes = "保存数据")
    @PostMapping("/save")
    @ResponseBody
    public Result add(@RequestBody SysUser sysUser){
        Result Result=new Result();
        targetService.save(sysUser);
        return Result.ok();
        }


    /**
    * 更新数据
    * @return
    */
    @ApiOperation(value = "更新数据-", notes = "更新数据")
    @ApiImplicitParams({
                    @ApiImplicitParam(name = "id", required = true, value = "", paramType = "form"),
                    @ApiImplicitParam(name = "name", required = true, value = "姓名", paramType = "form"),
                    @ApiImplicitParam(name = "sex", required = true, value = "性别，0：男性，1：女生", paramType = "form"),
                    @ApiImplicitParam(name = "birthday", required = true, value = "出生日期", paramType = "form"),
                    @ApiImplicitParam(name = "create_time", required = true, value = "创建时间", paramType = "form"),
                    @ApiImplicitParam(name = "create_by", required = true, value = "创建人", paramType = "form"),
                    @ApiImplicitParam(name = "update_time", required = true, value = "更新时间", paramType = "form"),
                    @ApiImplicitParam(name = "update_by", required = true, value = "更新人", paramType = "form"),
                    @ApiImplicitParam(name = "del_flag", required = true, value = "删除标记，0：未删除，1：已删除", paramType = "form")
        })
        @PostMapping("/update")
        public Result update(
                @RequestParam(value = "id") String id,
                @RequestParam(value = "name") String name,
                @RequestParam(value = "sex") Integer sex,
                @RequestParam(value = "birthday") LocalDate birthday,
                @RequestParam(value = "create_time") Date create_time,
                @RequestParam(value = "create_by") String create_by,
                @RequestParam(value = "update_time") Date update_time,
                @RequestParam(value = "update_by") String update_by,
                @RequestParam(value = "del_flag") Integer del_flag
        ){
            SysUser entity = new SysUser();
                    entity.setId(id);
                    entity.setName(name);
                    entity.setSex(sex);
                    entity.setBirthday(birthday);
                    entity.setCreate_time(create_time);
                    entity.setCreate_by(create_by);
                    entity.setUpdate_time(update_time);
                    entity.setUpdate_by(update_by);
                    entity.setDel_flag(del_flag);
                targetService.updateById(entity);
                return Result.ok();
        }

    /**
    * 删除数据
    * @return
    */
    @ApiOperation(value = "删除数据-", notes = "删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "id", paramType = "form")
    })
    @PostMapping("/remove")
    public Result remove(
            @RequestParam(value = "id") Long id
    ){
            targetService.removeById(id);
            return Result.ok();
      }

    /**
    * 批量删除数据
    * @return
    */
    @ApiOperation(value = "批量删除数据-", notes = "批量删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    @PostMapping("/batch/remove")
    public Result batchRemove(
                @RequestParam(value = "ids") String ids
            ){
            targetService.removeByIds(Arrays.asList(ids.split(",")));
            return Result.ok();
     }

}
