package com.welkin.springbootseed.web.api.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 文件
 * @author welkin
 */
@Path("file")
@Api(tags = "文件", description = "文件")
public class FileApi {

  private static final Logger logger = LogManager.getLogger(FileApi.class);

  @GET
  @Consumes({MediaType.MULTIPART_FORM_DATA})
  @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
  @Path("/upload")
  @ApiOperation("upload")
  public void upload(@Multipart List<Attachment> list) {

  }
}
