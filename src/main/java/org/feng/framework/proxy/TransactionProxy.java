package org.feng.framework.proxy;

import org.feng.framework.annotation.Transaction;
import org.feng.framework.helper.DatabaseHelper;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/*
* 事务代理
* */
public class TransactionProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Thansaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTransaction();
                LOGGER.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.dubug("commit transaction");
            } catch (Exception e){
                DatabaseHelper.rollbackTransaction();
                LOGGER.dubug("rollback transaction");
                throw e;
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
