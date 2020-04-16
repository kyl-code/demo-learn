package org.example.annotation;

import java.lang.annotation.*;

/**
 * @Author Adam_Guo
 * @Date 2020/4/10
 * @Version 1.0
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeignMesage {

    String value() default "";

    String [] name() default "";
}
