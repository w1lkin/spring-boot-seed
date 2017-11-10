package com.welkin.springbootseed.service.common.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.DateUtil;
import com.welkin.springbootseed.model.dto.file.FileUploadParam;
import com.welkin.springbootseed.model.dto.file.UploadDTO;
import com.welkin.springbootseed.service.common.FileService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
  private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

  @Autowired
  private OSSClient ossClient;

  @Value("${aliyun.oss.bucketName}")
  private String bucketName;

  @Value("${aliyun.oss.folder}")
  private String folder;

  @Value("${file.upload.domain.url}")
  private String domainUrl;

  @Value("${file.expire.minute}")
  private int expiresMinute;

  @Override
  public List<UploadDTO> upload(List<FileUploadParam> fileUploadParams) {
    if (CollectionUtils.isEmpty(fileUploadParams)){
      return null;
    }
    //
    List<UploadDTO> uploadDTOS = new ArrayList<>();
    fileUploadParams.stream().forEach(fileUploadParam -> {
      String fileName=fileUploadParam.getFileName();
      String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
      String path=getPath(folder,suffix);
      InputStream inputStream=new ByteArrayInputStream(fileUploadParam.getData());
      try {
        ossClient.putObject(bucketName,path,inputStream);
      } catch (OSSException e) {
        logger.error("ossClient.putObject fail");
        BizException.fail(ApiResponseCode.UN_KNONW_ERROR,e.getMessage());
      } catch (ClientException e) {
        logger.error("ossClient.putObject fail");
        BizException.fail(ApiResponseCode.UN_KNONW_ERROR,e.getMessage());
      }
      //
      uploadDTOS.add(new UploadDTO(domainUrl,path));
    });
    return uploadDTOS;
  }

  @Override
  public String get(String path) {
    URL url=ossClient.generatePresignedUrl(bucketName,path, DateUtil.addMinutes(new Date(), expiresMinute));
    return url.toString();
  }

  private String getPath(String folder,String suffix){
    StringBuffer sb = new StringBuffer();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    sb.append(folder);
    sb.append("/");
    sb.append(dateFormat.format(new Date()));
    sb.append("/");
    sb.append(StringUtils.replace(UUID.randomUUID().toString(),"-",""));
    if(StringUtils.isNotBlank(suffix)){
      sb.append(".");
      sb.append(suffix);
    }
    return sb.toString();
  }
}
