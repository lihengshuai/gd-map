package core.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import core.Code;
import core.ErrorCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Date: 16/6/30 Time: AM12:32
 *
 * @author Loki
 */
@JsonSerialize(using = ResponseSerializer.class)
@JsonDeserialize(using = ResponseDeserializer.class)
public class Response<T> {

  private Response(ResponseStatus status) {
    this.status = status;
  }

  @SuppressWarnings("unchecked")
  private Response(ResponseStatus status, T data) {
    if (data instanceof List) {
      throw new IllegalArgumentException("Unsupported Data type: List");
    }
    this.status = status;
    ObjectMapper m = new ObjectMapper();

    this.data = m.convertValue(data, Map.class);
  }

  /**
   * 快捷方式，创建一个成功的Response
   *
   * @return 构造好的Response
   */
  public static Response instanceSuccess() {
    return new Response(ResponseStatus.SUCCESS);
  }

  /**
   * 快捷方式，使用给定的data创建一个成功的Response
   *
   * @param <T> 此Response instance 代表的bean
   * @return 构造好的Response
   */
  public static <T> Response<T> instanceSuccess(T data) {
    return new Response<T>(ResponseStatus.SUCCESS, data);
  }

  /**
   * 快捷方式，创建一个失败的Response
   *
   * @return 构造好的Response
   */
  public static Response instanceFail() {
    return new Response(ResponseStatus.FAIL);
  }

  /**
   * 用给定的错误码实例化一个状态为fail的Response
   *
   * @param code 失败的错误状态码
   * @return 一个新的失败response
   */
  public static Response instanceFail(Code code) {
    return new Response(ResponseStatus.FAIL)
        .withDataEntry(FAILURE_DATA_CODE, code.getCode())
        .withDataEntry(FAILURE_DATA_RESULT, code.getDescription());
  }

  /**
   * 用给定的错误码实例化一个状态为fail的Response
   *
   * @param code 失败的错误状态码
   * @param overrideDescription 重行覆盖{@link Code} 中description内容
   * @return 一个新的失败response
   */
  public static Response instanceFail(Code code, String overrideDescription) {
    return new Response(ResponseStatus.FAIL)
        .withDataEntry(FAILURE_DATA_CODE, code.getCode())
        .withDataEntry(FAILURE_DATA_RESULT, overrideDescription);
  }

  /**
   * 快捷方式，使用给定的data创建一个失败的Response
   *
   * @param data 此Response instance 包含的data bean
   * @param <T> 此Response instance 包含的data bean的类型
   * @return 构造好的Response
   */
  public static <T> Response<T> instanceFail(T data) {
    return new Response<T>(ResponseStatus.FAIL, data);
  }

  /**
   * 快捷方式，使用给定的data创建一个失败的Response
   *
   * @param code 错误码
   * @param data 此Response instance 包含的data bean
   * @param <T> 此Response instance 包含的data bean的类型
   * @return 构造好的Response
   */
  @SuppressWarnings("unchecked")
  public static <T> Response<T> instanceFail(Code code, T data) {
    return new Response<T>(ResponseStatus.FAIL, data)
        .withDataEntry(FAILURE_DATA_CODE, code.getCode())
        .withDataEntry(FAILURE_DATA_RESULT, code.getDescription());
  }

  /**
   * 快捷方式，使用默认的错误码构造一个错误Response
   *
   * @return 构造好的Response
   */
  public static Response instanceError() {
    return instanceError(ErrorCode.SERVER_ERROR);
  }

  /**
   * 用给定的错误码实例化一个状态为error的Response
   *
   * @param code 错误状态码
   * @return 一个新的错误response
   */
  public static Response instanceError(Code code) {
    return new Response(ResponseStatus.ERROR)
        .withCode(code.getCode() + "")
        .withMessage(code.getDescription());
  }

  /**
   * 快捷方式，使用给定的data创建一个错误的Response
   *
   * @param data 此Response instance 包含的data bean
   * @param <T> 此Response instance 包含的data bean的类型
   * @return 构造好的Response
   */
  public static <T> Response<T> instanceError(T data) {
    return instanceError(ErrorCode.SERVER_ERROR, data);
  }

