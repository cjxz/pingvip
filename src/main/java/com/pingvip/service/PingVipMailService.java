package com.pingvip.service;

import com.pingvip.VO.EmailParamsVO;

import java.io.IOException;
import java.util.Map;

public interface PingVipMailService {

    public void sendMail(EmailParamsVO emailParamsVO);

}
