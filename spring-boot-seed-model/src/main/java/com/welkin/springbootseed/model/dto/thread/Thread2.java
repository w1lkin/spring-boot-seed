package com.welkin.springbootseed.model.dto.thread;

public class Thread2 implements Runnable {
  private String name;

  public Thread2(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    Thread thread = Thread.currentThread();
    System.out.println(name+"："+thread.getName());
  }
}
