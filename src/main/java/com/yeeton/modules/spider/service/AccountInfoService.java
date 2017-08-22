package com.yeeton.modules.spider.service;

import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

/**
 * Created by user on 2017/6/22.
 */

@Service
public class AccountInfoService {
    @Autowired
    private AccountInfoRepository accountInfoRepository;

    /**
     * 添加单个
     * param keywords
     * return
    */
    @Transient
    public void save(AccountInfo accountInfo){
        accountInfoRepository.save(accountInfo);
    }

    /**
     * 批量添加
     * @param accountInfoList
     */
    @Transient
    public void save(List<AccountInfo> accountInfoList){
        accountInfoRepository.save(accountInfoList);
    }


    @Transient
    public List<AccountInfo>  findList(){

        return accountInfoRepository.findAll();
    }

    @Lazy(false)
    @Transient
    public AccountInfo getOne(Long id){

        return accountInfoRepository.getOne(id);
    }


}
