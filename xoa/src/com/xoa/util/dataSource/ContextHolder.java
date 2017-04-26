package com.xoa.util.dataSource;

/**
* Created by gaosubo on 2017/4/25.
*/
public class ContextHolder {
//    public static final String mysqlDataSources1="mysqlDataSources";
//    public static final String mysqlDataSources="mysqlDataSources1";
//    public static final String oracleDataSources="oracleDataSources";

    private static final ThreadLocal<String> context = new ThreadLocal<String>();

    public static void setConsumerType(String consumerType){
        context.set(consumerType);
    }

    public static String getConsumerType(){
        return context.get();
    }

    public static void clearConsumerType(){
        context.remove();
    }
}
