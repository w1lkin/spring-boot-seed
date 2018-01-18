package com.welkin.springbootseed.web.api.thread;

import com.welkin.springbootseed.web.api.thread.model.MyThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thread
 *
 * @author welkin
 */
@Path("thread")
@Consumes({MediaType.APPLICATION_JSON})
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Api(tags = "Thread", description = "线程")
public class ThreadApi {

  private static final Logger logger = LogManager.getLogger(ThreadApi.class);

  @GET
  @Path("/pool/{type}")
  @ApiOperation("创建线程池")
  public Boolean create(
      @ApiParam(
              "线程池类型：0-未知 1-newSingleThreadExecutor 2-newFixedThreadPool 3-newCachedThreadPool 4-newScheduledThreadPool")
          @PathParam("type")
          Integer type) {
    ExecutorService pool = Executors.newSingleThreadExecutor();
    switch (type) {
      case 1:
        //newSingleThreadExecutor：创建单线程的线程池（当前线程异常结束，会有一个替代线程），执行顺序=提交顺序
        pool = Executors.newSingleThreadExecutor();
        break;
      case 2:
        //newFixedThreadPool：创建固定大小的线程池，提交一个任务创建一个线程（直到最大， 某个线程异常结束，会有一个替代线程 ）
        pool = Executors.newFixedThreadPool(2);
        break;
      case 3:
        //newCachedThreadPool：创建可缓存的线程池，线程池大小不做限制，线程池>提交任务数，回收部分空闲（60s不执行）线程；线程池<提交任务，添加新线程
        pool = Executors.newCachedThreadPool();
        break;
      case 4:
        //newScheduledThreadPool：创建无限大小的线程池，支持定时以及周期性执行任务的需求
        pool = Executors.newScheduledThreadPool(1);
        runNewScheduledThreadPool((ScheduledThreadPoolExecutor) pool);
        return true;
    }
    //
    Thread t1 = new MyThread();
    Thread t2 = new MyThread();
    Thread t3 = new MyThread();
    Thread t4 = new MyThread();
    Thread t5 = new MyThread();
    //
    pool.execute(t1);
    pool.execute(t2);
    pool.execute(t3);
    pool.execute(t4);
    pool.execute(t5);
    //
    pool.shutdown();
    //
    return true;
  }

  private void runNewScheduledThreadPool(ScheduledThreadPoolExecutor executor) {
    //
    executor.scheduleAtFixedRate(
        new Runnable() {
          @Override
          public void run() {
            System.out.println("================");
          }
        },
        1000,
        5000,
        TimeUnit.MILLISECONDS);
    //
    executor.scheduleAtFixedRate(
        new Runnable() {
          @Override
          public void run() {
            System.out.println(System.nanoTime());
          }
        },
        1000,
        2000,
        TimeUnit.MILLISECONDS);

  }
}
