package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String url="http://book.meiriyiwen.com//book_imgs/1468511109.jpg";
        try{
            URL photoUrl=new URL(url);
            URLConnection connection = photoUrl.openConnection();
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            byte [] buf = new byte[1024];
            int len = 0;
            //读取图片数据
            while((len=inputStream.read(buf))!=-1){
                System.out.println(len);
                outputStream.write(buf,0,len);
            }
            inputStream.close();
            outputStream.close();
            File file = new File("t.jpg");
            FileOutputStream op = new FileOutputStream(file);
            op.write(outputStream.toByteArray());
            op.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
