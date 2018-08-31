package mybatis.typehandlers;

import core.IntCodeEnum;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

/**
 * Handles conversion between PostgreSQL array type and array of concrete {@link
 * IntCodeEnum}
 *
 * @author Loki
 */
@MappedJdbcTypes(JdbcType.ARRAY)
public class IntEnumArrayTypeHandler<E extends IntCodeEnum>
    extends BaseTypeHandler<E[]> {

  private Class<E> type;

  @SuppressWarnings("unchecked")
  public IntEnumArrayTypeHandler(Class<E[]> type) {
    if (type == null) {
      throw new IllegalArgumentException("Type argument cannot be null");
    }
    Class<?> eType = type.getComponentType();
    if (eType == null) {
      throw new IllegalArgumentException(
          "Column type array expected, but got " + type);
    }
    this.type = (Class<E>) eType;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
      E[] parameter, JdbcType jdbcType)
      throws SQLException {

    List<Integer> ints = Arrays.stream(parameter).map(IntCodeEnum::getCode)
        .collect(Collectors.toList());

    Connection c = ps.getConnection();
    Array inArray = c.createArrayOf("smallint", ints.toArray());
    ps.setArray(i, inArray);
  }

  @Override
  @SuppressWarnings("unchecked")
  public E[] getNullableResult(ResultSet rs,
      String columnName) throws SQLException {
    Array outputArray = rs.getArray(columnName);
    if (outputArray == null) {
      return null;
    }
    Integer[] ints = getIntegersArray(outputArray);
    return Stream.of(ints).map(i -> E.getEnumForCode(type, i))
        .toArray(size -> (E[]) java.lang.reflect.Array.newInstance(type, size));
  }

  @Override
  @SuppressWarnings("unchecked")
  public E[] getNullableResult(ResultSet rs,
      int columnIndex) throws SQLException {
    Array outputArray = rs.getArray(columnIndex);
    if (outputArray == null) {
      return null;
    }
    Integer[] ints = getIntegersArray(outputArray);
    return Stream.of(ints).map(i -> E.getEnumForCode(type, i))
        .toArray(size -> (E[]) java.lang.reflect.Array.newInstance(type, size));
  }

  @Override
  @SuppressWarnings("unchecked")
  public E[] getNullableResult(CallableStatement cs,
      int columnIndex) throws SQLException {
    Array outputArray = cs.getArray(columnIndex);
    if (outputArray == null) {
      return null;
    }
    Integer[] ints = getIntegersArray(outputArray);
    return Stream.of(ints).map(i -> E.getEnumForCode(type, i))
        .toArray(size -> (E[]) java.lang.reflect.Array.newInstance(type, size));
  }

  private static Integer[] getIntegersArray(Array outputArray)
      throws SQLException {
    Class<?> arrayClass = outputArray.getArray().getClass();
    if (!arrayClass.isArray()) {
      throw new RuntimeException("expected class to be array: " + arrayClass);
    }
    Class<?> componentType = arrayClass.getComponentType();
    Integer[] ints;
    if (Short.class.isAssignableFrom(componentType)) {
      ints = Stream.of((Short[]) outputArray.getArray()).map(i -> (int) i)
          .toArray(Integer[]::new);
    } else if (Integer.class.isAssignableFrom(componentType)) {
      ints = (Integer[]) outputArray.getArray();
    } else {
      throw new RuntimeException(
          "Unknown array element type: " + componentType);
    }
    return ints;
  }
}