  /**
   * 快捷方式，使用给定的data创建一个错误的Response
   *
   * @param code 错误码
   * @param data 此Response instance 包含的data bean
   * @param <T> 此Response instance 包含的data bean的类型
   * @return 构造好的Response
   */
  @SuppressWarnings("unchecked")
  public static <T> Response<T> instanceError(Code code, T data) {
    return new Response<T>(ResponseStatus.ERROR, data)
        .withCode(code.getCode() + "")
        .withMessage(code.getDescription());
  }

  public static final String STATUS = "status";

  public static final String MESSAGE = "message";

  public static final String DATA = "data";

  public static final String CODE = "code";

  private static final String FAILURE_DATA_CODE = "code";

  private static final String FAILURE_DATA_RESULT = "result";

  private ResponseStatus status = null;

  private String message = null;

  private Map<String, Object> data = new HashMap<>();

  private String code = null;

  public ResponseStatus getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public Map<String, Object> getData() {
    return data;
  }

  /**
   * 将此response中data部分转换成为给定type的Bean
   *
   * @param type response 中data所对应的bean type
   * @return data as a bean of the given type
   */
  public T getDataAs(Class<T> type) {
    ObjectMapper m = new ObjectMapper();
    return m.convertValue(data, type);
  }

  /**
   * 将此response中data map 的给定key转换成为给定type的Bean
   *
   * @param type response 中data所对应的bean type
   * @param key 想要得到的key
   * @return data entry as a bean of the given type, 如果结果中不包含这个key，则 返回<code>null</code> //   *
   * @deprecated use more convenience static helper: {com.gdmap.core.util.ResponseUtils#getDataEntryAs(Class,
   * Response, String)}
   */
  @Deprecated
  public T getDataEntryAs(Class<T> type, String key) {
    Object o = data.get(key);
    if (o == null) {
      return null;
    }
    ObjectMapper m = new ObjectMapper();
    return m.convertValue(o, type);
  }

  /**
   * 返回此Failure Response中的错误代码，a.k.a. 'code' field in data. 该响应状态必须为fail，否则会抛{@link
   * IllegalStateException}
   *
   * @return 错误代码，如果data中不包含code字段，则返回<code>null</code>
   * @throws IllegalStateException 此响应不是fail
   */
  public Integer getFailureCode() {
    if (this.status != ResponseStatus.FAIL) {
      throw new IllegalStateException(
          "Get failure code is only available when this response is a Failure response, but got " +
              status);
    }
    Object o = data.get(FAILURE_DATA_CODE);
    if (o == null) {
      return null;
    }
    return Integer.valueOf(o.toString());
  }

  /**
   * 返回此Failure Response中的错误信息，a.k.a. 'result' field in data。该响应状态 必须为fail，否则会抛{@link
   * IllegalStateException}
   *
   * @return failure 信息，如果data中不包含result字段，则返回<Code>null</Code>
   * @throws IllegalStateException 此响应不是fail
   */
  public String getFailureMessage() {
    if (this.status != ResponseStatus.FAIL) {
      throw new IllegalStateException(
          "Get failure code is only available when this response is a Failure response, but got " +
              status);
    }
    Object o = data.get(FAILURE_DATA_RESULT);
    if (o == null) {
      return null;
    }
    return String.valueOf(o);
  }

  public String getCode() {
    return code;
  }

  public Response withMessage(String message) {
    this.message = message;
    return this;
  }

  public Response withDataEntry(String key, Object value) {
    this.data.put(key, value);
    return this;
  }

  public Response withData(Map<String, Object> map) {
    if (map != null) {
      this.data.putAll(map);
    }
    return this;
  }

  public Response withCode(String code) {
    this.code = code;
    return this;
  }

  public boolean isSuccessful() {
    return this.status == ResponseStatus.SUCCESS;
  }

  public boolean isFailed() {
    return this.status == ResponseStatus.FAIL;
  }

  public boolean isError() {
    return this.status == ResponseStatus.ERROR;
  }

  @Override
  public boolean equals(Object response) {
    if (!(response instanceof Response)) {
      return false;
    }
    Response in = (Response) response;

    return Objects.equals(this.status, in.status) &&
        Objects.equals(this.message, in.message) &&
        Objects.equals(this.code, in.code) &&
        Objects.equals(this.data, in.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, code, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", status=").append(status);
    sb.append(", code=").append(code);
    sb.append(", message=").append(message);
    sb.append(", data=").append(data);
    sb.append("]");
    return sb.toString();
  }
}
