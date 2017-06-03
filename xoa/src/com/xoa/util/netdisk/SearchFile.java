package com.xoa.util.netdisk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsb on 2017/6/3.
 */
public class SearchFile {

    public static List<String> searchFile(String path, String fileName){
        if(path!=null&&fileName!=null){
            File file = new File(path);
            List<String> list = new ArrayList<String>();
            getFilesList(file,fileName,list);
            return list;
        }
        return null;
    }

    public static void getFilesList(File file,String fileName,List<String> list){
        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files!=null&&files.length>0){
                    for(File f:files){
                        getFilesList(f,fileName,list);
                    }
                }
            }else if(file.isFile()){
                if(file.getName().contains(fileName)){
                    list.add(file.getPath());
                }
            }
        }
    }

}
