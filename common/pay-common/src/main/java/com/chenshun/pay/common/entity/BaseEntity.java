package com.chenshun.pay.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:11  <p />
 * Version: V1.0  <p />
 * Description: 基础实体类，包含各实体公用属性 <p />
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 9078067052470575673L;

    private Long id;

    private Integer version = 0;

    /** 创建时间 */
    protected Date createTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
