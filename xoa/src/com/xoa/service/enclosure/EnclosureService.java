package com.xoa.service.enclosure;

import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;
import com.xoa.util.dataSource.DynDatasource;

public interface EnclosureService {
	@DynDatasource
	public void saveAttachment(Attachment attachment);
	
	@DynDatasource
	public Attachment findByAttachId(int attachId);
	
	@DynDatasource
	public boolean saveUpload(String path,String filename,String module,MultipartFile file);

}
