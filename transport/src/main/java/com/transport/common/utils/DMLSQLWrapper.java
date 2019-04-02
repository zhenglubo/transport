package com.transport.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.transport.common.annotation.GeneratorTable;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        Map<String, Object> map = MapUtils.toMap(object);
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            queryWrapper.eq(entry.getKey(), entry.getValue());
        }
        return queryWrapper;
    }

    /**
     * 更新语句封装对象
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
                if (value != null && !"current".equalsIgnoreCase(fieldName) && !"size".equalsIgnoreCase(fieldName)) {
                    GeneratorTable annotation = field.getAnnotation(GeneratorTable.class);
                    if (annotation != null) {
                        String columnName = annotation.name();
                        if (annotation.isCondition()) {
                            wrapper.eq(columnName, value);
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
}
