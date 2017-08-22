package com.yeeton.modules.spider.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by user on 2017/7/12.
 */
@Entity(name = "account_info")
public class AccountInfo {

  /*    `_id` bigint(20) NOT NULL,
        `icon` varchar(255) DEFAULT NULL COMMENT '图标',
        `image` varchar(255) DEFAULT NULL COMMENT '第二图标',
        `url` varchar(255) NOT NULL COMMENT '访问地址',
        `account_id` varchar(50) NOT NULL COMMENT '账号',
        `account_name` varchar(255) NOT NULL COMMENT '账号名称',
        `account_type` int(10) NOT NULL COMMENT '账号类型',
        `account_type_name` varchar(255) NOT NULL COMMENT '账号类型名称',
        `org_id` bigint(20) NOT NULL COMMENT '所属机构ID',
        `org_name` varchar(255) NOT NULL COMMENT '所属机构名称',
        `keywords` varchar(255) NOT NULL COMMENT '搜索的关键词',
        `labels` varchar(255) DEFAULT NULL COMMENT '标签',
        `renzhen` varchar(255) DEFAULT NULL COMMENT '认证信息',
        `describe` varchar(255) DEFAULT NULL COMMENT '描述',
        `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0未处置 1风险 2 官方 3 诈骗 ',
        `create_time` datetime DEFAULT NULL COMMENT '添加时间',*/

    @Id
    @GeneratedValue
    private Long _id;
    private String icon;                    //图标
    private String image;                   //第二图标
    private String url;                     //访问地址
    @Column(name="account_id")
    private String accountId;               //账号ID
    @Column(name="account_name")
    private String accountName;             //账号名称
    @Column(name="account_type")
    private Integer accountType;             //账号类型
    @Column(name="account_type_name")
    private String accountTypeName;         //账号类型名称
    @Column(name="orgId")
    private Long org_id;         //账号类型名称
    @Column(name="orgName")
    private String org_name;         //账号类型名称

    private String keywords;                //搜索的关键词
    private String labels;                  //标签
    private String renzhen;                 //认证信息
    private String remarks;                //描述
    private Integer status;                  //状态

    @Column(name="create_time")
    private Date createTime;

    public AccountInfo() {
        this.setCreateTime(new Date());
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long  org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getRenzhen() {
        return renzhen;
    }

    public void setRenzhen(String renzhen) {
        this.renzhen = renzhen;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
