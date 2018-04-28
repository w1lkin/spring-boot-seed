package com.welkin.springboot.test.Thread;

import com.welkin.springboot.test.BaseTests;
import com.welkin.springbootseed.model.dto.thread.Thread2;
import org.junit.Test;

public class ThreadTests extends BaseTests {

  @Test
  public void threadTest() {
    Thread2 th1 = new Thread2("chen");
    Thread thread1 = new Thread(th1);
    thread1.start();
  }
}
