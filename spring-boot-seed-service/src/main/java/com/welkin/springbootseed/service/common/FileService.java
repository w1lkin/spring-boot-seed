package com.welkin.springbootseed.service.common;

import com.welkin.springbootseed.model.dto.file.FileUploadParam;
import com.welkin.springbootseed.model.dto.file.UploadDTO;

import java.util.List;

/**
 * 文件服务
 *
 * @author welkin
 */
public interface FileService {
    /**
     * 批量上传文件
     * @param fileUploadParams
     * @return
     */
    List<UploadDTO> upload(List<FileUploadParam> fileUploadParams);

    /**
     * 获取文件
     * @param path
     * @return
     */
    String get(String path);
}
