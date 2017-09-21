package com.pingvip.tool;

import com.pingvip.entity.UserInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtil {


    public static void test()throws Exception{
        Configuration configuration = new Configuration(new Version("2.3.25"));
        String mailContent = "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<body>\n" +
                "Name: ${user.userName}! <br>\n" +
                "Q:Why I like? <br>\n" +
                "A:${user.userEmail}!\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        Reader r = new StringReader(mailContent);
        Template t = new Template("user.ftl",r,configuration);
        UserInfo u = new UserInfo();
        u.setUserName("ceshi");
        u.setUserEmail("ssss@qq.com");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user",u);
        t.process(map,new PrintWriter(System.out));
    }
    public static void main(String[] args)throws  Exception{
        FreeMarkerUtil.test();
    }

}
