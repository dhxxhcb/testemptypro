package com.xoa.service.netdisk.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.xoa.dao.netdisk.NetdiskMapper;
import com.xoa.model.netdisk.Netdisk;
import com.xoa.service.netdisk.NetdiskService;
/**
 * 
 * @ClassName (类名):  NetdiskServiceImpl
 * @Description(简述): TODO
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
     * <p>Description: </p>
     * @param netdisk
     * @author(作者):  张丽军
     * @see com.xoa.service.netdisk.NetdiskService#addNetdisk(com.xoa.model.netdisk.Netdisk)
     */
	@Override
	public void addNetdisk(Netdisk netdisk) {
		netdiskMapper.addNetdisk(netdisk);
		
	}
    /**
     * 
     * <p>Title: selectNetdisk</p>
     * <p>Description: </p>
     * @return
     * @author(作者):  张丽军
     * @see com.xoa.service.netdisk.NetdiskService#selectNetdisk()
     */
	
	@Override
	public List<Netdisk> selectNetdisk() {
		
		return netdiskMapper.selectNetdisk();
	}
	
	@Override
	public void delete(Integer diskId) {
		
		netdiskMapper.delete(diskId);
	}
	
	@Override
	public void editNetdisk(Netdisk netdisk){
		netdiskMapper.editNetdisk(netdisk);
	}
}
