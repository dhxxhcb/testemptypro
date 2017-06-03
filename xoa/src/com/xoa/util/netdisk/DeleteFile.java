package com.xoa.util.netdisk;

import java.io.File;

/**
 * Created by gsb on 2017/6/3.
 */
public class DeleteFile {
    public  static int count = 0;
    public static void refreshFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files == null)
        {
            System.out.println("该目录下没有任何一个文件！");
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                refreshFileList(files[i].getAbsolutePath());
            }else {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                if(strFileName.endsWith(".txt")){
                    System.out.println("正在删除：" + strFileName);
                    files[i].delete();
                    count++;
                }
            }
        }
    }
}
