package com.xoa.dao.workflow;

import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FormSortMapper {
    int countByExample(FormSortExample example);

    int deleteByExample(FormSortExample example);

    int deleteByPrimaryKey(Integer sortId);

    int insert(FormSort record);

    int insertSelective(FormSort record);

    List<FormSort> selectByExample(FormSortExample example);
    List<FormSort> selectAllFormSort();

    int selectNoformSort();

    int getChildNumber(Integer sortId);

    FormSort selectByPrimaryKey(Integer sortId);

    int updateByExampleSelective(@Param("record") FormSort record, @Param("example") FormSortExample example);

    int updateByExample(@Param("record") FormSort record, @Param("example") FormSortExample example);

    int updateByPrimaryKeySelective(FormSort record);

    int updateByPrimaryKey(FormSort record);
}