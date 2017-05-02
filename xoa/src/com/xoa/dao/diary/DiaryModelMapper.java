package com.xoa.dao.diary;

import java.util.List;
import java.util.Map;

import com.xoa.model.diary.DiaryModel;


public interface DiaryModelMapper {

	int saveDiary(DiaryModel diaryModel);

	int updateDiary(DiaryModel diaryModel);

	List<DiaryModel> getDiarySelf(Map<String, Object> diaryMap);

	int getDiaryCount(DiaryModel diaryModel);

	int getDiarySelfLess(DiaryModel diaryModel);

	List<DiaryModel> getDiaryList(Map<String, Object> diaryMap);

	List<DiaryModel> getDiaryOtherList(Map<String, Object> diaryMap);
}