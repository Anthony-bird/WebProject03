package org.feng.framework;

import org.feng.framework.helper.*;
import org.feng.framework.util.ClassUtil;

/*
* 加载相应的 Helper类
* */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList ={
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
