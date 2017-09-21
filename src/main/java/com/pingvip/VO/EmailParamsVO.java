package com.pingvip.VO;

import java.util.Map;

public class EmailParamsVO {
    private String name;
    private Map<String,Object> titleParams;
    private Map<String,Object> contentParams;
    private String[] cc;
    private String[] to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getTitleParams() {
        return titleParams;
    }

    public void setTitleParams(Map<String, Object> titleParams) {
        this.titleParams = titleParams;
    }

    public Map<String, Object> getContentParams() {
        return contentParams;
    }

    public void setContentParams(Map<String, Object> contentParams) {
        this.contentParams = contentParams;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
}
