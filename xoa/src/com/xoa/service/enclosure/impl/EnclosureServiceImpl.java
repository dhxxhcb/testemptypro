package com.xoa.service.enclosure.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xoa.dao.enclosure.AttachmentMapper;
import com.xoa.model.enclosure.Attachment;
import com.xoa.service.enclosure.EnclosureService;
@Service
public class EnclosureServiceImpl implements EnclosureService {
	@Resource
	AttachmentMapper attachmentMapper;

	@Override
	public void saveAttachment(Attachment attachment) {
		attachmentMapper.insertSelective(attachment);

	}

	@Override
	public Attachment findByAttachId(int attachId) {
		Attachment a=attachmentMapper.findByAttachId(attachId);
		return a;
	}

	@Override
	public boolean saveUpload(String path, String fileName,String module,MultipartFile file) {
		//获取当前年月
        Calendar now = Calendar.getInstance();
        String year=new SimpleDateFormat("yy",Locale.CHINESE).format(Calendar.getInstance().getTime());
        int month=(now.get(Calendar.MONTH) + 1);
        String m=(month<10?"0"+month:month+"");
        String datefile=year+m;
     
        //File targetFile = new File(path+"/"+attachmentModule.getModuleCode()+"/"+datefile, fileName);
        File targetFile = new File(path+"/"+module+"/"+datefile, fileName);
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {  
            file.transferTo(targetFile); 
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
       /* int randomId=(int) (Math.random()*900+100);        
        int attachId = Integer.parseInt(randomId+datefile);
        byte a=0;
        byte b=2;
        Attachment attachment=new Attachment();
        attachment.setAttachId(attachId);
        attachment.setAttachFile(fileName);
        attachment.setAttachName(fileName);
        attachment.setYm(datefile);
        attachment.setAttachSign(new Long(0));
        attachment.setDelFlag(a);
        attachment.setPosition(b);
        
        attachmentMapper.insertSelective(attachment);
        
        int aid=attachmentMapper.findByAttachId(attachId).getAid();
        String attachmentId =aid+"@"+datefile+"_"+attachId;      */
		return false;
	}

}
