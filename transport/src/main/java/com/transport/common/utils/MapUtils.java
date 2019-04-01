package com.transport.common.utils;

import com.transport.common.annotation.GeneratorTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 对象转成map
 * @author: zhenglubo
 * @create: 2019-04-01 14:12
 **/
@Slf4j
public class MapUtils {

    /**
     * 将对象中的字段转为对应数据库表中字段名称且设置该字段的值未map 的value
     *
     * @param object
     * @return
     */
    public static Map<String, Object> toMap(Object object) {
        Map<String, Object> map = new HashMap<>(10);
        Class<?> tClass = object.getClass();
        Field[] fields = tClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(object);
                if (value != null && !"current".equals(fieldName) && !"size".equals(fieldName)) {
                    GeneratorTable annotation = field.getAnnotation(GeneratorTable.class);
                    if (annotation != null && StringUtils.isNotBlank(annotation.name())) {
                        map.put(annotation.name(), value);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            log.error(MapUtils.class.getSimpleName(), e.getMessage());
            return null;
        }
    }
}
