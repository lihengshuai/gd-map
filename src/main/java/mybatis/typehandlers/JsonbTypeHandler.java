package mybatis.typehandlers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

/**
 * Created by ywb on 19/9/2018.
 *
 * 数据类型转换 数据库JSON类型 <==> Java class
 */
public class JsonbTypeHandler<T> extends JsonNewTypeHandler<T> {


  public JsonbTypeHandler(Class<T> clazz) {
    this.clazz = Objects.requireNonNull(clazz, "Type argument cannot be null");

  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)
      throws SQLException {
    PGobject jsonObject = new PGobject();
    jsonObject.setType("jsonb");
    jsonObject.setValue(toJson(parameter));
    ps.setObject(i, jsonObject);

  }


}
