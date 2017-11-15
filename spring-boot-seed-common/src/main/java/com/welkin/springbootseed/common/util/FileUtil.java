package com.welkin.springbootseed.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * 文件工具类
 *
 * @author welkin
 */
public class FileUtil {
    private static final Logger logger = LogManager.getLogger(FileUtil.class);
  /**
   * 读文件到流
   *
   * @param outputStream
   * @param file
   */
  public static void read(OutputStream outputStream, File file) {
    try {
      FileInputStream fileInputStream = null;
      BufferedInputStream bufferedInputStream = null;
      try {
        byte[] bytes = new byte[1024 * 5];
        fileInputStream = new FileInputStream(file);
        bufferedInputStream = new BufferedInputStream(fileInputStream);
        int read = 0;
        while ((read = bufferedInputStream.read(bytes)) != -1) {
          outputStream.write(bytes, 0, read);
        }
      } finally {
        if (bufferedInputStream != null) {
          bufferedInputStream.close();
        }
        if (fileInputStream != null) {
          fileInputStream.close();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
