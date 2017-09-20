package com.pingvip.service;

import com.pingvip.entity.UserInfo;

public interface UserInfoService {
    public void saveUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(int i);
}
