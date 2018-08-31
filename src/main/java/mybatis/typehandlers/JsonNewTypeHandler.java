package mybatis.typehandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.codehaus.plexus.util.StringUtils;
import org.postgresql.util.PGobject;

/**
 * Created by ywb on 19/9/2018.
 *
 * 数据类型转换 数据库JSON类型 <==> Java class
 */
public class JsonNewTypeHandler<T> extends BaseTypeHandler<T> {

  public JsonNewTypeHandler() {
  }

  public JsonNewTypeHandler(Class<T> clazz) {
    this.clazz = Objects.requireNonNull(clazz, "Type argument cannot be null");
  }

  private static final ObjectMapper mapper = new ObjectMapper();
  Class<T> clazz;

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
      throws SQLException {
    PGobject jsonObject = new PGobject();
    jsonObject.setType("json");
    jsonObject.setValue(toJson(parameter));
    ps.setObject(i, jsonObject);


  }

  @Override
  public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return toObject(Objects.toString(rs.getObject(columnName)), clazz);
  }

  @Override
  public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return toObject(Objects.toString(rs.getObject(columnIndex)), clazz);

  }

  @Override
  public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return toObject(Objects.toString(cs.getObject(columnIndex)), clazz);
  }

  String toJson(T object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private T toObject(String content, Class<T> clazz) {
    if (!StringUtils.isBlank(content)) {
      try {
        return mapper.readValue(content, clazz);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    } else {
      return null;
    }
  }


}
