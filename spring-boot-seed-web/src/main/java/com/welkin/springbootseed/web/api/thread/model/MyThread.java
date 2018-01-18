package com.welkin.springbootseed.web.api.thread.model;

public class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "正在执行..");
  }
}
