package com.xoa.dao.worldnews;

import java.util.List;

import com.xoa.model.worldnews.News;
import com.xoa.model.worldnews.NewsWithBLOBs;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(NewsWithBLOBs record);

    int insertSelective(NewsWithBLOBs record);
    
    int updateByPrimaryKeySelective(NewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NewsWithBLOBs record);

    int updateByPrimaryKey(News record);
    
    /**
     * 新闻信息查询并返回
     * @return
     */
    List<News> showNews();
}