package com.welkin.springbootseed.web.api.file.order;

import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.template.TemplateEngine;
import com.welkin.springbootseed.common.util.BeanUtil;
import com.welkin.springbootseed.common.util.DateUtil;
import com.welkin.springbootseed.common.util.FileUtil;
import com.welkin.springbootseed.model.entity.mysql.order.Order;
import com.welkin.springbootseed.model.template.jxls.TOrder;
import com.welkin.springbootseed.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单文件服务
 *
 * @author welkin
 */
@Path("download/orders")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_OCTET_STREAM)
@Api(tags = "订单文件服务", description = "订单文件服务")
public class OrderFileApi {

  private static final Logger logger = LogManager.getLogger(OrderFileApi.class);

  @Autowired private OrderService orderService;
  @Autowired private TemplateEngine templateEngine;

  @GET
  @Path("/{id}/zip")
  @ApiOperation("下载订单信息zip")
  public Response downloadOrderZip(@PathParam("id") Integer id) {
    return null;
  }

  @GET
  @Path("/excel")
  @ApiOperation("下载订单信息excel")
  public Response downloadOrderExcel() {
    List<Order> orders = orderService.getList();
    if (CollectionUtils.isEmpty(orders)) {
      BizException.fail(ApiResponseCode.DATA_NOT_EXIST, "订单不存在");
    }
    try {
      //
      String templateName = "order_details";
      File tempFile = File.createTempFile("orders", ".xlsx");
      OutputStream outputStream = new FileOutputStream(tempFile.getPath());
      List<TOrder> tOrders = BeanUtil.copyList(orders, TOrder.class);
      Map context = new HashMap();
      context.put("orders", tOrders);
      try {
        templateEngine.process(templateName, context, outputStream);
      } finally {
        outputStream.close();
      }
      //
      StreamingOutput streamingOutput =
          new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
              try {
                FileUtil.read(output, tempFile);
              } finally {
                if (tempFile.exists()) {
                  tempFile.delete();
                }
              }
            }
          };

      String filename = URLEncoder.encode("订单详情" + DateUtil.getChineseDateStr(new Date()), "UTF-8");
      return Response.ok(streamingOutput, "application/msexcel")
          .header("Content-Disposition", "attachment; filename=" + filename + ".xlsx")
          .build();
    } catch (Exception e) {
      BizException.fail(ApiResponseCode.UN_KNONW_ERROR, e.getMessage());
      logger.error("下载订单信息excel失败: " + e.getMessage());
    }
    return null;
  }
}
