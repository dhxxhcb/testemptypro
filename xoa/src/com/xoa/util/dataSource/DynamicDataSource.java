package com.xoa.util.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
* Created by gaosubo on 2017/4/25.
*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("连接数据源类型：");
        return ContextHolder.getConsumerType();
    }
}
