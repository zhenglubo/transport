package com.transport.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.transport.common.annotation.GeneratorTable;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @description: DML sql Wrapper
 * @author: zhenglubo
 * @create: 2019-04-01 18:35
 **/

@Slf4j
@SuppressWarnings("all")
public class DMLSQLWrapper<T> {


    public static <T> QueryWrapper<T> queryWrapper(Object object, Class<T> tClass) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                Object value = field.get(object);
                if (value != null) {
                    GeneratorTable annotation = field.getAnnotation(GeneratorTable.class);
                    if (annotation != null && annotation.isCondition()) {
                        setCompareType(queryWrapper, annotation, value);
                    }
                }
            } catch (Exception e) {
                log.error(DMLSQLWrapper.class.getSimpleName(), e.getMessage());
            }
        }
        return queryWrapper;
    }


    /**
     * 更新语句封装对象
     *
     * @param object
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> UpdateWrapper<T> updateWrapper(Object object, Class<T> tClass) {
        UpdateWrapper<T> wrapper = new UpdateWrapper<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                Object value = field.get(object);
                if (value != null) {
                    GeneratorTable annotation = field.getAnnotation(GeneratorTable.class);
                    if (annotation != null) {
                        String columnName = annotation.name();
                        if (annotation.isCondition()) {
                            setCompareType(wrapper, annotation, value);
                        } else {
                            wrapper.set(columnName, value);
                        }
                    }
                }
            } catch (Exception e) {
                log.error(DMLSQLWrapper.class.getSimpleName(), e.getMessage());
            }
        }
        return wrapper;
    }

    private static <T> void setCompareType(UpdateWrapper<T> wrapper, GeneratorTable annotation, Object value) {
        String columnName = annotation.name();
        switch (annotation.compareType()) {
            case 5://模糊右匹配 like %xxx
                wrapper.likeRight(columnName, value);
                break;
            case 4://模糊匹配 like %xxx%
                wrapper.like(columnName, value);
                break;
            case 3://模糊左匹配 like xxx%
                wrapper.likeLeft(columnName, value);
                break;
            case 1://大于等于
                wrapper.ge(true, columnName, value);
                break;
            case 2://大于
                wrapper.ge(false, columnName, value);
                break;
            case -1://小于等于
                wrapper.le(true, columnName, value);
                break;
            case -2://小于
                wrapper.le(false, columnName, value);
                break;
            case 0:
            default:
                wrapper.eq(columnName, value);
        }
    }

    private static <T> void setCompareType(QueryWrapper<T> wrapper, GeneratorTable annotation, Object value) {
        String columnName = annotation.name();
        switch (annotation.compareType()) {
            case 5://模糊右匹配 like %xxx
                wrapper.likeRight(columnName, value);
                break;
            case 4://模糊匹配 like %xxx%
                wrapper.like(columnName, value);
                break;
            case 3://模糊左匹配 like xxx%
                wrapper.likeLeft(columnName, value);
                break;
            case 1://大于等于
                wrapper.ge(true, columnName, value);
                break;
            case 2://大于
                wrapper.ge(false, columnName, value);
                break;
            case -1://小于等于
                wrapper.le(true, columnName, value);
                break;
            case -2://小于
                wrapper.le(false, columnName, value);
                break;
            case 0://等于，默认
            default:
                wrapper.eq(columnName, value);
        }
    }
}
