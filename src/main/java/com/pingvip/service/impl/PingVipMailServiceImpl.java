package com.pingvip.service.impl;

import com.pingvip.VO.EmailParamsVO;
import com.pingvip.dao.EmailContentMapper;
import com.pingvip.dao.UserInfoMapper;
import com.pingvip.entity.EmailContent;
import com.pingvip.entity.UserInfo;
import com.pingvip.service.PingVipMailService;
import com.pingvip.tool.FreeMarkerUtil;
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
    private EmailContentMapper emailContentMapper;
    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void sendMail(EmailParamsVO emailParamsVO) {
        EmailContent emailContent = emailContentMapper.selectByName(emailParamsVO.getName());
        String title = FreeMarkerUtil.toFreeMarkerContent(emailParamsVO.getName(),emailContent.getTitle(),emailParamsVO.getTitleParams());
        String content = FreeMarkerUtil.toFreeMarkerContent(emailParamsVO.getName(),emailContent.getContent(),emailParamsVO.getContentParams());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailParamsVO.getTo());
        message.setCc(emailParamsVO.getCc());
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);
    }
}
