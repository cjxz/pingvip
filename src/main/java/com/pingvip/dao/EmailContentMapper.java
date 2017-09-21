package com.pingvip.dao;


import com.pingvip.entity.EmailContent;

public interface EmailContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmailContent record);

    int insertSelective(EmailContent record);

    EmailContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmailContent record);

    int updateByPrimaryKeyWithBLOBs(EmailContent record);

    int updateByPrimaryKey(EmailContent record);

    EmailContent selectByName(String name);
}