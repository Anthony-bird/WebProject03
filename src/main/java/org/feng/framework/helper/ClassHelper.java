package org.feng.framework.helper;

import org.feng.framework.ConfigConstant;
import org.feng.framework.annotation.Controller;
import org.feng.framework.annotation.Service;
import org.feng.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/*
* 类操作助手类
* */
public final class ClassHelper {
    /*
    * 定义类集合(用于存放所加载的类)
    * */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAPPBasePackage();
        CLASS_SET  = ClassUtil.getClassSet(basePackage);
    }
    /*
    * 获取应用包下的所有类
    * */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
    /*
     * 获取应用包下的所有Service类
     * */
    public static Set<Class<?>> getServiceClassSet(){
        HashSet<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /*
     * 获取应用包下的所有Controller类
     * */
    public static Set<Class<?>> getControllerClassSet(){
        HashSet<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /*
     * 获取应用包下的所有bean类(包括Service，Controller)
     * */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
