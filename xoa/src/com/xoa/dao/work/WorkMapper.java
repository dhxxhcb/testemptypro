package com.xoa.dao.work;

import java.util.Map;

public interface WorkMapper {
    void createTable(Map<String,Object> map);

    int insert(Map<String,Object> map);

    Map<String,Object> select(Map<String,Object> map);

    int update(Map<String,Object> map);
    
    String findAutoNum(Map<String,Object> map);
    
    void addcolumn(Map<String,Object> map);
}
