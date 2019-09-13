package org.lanqiao.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

public class FileUploadGsq {

    public String uploadToDisk(String str, MultipartFile file){
        return uploadToDiskSon(str,file);
    }

    public String uploadToDisk(MultipartFile file){
        return uploadToDiskSon("D:/MusicImages",file);
    }

    public String uploadToTomcat(HttpServletRequest request, MultipartFile file) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        String fileName = file.getOriginalFilename();
        //获取服务器所在地址
        String pathval = request.getSession().getServletContext().getRealPath("/");
        //图片在服务器下的路径
        String saveFilePath = "images/uploadFile";
        //寻找或者建立路径
        File fileDir = new File(pathval + saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        try {
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(fileDir + File.separator + fileName);
            byte[] b = new byte[1024];
            while ((inputStream.read(b)) != -1) {
                outputStream.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "images/uploadFile/" + fileName;
    }

    public String uploadToDiskSon(String str, MultipartFile file) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        //寻找或者建立路径
        File fileDir = new File(str);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        try {
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(fileDir + File.separator + fileName);
            byte[] b = new byte[1024];
            while ((inputStream.read(b)) != -1) {
                outputStream.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str + "/" + fileName;

    }
}

