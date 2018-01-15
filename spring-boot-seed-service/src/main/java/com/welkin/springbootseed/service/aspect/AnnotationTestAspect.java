package com.welkin.springbootseed.service.aspect;

import com.alibaba.fastjson.JSON;
import com.welkin.springbootseed.common.util.DateUtil;
import com.welkin.springbootseed.service.annotation.AnnotationTest;
import com.welkin.springbootseed.service.order.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class AnnotationTestAspect {
  private static final Logger logger = LogManager.getLogger(AnnotationTestAspect.class);

  @Autowired private OrderService orderService;

  @Pointcut(value = "@annotation(com.welkin.springbootseed.service.annotation.AnnotationTest)")
  public void testPointcut() {}

  /**
   * 前置通知：在连接点执行前的通知，但不能阻止连接点前的执行（除非它抛出一个异常）
   *
   * @param point
   * @param annotationTest
   */
  @Before(value = "testPointcut()&& @annotation(annotationTest)")
  public void beforeAdvice(JoinPoint point, AnnotationTest annotationTest) {
    logger.info(
        "===============================beforeAdvice=======================================");
    logger.info("LoggerHandlerAop.beforeAdvice...time:" + DateUtil.now());
    logger.info("Hello, " + annotationTest.name());
    logger.info("Order: " + JSON.toJSONString(orderService.getList().get(0)));
    Signature signature = point.getSignature();
    logger.info(
        "所属类名称："
            + signature.getDeclaringTypeName()
            + "\n代理类："
            + signature.getClass()
            + "\n方法名称："
            + signature.getName()
            + "\n所属类："
            + signature.getDeclaringType());
    Object[] args = point.getArgs();
    logger.info("参数是：" + JSON.toJSONString(args));
    logger.info("被织入的对象是：" + point.getTarget());
    logger.info(
        "===============================beforeAdvice=======================================");
  }

  /** 返回后通知：在连接点正常执行完后执行的通知 */
  @AfterReturning("testPointcut()")
  public void afterReturningAdvice() {
    logger.info("LoggerHandlerAop.afterReturningAdvice...time:" + DateUtil.now());
  }

  /** 抛出异常后通知：在连接节点抛出异常退出时执行的通知 */
  @AfterThrowing("testPointcut()")
  public void afterThrowingAdvice() {
    logger.info("LoggerHandlerAop.afterThrowingAdvice...time:" + DateUtil.now());
  }

  /** 后置通知：当某连接节点退出的时候执行的通知（不论是正常返回还是异常退出） */
  @After("testPointcut()")
  public void afterFinallyAdvice() {
    logger.info("LoggerHandlerAop.afterFinallyAdvice...time:" + DateUtil.now());
  }

  /**
   * 环绕通知：包围一个连接点（join point）的通知
   *
   * @param pjp
   * @return
   */
  @Around("testPointcut()")
  public Object aroundAdvice(ProceedingJoinPoint pjp) {
    logger.info("LoggerHandlerAop.aroundAdvice...time:" + DateUtil.now());
    Object obj = null;
    try {
      System.out.println("MoocAspect around 1.");
      obj = pjp.proceed();
      System.out.println("MoocAspect around 2.");
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return obj;
  }
}
