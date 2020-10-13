package org.feng.framework.helper;

import org.feng.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* Bean助手类
* */
public final class BeanHelper {
    /*
    * 定义bean映射
    * */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet= ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }

    /*
    * 获取Bean映射
    * */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /*
     * 获取Bean实例
     * */
    public static <T> T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class:" +cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    /*
    * 设置Bean实例
    * */
    public static void setBean(Class<?> cls,Object object){
        BEAN_MAP.put(cls, object);
    }
}
