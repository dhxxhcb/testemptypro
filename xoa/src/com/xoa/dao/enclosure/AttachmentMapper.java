package com.xoa.dao.enclosure;

import com.xoa.model.enclosure.Attachment;

public interface AttachmentMapper {
    int deleteByPrimaryKey(Integer aid);

    void insert(Attachment record);

    void insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer aid);

    void updateByPrimaryKeySelective(Attachment record);

    void updateByPrimaryKey(Attachment record);
    
    Attachment findByAttachId(int attachId);
    
}