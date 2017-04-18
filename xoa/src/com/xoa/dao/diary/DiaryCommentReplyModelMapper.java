package com.xoa.dao.diary;

import com.xoa.model.diary.DiaryCommentReplyModel;

public interface DiaryCommentReplyModelMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(DiaryCommentReplyModel record);

    int insertSelective(DiaryCommentReplyModel record);

    DiaryCommentReplyModel selectByPrimaryKey(Integer replyId);

    int updateByPrimaryKeySelective(DiaryCommentReplyModel record);

    int updateByPrimaryKeyWithBLOBs(DiaryCommentReplyModel record);

    int updateByPrimaryKey(DiaryCommentReplyModel record);
}