package core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.http.Response;
import java.util.Objects;

/**
 * Utilities for Response parsing.
 *
 * @author Loki
 */
public class ResponseUtils {

  /**
   * 对于给定的Response实例，返回一个response data中给定key所对应的值，并转化为给定类型
   *
   * @param type 该key所对应的数据类型
   * @param response response 实例
   * @param key 所要查询的data中的字段名称
   * @param <E> 所要查询的data中的字段类型
   * @return 返回该key字段所对应的数据。如果返回结果data中不包含该字段，则返回<code>null</code>
   */
  public static <E> E getDataEntryAs(Class<E> type, Response response,
      String key) {
    Objects.requireNonNull(type, "type cannot be null");
    Objects.requireNonNull(response, "message cannot be null");
    Objects.requireNonNull(key, "key cannot be null");
    Object o = response.getData().get(key);
    if (o == null) {
      return null;
    }
    ObjectMapper m = new ObjectMapper();
    return m.convertValue(o, type);
  }
}
