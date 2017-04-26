package com.xoa.service.enclosure;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;
import com.xoa.util.dataSource.DynDatasource;

public interface EnclosureService {
	@DynDatasource
	public void saveAttachment(Attachment attachment);
	
	@DynDatasource
	public Attachment findByAttachId(int attachId);
	
	@DynDatasource
	public Attachment findByLast();
	
	@DynDatasource
	public Map<String, String> uoload(@RequestParam("file") MultipartFile[] files);
}
