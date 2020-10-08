package org.feng.framework;

import org.feng.framework.helper.BeanHelper;
import org.feng.framework.helper.ClassHelper;
import org.feng.framework.helper.ControllerHelper;
import org.feng.framework.helper.IocHelper;
import org.feng.framework.util.ClassUtil;

/*
* 加载相应的 Helper类
* */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList ={ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
