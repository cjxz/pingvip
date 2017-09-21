package com.pingvip.tool;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtil {
    private static Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);

    /**
     *
     * @param name 模板名字
     * @param content 模板内容
     * @param map 模板里面的参数
     * @return html
     */
    public static String toFreeMarkerContent(String name ,String content,Map<String,Object> map){
        Configuration configuration = new Configuration(new Version("2.3.25"));
        Reader r = null;
        Writer w = null;
        try{
            r = new StringReader(content);
            Template t = new Template(name,r,configuration);
            w = new StringWriter();
            t.process(map,w);
            return w.toString();
        }catch (IOException e){
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {
            try{
                if(r != null)
                    r.close();

                if( w != null)
                    w.close();
                logger.info("流关闭正常关闭");
            }catch (IOException e){
                e.printStackTrace();
                logger.error("关闭流出错！！！");
            }
        }
        return "";
    }
}
