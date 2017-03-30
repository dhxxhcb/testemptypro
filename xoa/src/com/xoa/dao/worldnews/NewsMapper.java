package com.xoa.dao.worldnews;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xoa.model.worldnews.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);
    
    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    
    /**
     * 条件新闻信息查询并返回
     * @return
     */
    List<News> showNews(@Param("typeId") String typeId,@Param("newsTime") Date newsTime,
    		@Param("start") int start,@Param("pagesize") int pagesize);
    
    
    /**
     * 共计多少条信息
     * @param typeId
     * @param newsTime
     * @return
     */
    List<News> showCountNews(@Param("typeId") String typeId,@Param("newsTime") Date newsTime);
    
    /**
     * 条件新闻信息查询并返回
     * @return
     */
    List<News> showAllNews(@Param("start") int start,@Param("pagesize") int pagesize);
    
    
    /**
     * 共计多少条信息
     * @param typeId
     * @param newsTime
     * @return
     */
    List<News> showAllCountNews();
    
    
    
//    List<News> showNews();
}