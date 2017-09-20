package com.pingvip.service.impl;

import com.pingvip.dao.UserInfoMapper;
import com.pingvip.entity.UserInfo;
import com.pingvip.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfo getUserInfo(int i) {
        String key = "user_"+i;
        ValueOperations<String,UserInfo> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            LOGGER.info("从redis里面获取");
            UserInfo user = operations.get(key);
            return user;
        }else{
            LOGGER.info("从DB里面获取");
            UserInfo user = userInfoMapper.selectByPrimaryKey(i);
            operations.set(key,user);
            return user;
        }
    }
}
