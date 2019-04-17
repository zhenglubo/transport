package com.transport.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratorTable {

    String name() ;
    boolean isCondition() default true;
    int compareType() default 0;//0:等于 ，1:大于等于，2:大于，-1:小于等于，-2:小于,   模糊匹配  5: like %xxx,4: like %xxx% ,3: like xxx%

}
