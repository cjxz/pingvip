package com.pingvip.controller;

import com.pingvip.entity.UserInfo;
import com.pingvip.service.PingVipMailService;
import com.pingvip.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PingVipMailService pingVipMailService;
    @RequestMapping("/user/getUserInfo")
    public UserInfo getUserInfo (){
        return userInfoService.getUserInfo(1);
    }
    @RequestMapping("/user/saveUserInfo")
    public void saveUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserEmail("test@qq.com");
        userInfo.setUserKey("abc");
        userInfo.setUserName("abc");
        userInfo.setUserPassword("jjjj");
        userInfo.setUserPhoneNumber("13112345678");

        userInfoService.saveUserInfo(userInfo);
    }
    @RequestMapping("/user/testMail")
    public void testMail(){
        pingVipMailService.mailTest();
    }
    @RequestMapping("/user/testMailFreemarker")
    public void testMailFreemarker(){
        //pingVipMailService.testMailFreemarker();
    }
}
