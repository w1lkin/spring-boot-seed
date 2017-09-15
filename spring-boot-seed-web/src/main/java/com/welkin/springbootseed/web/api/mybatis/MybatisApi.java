package com.welkin.springbootseed.web.api.mybatis;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.web.api.helloworld.model.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/** @author welkin Mybatis */
@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
@Api(tags = "Mybatis", description = "Mybatis")
public class MybatisApi {

  private static final Logger logger = LogManager.getLogger(MybatisApi.class);

  @GET
  @Path("/orders/{orderId}")
  @ApiOperation("获取一个订单")
  public Message getOrder(@PathParam("orderId") Integer orderId) {
    logger.info("request: "+orderId);

    Message message = new Message();
    message.setMessage("hey "+orderId);

    logger.info("response: "+ JSON.toJSONString(message));
    return message;
  }

}
