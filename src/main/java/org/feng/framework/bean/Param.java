package org.feng.framework.bean;

import net.sf.cglib.core.CollectionUtils;

import java.util.Map;

/*
* 请求参数对象
* */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    /*
    * 根据参数对象获取long型参数
    * */
    public long gerLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /*
    * 获取所有字段信息
    * */
    public Map<String,Object> getMap(){
        return paramMap;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
