package com.pingvip.service.impl;

import com.pingvip.dao.UserInfoMapper;
import com.pingvip.entity.UserInfo;
import com.pingvip.service.PingVipMailService;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PingVipMailServiceImpl implements PingVipMailService{
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Value("${spring.mail.username}")
    private String username;
    @Override
    public void mailTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo("985552943@qq.com");
        message.setSubject("标题：测试标题");
        message.setText("测试内容部份");
        javaMailSender.send(message);
    }

    @Override
    public void testMailFreemarker() throws Exception {
        UserInfo user = userInfoMapper.selectByPrimaryKey(1);
        String path = "/web/user.ftl";
        File file = new File(path);
        TemplateLoader loader = new FileTemplateLoader(file);
        Configuration configuration = new Configuration();
        Template template = configuration.getTemplate("user.html");
        Map<String,UserInfo> map = new HashMap<String, UserInfo>();
        map.put("user",user);


    }
}
