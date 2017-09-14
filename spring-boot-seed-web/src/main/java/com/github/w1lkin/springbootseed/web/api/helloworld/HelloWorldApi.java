package com.github.w1lkin.springbootseed.web.api.helloworld;

import com.github.w1lkin.springbootseed.web.api.helloworld.model.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/** @author welkin HelloWorld */
@Path("")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(tags = "你好,世界", description = "你好,世界")
public class HelloWorldApi {

  @GET
  @Path("/hello/{name}")
  @ApiOperation("你好,世界")
  public Message say(@PathParam("name") String name) {
    Message message = new Message();
    message.setMessage("hey "+name);
    return message;
  }

  @GET
  @Path("/hello2/{name}")
  @ApiOperation("你好,世界")
  public String say2(@PathParam("name") String name) {
    return "say "+name;
  }
}
