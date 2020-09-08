package com.lf.mimall.mimallcommon.mybatis.base.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class AbstractEntity2 extends Model implements Serializable {
    private static final long serialVersionUID = 1L;

}
