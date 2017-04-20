package com.xoa.dao.diary;

import java.util.List;
import java.util.Map;

import com.xoa.model.diary.DiaryModel;


public interface DiaryModelMapper {

	int addDiary(DiaryModel diaryModel);

	int updateDiary(DiaryModel diaryModel);

	List<DiaryModel> getDiarySelf(Map diaryModel);

	int getDiaryCount();

	int getDiarySelfLess(Map<String, Object> tempNo);

	List<DiaryModel> getDiaryList(Map<String, Object> diaryMap);

	List<DiaryModel> getDiaryOtherList(Map<String, Object> diaryMap);
}