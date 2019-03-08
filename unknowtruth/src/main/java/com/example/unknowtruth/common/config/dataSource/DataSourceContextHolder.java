package com.example.unknowtruth.common.config.dataSource;

/**
 * @Author: hjr
 * @Date: 2019/3/8 11:03
 */
public class DataSourceContextHolder {
    public enum DbType{
        MASTER,SLAVE
    }
    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>(){
        @Override
        protected DbType initialValue() {
            return DbType.MASTER;
        }
    };

    public static void setDBType(DbType dbType) {

        if(dbType==null) {
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }
    public static DbType getDBType() {
        return contextHolder.get()==null?DbType.MASTER:contextHolder.get();
    }
    public static void clearDBType() {
        contextHolder.remove();
    }
}
