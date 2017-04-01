package com.xoa.service.enclosure;

import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;

public interface EnclosureService {
	public void saveAttachment(Attachment attachment);
	
	public Attachment findByAttachId(int attachId);
	
	public boolean saveUpload(String path,String filename,String module,MultipartFile file);

}
