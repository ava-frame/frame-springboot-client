package com.ava.frame.springboot.client.domain;

import com.alibaba.fastjson.JSONObject;
import com.ava.frame.core.type.Status;
import com.ava.frame.core.utils.UUIDUtils;
import com.ava.frame.mongo.annotation.Table;

/**
 * Created by redredava on 2018/6/5.
 * email:zhyx2014@yeah.net
 */
@Table(name = DbTable.semantic_smart_home)
public class SemanticSmartHome {
    private String domain;
    private String words;
    private JSONObject param;
    //    唯一标识==_key
    private String uuid= UUIDUtils.uuid();
    private long updateAt=System.currentTimeMillis()/1000;
    private Status status=Status.active;

    public JSONObject getParam() {
        return param;
    }

    public void setParam(JSONObject param) {
        this.param = param;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getWords() {
        return words;
    }
    public void setWords(String words) {
        this.words = words;
    }

}
