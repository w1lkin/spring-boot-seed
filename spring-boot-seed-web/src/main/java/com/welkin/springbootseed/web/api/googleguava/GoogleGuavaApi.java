package com.welkin.springbootseed.web.api.googleguava;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * google guava
 *
 * @author welkin
 */
@Path("guava")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "google guava", description = "google guava")
public class GoogleGuavaApi {

  private static final Logger logger = LogManager.getLogger(GoogleGuavaApi.class);

  @GET
  @Path("/hello/{name}")
  @ApiOperation("hello")
  public String hello(@PathParam("name") String name) {
    return "Hello "+name;
  }

}
