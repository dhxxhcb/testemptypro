package com.xoa.dao.diary;

import java.util.List;
import java.util.Map;

import com.xoa.model.diary.DiaryModel;


public interface DiaryModelMapper {

	int saveDiary(DiaryModel diaryModel);

	int updateDiary(DiaryModel diaryModel);

	List<DiaryModel> getDiarySelf(Map<String, Object> diaryMap);

	int getDiaryCount(Map<String, Object> tempNo);

	int getDiarySelfLess(Map<String, Object> tempNo);

	List<DiaryModel> getDiaryList(Map<String, Object> diaryMap);

	List<DiaryModel> getDiaryOtherList(Map<String, Object> diaryMap);
}