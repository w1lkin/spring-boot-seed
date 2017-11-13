package com.welkin.springbootseed.web.api.file.upload;

import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.common.util.StringUtil;
import com.welkin.springbootseed.model.dto.file.FileUploadParam;
import com.welkin.springbootseed.model.dto.file.UploadDTO;
import com.welkin.springbootseed.service.common.FileService;

import com.welkin.springbootseed.web.api.file.upload.model.UploadVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传
 *
 * @author welkin
 */
@Path("files")
@Api(tags = "文件上传", description = "文件上传")
public class UploadApi {

  private static final Logger logger = LogManager.getLogger(UploadApi.class);

  @Autowired private FileService fileService;

  @POST
  @Consumes({MediaType.MULTIPART_FORM_DATA})
  @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
  @Path("/upload")
  @ApiOperation("文件上传")
  public List<UploadVO> upload(@ApiParam("文件附件") @Multipart(value = "files") List<Attachment> files){
      if (CollectionUtils.isEmpty(files)){
        BizException.fail(ApiResponseCode.PARA_MISSING_ERR,"文件不能为空");
      }
      //
      List<FileUploadParam> fileUploadParams=new ArrayList<>();
      files.stream().forEach(file->{
        DataHandler dataHandler=file.getDataHandler();
        byte[] data= null;
        try {
          data=StreamUtils.copyToByteArray(dataHandler.getInputStream());
        } catch (IOException e) {
          logger.error("upload fail");
          BizException.fail(ApiResponseCode.UN_KNONW_ERROR,e.getMessage());
        }
        String fileName= StringUtil.newUtf8String(dataHandler.getName());
        FileUploadParam fileUploadParam=new FileUploadParam(fileName,data);
        fileUploadParams.add(fileUploadParam);
      });
      List<UploadDTO> uploadDTOS=fileService.upload(fileUploadParams);
      //
      List<UploadVO> uploadVOS = new ArrayList<>();
      if (!CollectionUtils.isEmpty(uploadDTOS)){
          uploadDTOS.stream().forEach(uploadDTO -> {
              UploadVO uploadVO=new UploadVO();
              BeanUtil.copyProperties(uploadDTO,uploadVO);
              uploadVO.setUrl(fileService.get(uploadDTO.getPath()));
              uploadVOS.add(uploadVO);
          });
      }
      return uploadVOS;
  }
}
