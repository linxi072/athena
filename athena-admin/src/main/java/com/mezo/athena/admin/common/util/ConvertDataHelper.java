package com.mezo.athena.admin.common.util;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConvertDataHelper {
    public static <T> T convertBean(Object object, Class<T> entityClass) {
        if (null == object) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(object), entityClass);
    }
    /**
     * 将befObj 对象赋值给 aftObj
     *
     * @param befObj
     * @param aftObj
     * @param fieldsOut
     */
    public static void copyObject(Object aftObj, Object befObj, String[] fieldsOut) {

        Class<?> clazz = aftObj.getClass();
        if (!clazz.getName().equals(befObj.getClass().getName())) {
            return;
        }
        List<String> outList = new ArrayList<String>();
        if (fieldsOut != null) {
            outList = Arrays.asList(fieldsOut);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            int mod = f.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            if (!outList.contains(f.getName())) {
                f.setAccessible(true);
                try {
                    f.set(aftObj, f.get(befObj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * *map转Object,同名属性赋值
     *
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                Object value = map.get(field.getName());
                if (value == null) {
                    continue;
                }
                String valueStr = String.valueOf(value);
                String type = field.getGenericType().toString();
                if (type.toLowerCase().contains("string")) {
                    field.set(obj, valueStr);
                }
                if (type.toLowerCase().contains("int")) {
                    field.set(obj, Integer.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("long")) {
                    field.set(obj, Long.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("double")) {
                    field.set(obj, Double.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("boolean")) {
                    field.set(obj, Boolean.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("float")) {
                    field.set(obj, Float.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("byte")) {
                    field.set(obj, Byte.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("short")) {
                    field.set(obj, Short.valueOf(valueStr));
                }
                if (type.toLowerCase().contains("bigdecimal")) {
                    field.set(obj, new BigDecimal(valueStr));
                }
                if (type.toLowerCase().contains("date")) {
                    if (!(valueStr == null || "".equals(valueStr))) {
                        try {
                            if (valueStr.length() == 8) {
                                DateFormat format = new SimpleDateFormat("yyyyMMdd");
                                field.set(obj, format.parse(valueStr));
                            } else if (valueStr.length() == 10) {
                                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                field.set(obj, format.parse(valueStr));
                            } else if (valueStr.length() == 19) {
                                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                field.set(obj, format.parse(valueStr));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * *object转map,同名属性赋值
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
