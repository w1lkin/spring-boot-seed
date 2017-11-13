package com.welkin.springbootseed.boot.autoconfigure.aliyun;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Aliyun Auto Configuration
 *
 * @author welkin
 * @version 2.0.0
 */
@Configuration
@ConditionalOnClass(OSS.class)
@ConditionalOnProperty(name = "aliyun.oss.enabled", matchIfMissing = true)
@EnableConfigurationProperties(AliyunOssProperties.class)
public class AliyunAutoConfiguration {

    @Autowired
    private AliyunOssProperties aliyunOssProperties;

    @Bean
    public OSSClient ossClient() {
        OSSClient ossClient = new OSSClient(aliyunOssProperties.getEndpoint(),
                aliyunOssProperties.getAccessKeyId(), aliyunOssProperties.getSecretAccessKey());
        return ossClient;
    }

}
