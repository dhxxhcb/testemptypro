package com.xoa.service.enclosure;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xoa.model.enclosure.Attachment;
import com.xoa.util.dataSource.DynDatasource;

public interface EnclosureService {
	@DynDatasource
	public void saveAttachment(Attachment attachment);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午7:05:20
	 * 方法介绍:   
	 * 参数说明:   @param attachId
	 * 参数说明:   @return
	 * @return     Attachment
	 */
	@DynDatasource
	public Attachment findByAttachId(int attachId);
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午6:57:35
	 * 方法介绍:   查找最后的附件信息
	 * 参数说明:   @return
	 * @return     Attachment 附件信息
	 */
	@DynDatasource
	public Attachment findByLast();
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午6:56:58
	 * 方法介绍:   上传接口
	 * 参数说明:   @param files 上传文件
	 * 参数说明:   @param company 公司名
	 * 参数说明:   @param module 模块名
	 * 参数说明:   @param basePath 上传路径
	 * 参数说明:   @param isAttach 是否暴露路径
	 * 参数说明:   @return
	 * @return     List<Attachment>  附件信息集合
	 */
	@DynDatasource
	public List<Attachment>  upload(MultipartFile[] files,String company,String module,boolean isAttach);
	
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月27日 上午9:24:05
	 * 方法介绍:   获取附件url
	 * 参数说明:   @param att 附件信息
	 * 参数说明:   @param company 公司
	 * 参数说明:   @param module 模块名
	 * 参数说明:   @return
	 * @return     String 返回附件
	 */
	@DynDatasource
	public String attachmenturl(Attachment att,String company,String module);
	
	
}

