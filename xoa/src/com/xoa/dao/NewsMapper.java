package com.xoa.dao;

import com.xoa.model.News;
import com.xoa.model.NewsWithBLOBs;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(NewsWithBLOBs record);

    int insertSelective(NewsWithBLOBs record);

    NewsWithBLOBs selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(NewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NewsWithBLOBs record);

    int updateByPrimaryKey(News record);
}