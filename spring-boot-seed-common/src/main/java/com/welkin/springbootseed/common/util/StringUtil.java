package com.welkin.springbootseed.common.util;

import org.springframework.util.NumberUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** @author welkin */
public class StringUtil {

  private static final String EMPTY = "";

  public static String newUtf8String(String str) {

    if (str == null || "".equals(str)) return "";
    try {
      return new String(str.getBytes("iso8859-1"), "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return "";
    }
  }

  public static String newISOString(String str) {

    if (str == null || "".equals(str)) return "";
    try {
      return new String(str.getBytes("GB2312"), "ISO-8859-1");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return "";
    }
  }

  public static String trim(String str) {
    return str == null ? EMPTY : str.trim();
  }

  public static <T extends Number> List<T> split(String str, Class<T> clazz) {

    if (str == null || "".equals(str)) {
      return Collections.emptyList();
    }
    String[] array = str.split(",");
    List<T> result = new ArrayList<>();

    for (String s : array) {

      result.add(NumberUtils.parseNumber(s, clazz));
    }
    return result;
  }

  /**
   * 第一个字母大写
   *
   * @param source
   * @return
   */
  public static String upperFirstChar(String source) {
    if (source.length() == 0 || source == null) {
      return "";
    }
    Character firstChar = source.charAt(0);
    if (Character.isLowerCase(firstChar)) {
      return Character.toUpperCase(firstChar) + source.substring(1);
    }
    return source;
  }

  /**
   * MD5
   *
   * @param plainText
   * @return
   * @throws Exception
   */
  public static String md5(String plainText) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(plainText.getBytes());
    byte b[] = md.digest();
    int i;

    StringBuffer buf = new StringBuffer("");
    for (int offset = 0; offset < b.length; offset++) {
      i = b[offset];
      if (i < 0) i += 256;
      if (i < 16) buf.append("0");
      buf.append(Integer.toHexString(i));
    }
    return buf.toString();
  }
}
