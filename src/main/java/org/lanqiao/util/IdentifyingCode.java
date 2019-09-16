
package org.lanqiao.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.lanqiao.entity.Users;
import org.lanqiao.service.UsersServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.io.Serializable;

public class IdentifyingCode implements Serializable {
    //对应你阿里云账户的 accessKeyId
    private static final String accessKeyId = "LTAI4Fm93pgKnfEW68JSvr3g";
    //对应你阿里云账户的 accessKeySecret
    private static final String accessKeySecret = "8ybTUeNtuTRqqUkzGFZDTJm3FFAWRh";
    //对应签名名称
    private static final String signName="Lancereally";
    //对应模板代码
    private static final String templateCode="SMS_174028189";

    private static int mobile_code = (int)((Math.random()*9+1)*100000);

//    /**
//     * 短信发送
//     * @param telphone 发送的手机号
//     */
    public int SendCode(String phoneNumber) {

        DefaultProfile profile = DefaultProfile.getProfile("default",
                accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        //阿里云对应发送短信的服务器地址
        request.setDomain("dysmsapi.aliyuncs.com");
        //对应的版本号
        request.setVersion("2017-05-25");

        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":"+mobile_code+"}");

        //redis
//        String value = mobile_code+"";
//        Jedis jedis = new Jedis("127.0.0.1");
//        jedis.set(phoneNumber,value);


        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return mobile_code;
    }
}
