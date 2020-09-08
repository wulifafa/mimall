package com.lf.mimallgenerator.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.lf.mimall.mimallcommon.mybatis.base.entity.AbstractEntity2;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lf
 * @date 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends AbstractEntity2 {


    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别，0：男性，1：女生")
    private Integer sex;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "创建人")
    private String create_by;

    @ApiModelProperty(value = "更新时间")
    private Date update_time;

    @ApiModelProperty(value = "更新人")
    private String update_by;

    @ApiModelProperty(value = "删除标记，0：未删除，1：已删除")
    private Integer del_flag;


}
