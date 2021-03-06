package org.feng.framework.bean;

import java.lang.reflect.Method;

/*
* 封装Action 信息
* */
public class Handler {
    /*
    * Controller类
    * */
    private Class<?> controllerClass;
    /*
    * Action 方法
    * */
    private Method actionMethod;

    public Handler(Class<?> controllerClass,Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod(){
        return actionMethod;
    }
}
