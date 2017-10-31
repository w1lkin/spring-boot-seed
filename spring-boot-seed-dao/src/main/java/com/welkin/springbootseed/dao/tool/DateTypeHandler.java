package com.welkin.springbootseed.dao.tool;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将db中的默认时间转换为空
 *
 * @author chenyankun @Date 2017/5/21
 */
@MappedJdbcTypes({JdbcType.TIMESTAMP})
@MappedTypes({Date.class})
public class DateTypeHandler extends BaseTypeHandler<Date> {

  private static final String DEFAULT_TIME = "2000-01-01 00:00:00";

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
      throws SQLException {

    ps.setTimestamp(i, new Timestamp(parameter.getTime()));
  }

  private Date getData(String data) {

    if (data == null || "".equals(data)) {
      return null;
    }
    String tmp = data;
    if (data.indexOf(".") != -1) {
      tmp = tmp.substring(0, tmp.lastIndexOf("."));
    }
    if (DEFAULT_TIME.equals(tmp)) {
      return null;
    }
    // simple date format 非线程安全，不能抽出去
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      return dateFormat.parse(tmp);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {

    String data = rs.getString(columnName);
    return getData(data);
  }

  @Override
  public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

    String string = rs.getString(columnIndex);
    return getData(string);
  }

  @Override
  public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

    return cs.getDate(columnIndex);
  }
}
