package org.feng.framework.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import static org.feng.framework.util.DBUtil.getConnection;

public class DatabaseHelper {
    /*
    * 开启事务
    * */
    public static void beginTransaction(){
        Connection conn = getConnection();
        if (conn !=null){
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                Logger.error("begin transaction failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
    }
    /*
    * 提交事务
    * */
    public static void commitTransaction() {
        Connection conn = getConnection();
        if (conn != null){
            try {
                conn.commit();
                conn.close();
            } catch (SQLException e) {
                Logger.error("commit transaction failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
    /*
    * 回滚事务
    * */
    public static void rollbackTransaction() {
        Connection conn = getConnection();
        if (conn != null){
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e) {
                Logger.error("rollback transaction failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
}
