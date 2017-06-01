package com.xoa.util.netdisk;

import com.xoa.model.netdisk.Catalog;
import com.xoa.model.netdisk.MyNetdisk;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public static Catalog getFiles(String dirPath) throws Exception{
		File file=new File(dirPath);
		Catalog catalog=null;
		if (file.exists()){
			catalog=new Catalog();
			String dirSize="";
			int catalogcount=0;
			List<MyNetdisk> myNetdiskList=new ArrayList<MyNetdisk>();
			if (file.isDirectory()){//如果是个目录
				File[] files =file.listFiles();
				for (File fi:files){
					MyNetdisk myNetdisk=new MyNetdisk();
					String  path=fi.getAbsolutePath();
					myNetdisk.setPath(path);
					myNetdisk.setNeName(getFileName(path));
					if (fi.isDirectory()){
						myNetdisk.setType("DIR");
						myNetdisk.setSize("");

					}else {
						myNetdisk.setType(getFileType(path));
						myNetdisk.setSize(FormetFileSize(getFileSizes(fi)));

					}
                    myNetdiskList.add(myNetdisk);
            }

			}else {
                dirSize=FormetFileSize(getFileSizes(file));

            }
            catalog.setCatalogcount(catalogcount);
            catalog.setCatalogSize(dirSize);
            catalog.setCatalogPath(dirPath);
            catalog.setMyNetdiskList(myNetdiskList);


		}
		return  catalog;
	}




	//获取文件类型
	private static String getFileType(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
	}
	//获取文件名
	static String getFileName(String filePath) {
		String [] fileItems=filePath.split("\\\\");
		return fileItems[fileItems.length-1];
	}
	//取得文件大小
	public static long getFileSizes(File f) throws Exception{
		long s=0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s= fis.available();
		} else {
			System.out.println("文件不存在");
		}
		return s;
	}
	//取得文件夹大小
	public static long getFileSize(File f)throws Exception
	{
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++)
		{
			if (flist[i].isDirectory())
			{
				size = size + getFileSize(flist[i]);
			} else
			{
				size = size + flist[i].length();
			}
		}
		return size;
	}
	public static String FormetFileSize(long fileS) {//转换文件大小
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}


	public static long getlist(File f){//递归求取目录文件个数
		long size = 0;
		File flist[] = f.listFiles();
		size=flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;

	}

}
