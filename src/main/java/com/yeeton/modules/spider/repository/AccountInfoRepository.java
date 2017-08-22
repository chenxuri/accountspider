package com.yeeton.modules.spider.repository;


import com.yeeton.modules.spider.domain.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017/6/22.
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfo,Long> {
}
