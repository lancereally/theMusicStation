package org.lanqiao.controller;

import com.aliyuncs.exceptions.ClientException;
import org.lanqiao.entity.Share;
import org.lanqiao.entity.Users;
import org.lanqiao.service.ShareServiceImpl;
import org.lanqiao.service.UsersService;
import org.lanqiao.util.Base64;
import org.lanqiao.util.IdentifyingCode;
import org.lanqiao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    ShareServiceImpl shareService;

    @Resource
    RedisUtil redisUtil;


    //MyHomePage页面
//获取用户基本信息
    @RequestMapping("/user/getUserInfo")
    public Users getLittleInfo (Integer userId){
        return usersService.getLittleInfo(userId);
    }
//获取 动态数目
    @RequestMapping("/user/getEventCount")
    public List<Share> getEventCount (Integer userId){
        return shareService.getEventCount(userId);
    }
//获取关注数
    @RequestMapping("/user/getFollowCount")
    public List<Users> getFollowCount(Integer userId){
        return usersService.getFollowCount(userId);
    }
//获取粉丝数
    @RequestMapping("/user/getFanCount")
    public List<Users> getFanCount(Integer userId){
        return usersService.getFanCount(userId);
    }
//获取播放过几首歌
    @RequestMapping("/user/getPlaySongCount")
    public List<Users> getPlaySongCount(Integer userId){
        return usersService.getPlaySongCount(userId);
    }
//获取创建歌单数目
    @RequestMapping("/user/getSongListCreateCount")
    public List<Users> getSongListCreateCount(Integer userId){
        return usersService.getSongListCreateCount(userId);
    }

    //获取收藏歌单数目
    @RequestMapping("/user/getSongListLikedCount")
    public List<Users> getSongListCreateLiked(Integer userId){
        return usersService.getSongListCreateLiked(userId);
    }

    //展示个人听歌排行
    @RequestMapping("/user/getSongRanking")
    public List<Users> getSongRanking(Integer userId){
        return usersService.getSongRanking(userId);
    }

    //展示创建的歌单
    @RequestMapping("/user/getSongListCreate")
    public List<Users> getSongListCreate(Integer userId){
        return usersService.getSongListCreate(userId);
    }

    //展示收藏的歌单
    @RequestMapping("/user/getSongListLiked")
    public List<Users> getSongListLiked(Integer userId){
        List<Users> a =usersService.getSongListLiked(userId);
        return usersService.getSongListLiked(userId);
    }



//MySetting
    //更新用户基本设置信息
    @RequestMapping("/user/updateUserInfo")
    public int updateUserInfo(Users users){
        int a= usersService.updateUserInfo(users);
        return usersService.updateUserInfo(users);
    }

    //查找用户昵称是否重复
    @RequestMapping("/user/checkName")
    public boolean checkName(String userName){
        return usersService.checkName(userName);
    }

    //cookie
    //注册and登录
    //注册
    @RequestMapping("/user/register")
    public int register(Users users){
        return usersService.register(users);
    }

    //账号登录
    @RequestMapping("/user/accountLogin")
    public boolean accountLogin(Users users){
        return usersService.accountLogin(users);
    }

    //注册
    @RequestMapping("/user/getIdByAnything")
    public int getIdByAnything(HttpServletResponse response,Users users){
        Cookie cookie = new Cookie("userId", usersService.getIdByAnything(users)+"");
        cookie.setPath("/");
        response.addCookie(cookie);
        return usersService.getIdByAnything(users);
    }
    //登录验证账户
//    @RequestMapping("/login/checkAccount")
//    public boolean checkAccount(HttpServletResponse response, String str, String password) {
//        Account account = accountService.checkAccount(str, password);
//        if (account != null){
//            Cookie cookie = new Cookie("accId", account.getAccId().toString());
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            return true;
//        }
//        return false;
//    }
    //手机登录


    //VIP
    @RequestMapping("/user/activeVIP")
    public boolean activeVIP(Users users){
        return usersService.activeVIP(users);
    }

    //获取评论
     @RequestMapping("/user/getMyComment")
     public List<Users> getMyComment(Users users){
         return usersService.getMyComment(users);
     }

    //获取点赞通知
    @RequestMapping("/user/getMyNotice")
    public List<Users> getMyNotice(Users users){
        return usersService.getMyNotice(users);
    }

     //拉取fans and follows
     @RequestMapping("/user/getMyFollows")
     public List<Users> getMyFollows(Users users){
         return usersService.getMyFollows(users);
     }

    @RequestMapping("/user/getMyFans")
    public List<Users> getMyFans(Users users){
        return usersService.getMyFans(users);
    }

    //短信

    @RequestMapping("/user/getIdentifyingCode")
    public int getIdentifyingCode(String phoneNumber) throws ClientException {
        IdentifyingCode test = new IdentifyingCode();
        int code = test.SendCode(phoneNumber);

        //redis
        redisUtil.set(phoneNumber,code);
        //mybatis
//        Users users = new Users();
//        users.setUserPhone(phoneNumber);
//        users.setUserPhoneCode(code);
        return 1;
    }

    @RequestMapping("/user/checkIdentifyingCode")
    public int checkIdentifyingCode(int IdentifyingCode,String phoneNumber) throws ClientException {
//        Jedis jedis = new Jedis();
//        if (phoneNumber == jedis.get(IdentifyingCode)) {
//            jedis.close();
//            return 1;
//        }

        if(IdentifyingCode == (int)redisUtil.get(phoneNumber))
            return 1;
        else
            return 0;
//        Users users = new Users();
//        users.setUserPhone(phoneNumber);
//        if(IdentifyingCode == usersService.selectCodeByPhone(phoneNumber))
//        return 1;
//        else
//            return 0;
    }

    @RequestMapping("/user/getUserPhone")
    public String getUserPhone(Integer userId)  {
        return usersService.getUserPhone(userId);
    }

    @RequestMapping("/user/checkPhone")
    public List<Users> checkPhone(String phoneNumber)  {
        return usersService.checkPhone(phoneNumber);
    }

    @RequestMapping("/user/upLoadFile")
    public String insertImage(String imageFile){
        Base64 base64 = new Base64();
        String path = base64.base64(imageFile);
        System.out.println(path);
        return path;
    }

//    @RequestMapping("/set")
//    public String set(){
//        redisUtil.set("17854283609",456);
//        return "";
//    }
//
//    @RequestMapping("/get")
//    public String get(){
//        int user = (int)redisUtil.get("17854283609");
//        System.out.println(user);
//        return "";
//    }


}
