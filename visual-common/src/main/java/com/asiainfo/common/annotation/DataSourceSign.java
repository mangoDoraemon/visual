package com.asiainfo.common.annotation;

import com.asiainfo.common.enums.ContextConst;

import java.lang.annotation.*;

/**
 * @author wangjingyuan
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceSign {
    ContextConst.DataSourceType value() default ContextConst.DataSourceType.PRIMARY;
}
