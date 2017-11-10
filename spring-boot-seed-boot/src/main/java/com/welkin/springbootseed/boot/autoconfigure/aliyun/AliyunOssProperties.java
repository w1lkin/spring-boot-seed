package com.welkin.springbootseed.boot.autoconfigure.aliyun;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云 OSS 属性
 *
 * @author Gavin Hu
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = AliyunOssProperties.ALIYUN_OSS_PREFIX)
public class AliyunOssProperties {

    public static final String ALIYUN_OSS_PREFIX = "aliyun.oss";

    private String endpoint;

    private String accessKeyId;

    private String secretAccessKey;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

}
