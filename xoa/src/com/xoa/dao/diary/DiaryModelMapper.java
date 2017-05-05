package com.xoa.dao.diary;

import java.util.List;
import java.util.Map;

import com.xoa.model.diary.DiaryModel;


public interface DiaryModelMapper {



	List<DiaryModel> getDiarySelf(Map<String, Object> diaryMap);



	List<DiaryModel> getDiaryList(Map<String, Object> diaryMap);

	List<DiaryModel> getDiaryOtherList(Map<String, Object> diaryMap);


	DiaryModel getDiaryByDiaId(DiaryModel diaryModel);



	int updateDiary(DiaryModel diaryModel);



	int saveDiary(DiaryModel diaryModel);



	int updateReadersByDiaId(DiaryModel diaryModel);



	int deletDiaById(DiaryModel diaryModel);

}