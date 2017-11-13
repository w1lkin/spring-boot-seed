package com.welkin.springbootseed.web.api.file.download.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 文件下载
 *
 * @author welkin
 */
@Path("download/orders")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_OCTET_STREAM)
@Api(tags = "文件下载", description = "文件下载")
public class OrderApi {

  private static final Logger logger = LogManager.getLogger(OrderApi.class);

  @GET
  @Path("/{id}")
  @ApiOperation("下载订单")
  public Response downloadOrder(@PathParam("id") Integer id) {
    return null;
  }
}
