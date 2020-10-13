package org.feng.chapter4.aspect;

import org.feng.framework.proxy.AspectProxy;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {
        LOGGER.debug("----- begin -----");
        LOGGER.debug(String.format("class: %s",cls.getName()));
        LOGGER.debug(String.format("method: %s",method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        LOGGER.debug(String.format("time: %ms",System.currentTimeMillis()-begin));
        LOGGER.debug("----- end -----");
    }
}
