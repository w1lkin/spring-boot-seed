package com.welkin.springbootseed.web.api.helloworld;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.web.api.helloworld.model.Message;
import com.welkin.springbootseed.web.filter.FilterTest;
import com.welkin.springbootseed.web.filter.InterceptorTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 你好,世界
 *
 * @author welkin
 */
@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "你好,世界", description = "你好,世界")
public class HelloWorldApi {

  private static final Logger logger = LogManager.getLogger(HelloWorldApi.class);

  @GET
  @Path("/hello/{name}")
  @ApiOperation("你好,世界")
  @FilterTest
  @InterceptorTest
  public Message say(@PathParam("name") String name) {
    //
    logger.info("say: 3");
    logger.info("request: " + name);

    Message message = new Message();
    message.setMessage("hey " + name);

    logger.info("response: " + JSON.toJSONString(message));
    return message;
  }

  @GET
  @Path("/hello2/{name}")
  @ApiOperation("你好,世界")
  public String say2(@PathParam("name") String name) {
    return "say " + name;
  }
}
