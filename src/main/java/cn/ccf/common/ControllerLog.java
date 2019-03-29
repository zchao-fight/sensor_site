package cn.ccf.common;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    /**
     * 描述业务操作，例Xxx管理-执行Xxx操作
     * @return
     */
    String description() default "";
    String operatorType() default "";
}
