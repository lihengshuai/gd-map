package core;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用异常base exception, 同时支持ErrorCode信息和抛出方自定义的data
 * <p>
 * Date: 16/9/12
 * Time: 下午6:15
 *
 * @author Loki
 */
public abstract class AbstractException extends RuntimeException {

  private Code errorCode;

  private Map<String, Object> errorData;

  protected AbstractException(Code errorCode) {
    this(errorCode, errorCode.getDescription());
  }

  @Deprecated
  protected AbstractException(String message, Code errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  protected AbstractException(Code errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  protected AbstractException(Code errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  @Deprecated
  protected AbstractException(String message, Throwable cause, Code errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  @Deprecated
  protected AbstractException(Throwable cause, Code errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  protected AbstractException(Code errorCode, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
  }

  @Deprecated
  protected AbstractException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace,
      Code errorCode) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.errorCode = errorCode;
  }

  protected AbstractException(Code errorCode, String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.errorCode = errorCode;
  }

  /**
   * 返回整数类型的错误代码
   *
   * @return 错误代码
   */
  public int getErrorCode() {
    return this.errorCode.getCode();
  }

  /**
   * 返回错误代码描述
   *
   * @return 错误代码描述
   */
  public String getDescription() {
    return this.errorCode.getDescription();
  }

  /**
   * 返回此异常包含的错误码枚举
   *
   * @return 错误码
   */
  public Code getCode() {
    return this.errorCode;
  }

  /**
   * 给当前异常设置一对kv数据。异常处理方可以通过此机制得到异常抛出者定义的额外信息
   *
   * @param key   key, 不可为<code>null</code>
   * @param value value
   */
  protected final void addDataEntry(String key, Object value) {
    if (key == null) {
      throw new IllegalArgumentException("key cannot be null");
    }
    if (errorData == null) {
      errorData = new HashMap<>();
    }
    errorData.put(key, value);
  }

  /**
   * 给当前异常设置给定的Map包含的数据。异常处理方可以通过此机制得到异常抛出者定义的额外信息
   *
   * @param data 给定的异常数据。可以为<code>null</code>, 如果为<code>null</code>, 则 不做任何操作
   */
  protected final void addDataMap(Map<String, Object> data) {
    if (data == null) {
      return;
    }
    if (errorData == null) {
      errorData = new HashMap<>();
    }
    errorData.putAll(data);
  }

  /**
   * 取出当前异常中的data。此调用会返回异常中数据的一份拷贝。
   *
   * @return error data 的一份拷贝
   */
  public Map<String, Object> getErrorData() {
    Map<String, Object> copy = new HashMap<>();
    if (this.errorData != null) {
      copy.putAll(this.errorData);
    }
    return copy;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[')
        .append(getErrorCode())
        .append(": ")
        .append(getDescription())
        .append("] ")
        .append(getClass().getName());

    String message = getLocalizedMessage();
    if (message != null) {
      sb.append(": ").append(message);
    }
    if (errorData != null) {
      sb.append(", error data: ")
          .append(errorData.toString());
    }
    return sb.toString();
  }
}
