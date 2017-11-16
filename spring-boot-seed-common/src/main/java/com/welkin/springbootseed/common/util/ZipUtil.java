package com.welkin.springbootseed.common.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 *
 * @author welkin
 */
public class ZipUtil {

  /**
   * 压缩网络图片到流
   *
   * @param urlString
   * @param zipStream
   * @param fileName
   * @throws Exception
   */
  private static void zip(String urlString, ZipOutputStream zipStream, String fileName)
      throws Exception {
    InputStream inputStream = null;
    try {
      URL url = new URL(urlString);
      URLConnection con = url.openConnection();
      con.setConnectTimeout(5 * 1000);
      con.setUseCaches(false);
      con.setDefaultUseCaches(false);
      inputStream = con.getInputStream();
      zip(inputStream, zipStream, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }

  public static void zip(Map<String, String> urls, ZipOutputStream zipOutputStream) {
    try {
      Map<String, String> synUrls = Collections.synchronizedMap(urls);
      Set<Map.Entry<String, String>> set = synUrls.entrySet();
      Iterator<Map.Entry<String, String>> it = set.iterator();
      while (it.hasNext()) {
        Map.Entry<String, String> entry = it.next();
        zip(entry.getValue(), zipOutputStream, entry.getKey());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 压缩文件到流
   *
   * @param file
   * @param exportFileName
   * @param zipOutputStream
   * @throws IOException
   */
  public static void zip(File file, String exportFileName, ZipOutputStream zipOutputStream)
      throws IOException {
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(file);
      zip(fileInputStream, zipOutputStream, exportFileName);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (fileInputStream != null) {
        fileInputStream.close();
      }
    }
  }

  public static void zip(
      InputStream inputStream, ZipOutputStream zipOutputStream, String exportFileName)
      throws IOException {
    Objects.requireNonNull(inputStream);
    BufferedInputStream bufferedInputStream = null;
    try {
      ZipEntry zipEntry = new ZipEntry(exportFileName);
      zipOutputStream.putNextEntry(zipEntry);
      byte[] bytes = new byte[1024 * 5]; // 读写缓冲区
      bufferedInputStream = new BufferedInputStream(inputStream); // 输入缓冲流
      int read = 0;
      while ((read = bufferedInputStream.read(bytes)) != -1) {
        zipOutputStream.write(bytes, 0, read);
      }
    } finally {
      if (bufferedInputStream != null) {
        bufferedInputStream.close();
      }
      if (inputStream != null) {
        inputStream.close();
      }
    }
  }
}
