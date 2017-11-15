package com.welkin.springbootseed.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JxlsUtil {
  private static final Logger logger = LogManager.getLogger(JxlsUtil.class);

  /**
   * 时间格式转换
   *
   * @param date
   * @param formatStr
   * @return\   */
  public static String dateFormat(Date date, String formatStr) {
    Objects.requireNonNull(date);
    Objects.requireNonNull(formatStr);
    DateFormat format = new SimpleDateFormat(formatStr);
    return format.format(date);
  }

  /**
   * 金额转换
   *
   * @param value
   * @param format
   * @param unit
   * @return
   */
  public String moneyFormat(Long value, String format, String unit) {
    Calculator divideValue = Calculator.create(value).divide(10000, 2, RoundingMode.HALF_UP);
    DecimalFormat df = new DecimalFormat(format);
    return df.format(divideValue.getValue()) + unit;
  }

  public String moneyFormat(Long value, String format) {
    Calculator divideValue = Calculator.create(value).divide(10000, 2, RoundingMode.HALF_UP);
    DecimalFormat df = new DecimalFormat(format);
    return df.format(divideValue.getValue());
  }

  /**
   * 将excel中枚举值转换为相应的文案输出
   *
   * @param key 枚举值
   * @param valueMap 枚举值对应的文案
   * @return
   */
  public String getEnumValue(Integer key, String valueMap) {
    if (!StringUtils.isEmpty(valueMap)) {
      String replace = valueMap.replace("[", "{").replace("]", "}");
      Map<String, String> values = (Map<String, String>) (JSON.parse(replace));

      if (values.containsKey(key.toString())) {
        return values.get(key.toString());
      }
    }
    return "";
  }
}
