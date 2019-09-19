package org.lanqiao.util;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;


@Service
public class Base64 {

    public String base64(String imageFile) {
        String type = imageFile.split(",")[0].split("/")[1].split(";")[0];
        imageFile = imageFile.split(",")[1];
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] imageByte = null;
        try {
            imageByte = decoder.decodeBuffer(imageFile);
            for (int i = 0; i < imageByte.length; ++i){
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Bytes2File(imageByte,type);
    }
    public static String Bytes2File(byte[] imageByte , String type)
    {
        String path = null;
       try {
           int length = imageByte.length;
           //追加文件夹
           File file = new File("D:/MusicImage");
           if(!file.exists()){
               file.mkdirs();
           }
           path = "D:/MusicImage/"+UUID.randomUUID()+ "." + type;
           FileOutputStream fos = new FileOutputStream(path);//isAppend如果为true，为追加写入，否则为覆盖写入
           fos.write(imageByte,0,length);
           fos.close();
           path = path.replaceAll("D:/MusicImage/","/upload/");
       }catch (Exception e){
           e.printStackTrace();
       }
       return path;
    }
}
