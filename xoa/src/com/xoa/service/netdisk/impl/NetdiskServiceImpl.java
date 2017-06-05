package com.xoa.service.netdisk.impl;

import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import com.xoa.service.file.FileSortResetAuth;
import org.springframework.stereotype.Service;


import com.xoa.dao.netdisk.NetdiskMapper;
import com.xoa.model.netdisk.Netdisk;
import com.xoa.service.netdisk.NetdiskService;
/**
 * 
 * @ClassName (类名):  NetdiskServiceImpl
 * @Description(简述): 网盘设置实现类
 * @author(作者):      张丽军
 * @date(日期):        2017-5-8 下午4:03:32
 *
 */
@Service
public class NetdiskServiceImpl  implements NetdiskService{
	@Resource
	private NetdiskMapper netdiskMapper;
    /**
     * 
     * <p>Title: addNetdisk</p>
     * <p>Description:新建 </p>
     * @param netdisk
     * @author(作者):  张丽军
     * @see com.xoa.service.netdisk.NetdiskService#addNetdisk(com.xoa.model.netdisk.Netdisk)
     */
	@Override
	public int addNetdisk(Netdisk netdisk) {
		int a=netdiskMapper.addNetdisk(netdisk);

		return  a;
		
	}
    /**
     * 
     * <p>Title: selectNetdisk</p>
     * <p>Description:查询 </p>
     * @return
     * @author(作者):  张丽军
     * @see com.xoa.service.netdisk.NetdiskService#selectNetdisk()
     */
	
	@Override
	public List<Netdisk> selectNetdisk() {
		
		return netdiskMapper.selectNetdisk();
	}
	/**
	 * 
	 * <p>Title: delete</p>
	 * <p>Description:删除 </p>
	 * @param diskId
	 * @author(作者):  张丽军
	 * @see com.xoa.service.netdisk.NetdiskService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer diskId) {
		
		netdiskMapper.delete(diskId);
	}
	/**
	 * 
	 * <p>Title: editNetdisk</p>
	 * <p>Description: 编辑</p>
	 * @param netdisk
	 * @author(作者):  张丽军
	 * @see
	 */
	@Override
	public int editNetdisk(Netdisk netdisk){
		
		int a=netdiskMapper.editNetdisk(netdisk);
		return a;
	}

	@Override
	public int editNetdiskJurisdiction(Map<String,Object> maps) {

		Integer diskId=(Integer) maps.get("diskId");
		FileSortResetAuth resetAuth =new FileSortResetAuth();
		Map<String,String> param=resetAuth.reset("diskPath", (Map<String, String>)maps.get("diskPath"))
				.reset("newUser",(Map<String, String>)maps.get("newUser"))
				.reset("manageUser",(Map<String, String>)maps.get("manageUser"))
				.reset("downUser",(Map<String, String>)maps.get("downUser"))
				.getParam();
		param.put("diskId",diskId.toString());
		int a=netdiskMapper.editNetdiskJurisdiction(param);
		return a;
	}
}
