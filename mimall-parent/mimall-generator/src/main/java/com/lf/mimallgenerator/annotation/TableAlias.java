package com.lf.mimallgenerator.annotation;

import java.lang.annotation.*;

/**
 * @author
 * 数据库表格别名
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TableAlias {
    String value();
}