package com.xoa.dao.work;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by eagle on 2017/6/2.
 */
public interface WorkMapper {
    void createTable(Map<String,Object> map);

    int insert(Map<String,Object> map);

    Map<String,Object> select(Map<String,Object> map);

    int update(Map<String,Object> map);
}
