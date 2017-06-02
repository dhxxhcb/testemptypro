package com.xoa.util.netdisk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class CopyFile {
    public static String readByBufferedReader(String fileName) {  
    	 String read = null;  
    	 String read1=null;
    	try {  
            File file = new File(fileName);  
            // 读取文件，并且以utf-8的形式写出去  
            BufferedReader bufread;
            InputStreamReader isr;
            byte[] b = new byte[3];
            if (b[0] == -17 && b[1] == -69 && b[2] == -65){
                System.out.println(file.getName() + "：编码为UTF-8");
           isr = new InputStreamReader(new FileInputStream(file), "GBK");}
            else{
                System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");
            isr = new InputStreamReader(new FileInputStream(file), "GBK");}
           
           // InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
                bufread = new BufferedReader(isr);
           // bufread = new BufferedReader(new FileReader(file));  
            while ((read = bufread.readLine()) != null) {  
                System.out.println(read);  
                read1=read;
            }  
            bufread.close();  
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }
		return read1;  
    }
    
    public static  void writeFile(String content,File file ) {  
    	  // 向文件写入内容(输出流)  
        String str = content;  
        byte bt[] = new byte[1024];  
        bt = str.getBytes();  
        try {  
            FileOutputStream in = new FileOutputStream(file);  
            try {  
                in.write(bt, 0, bt.length);  
                in.close();  
                // boolean success=true;  
                // System.out.println("写入文件成功");  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  

    }
    
}
