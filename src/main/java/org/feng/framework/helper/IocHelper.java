package org.feng.framework.helper;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.ReflectionUtil;
import org.feng.framework.annotation.Inject;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/*
* 依赖注入助手类
* */
public final class IocHelper {
    static {
        //获取所以的Bean类与Bean实例之间的映射关系(简称 Bean Map)
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从beanMap中获取 Bean与bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取bean 类所以的成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历 Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前Bean field 是否带有Inject对象
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在beanMap中获取BeanField 对应的实例
                            Class<?> beanFieldClass = beanField.getType();

                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance !=null){
                                //通过反射初始化beanField值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
