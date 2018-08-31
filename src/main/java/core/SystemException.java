package core;

import java.util.Map;

/**
 * 通用异常，指发生非预期错误, 即Error。当请求合法但是因为服务提供方的原因发生非预期错误时
 * 抛出此异常
 * <p>
 * Date: 16/9/5
 * Time: 下午5:11
 *
 * @author Loki
 */
public class SystemException extends AbstractException {

  /**
   * 构造一个服务异常Exception
   */
  public SystemException() {
    this(ErrorCode.SERVER_ERROR);
  }

  /**
   * 使用给定的错误信息构造一个服务异常Exception
   *
   * @param message 错误信息
   */
  public SystemException(String message) {
    this(ErrorCode.SERVER_ERROR, message);
  }

  /**
   * 使用给定的ErrorCode构造一个Exception
   *
   * @param code 错误代码
   */
  public SystemException(Code code) {
    super(code);
  }

  /**
   * 使用给定的错误信息和错误码构造一个SystemException
   * @deprecated use {@link SystemException#SystemException(Code, String)}
   *
   * @param message 错误信息
   * @param code    错误代码
   */
  @Deprecated
  public SystemException(String message, Code code) {
    super(code, message);
  }

  /**
   * 使用给定的错误信息和错误码构造一个SystemException
   *
   * @param message 错误信息
   * @param code    错误代码
   */
  public SystemException(Code code, String message) {
    super(code, message);
  }

  /**
   * Use {@link SystemException#SystemException(Code, String, Throwable)}
   */
  @Deprecated
  public SystemException(String message, Throwable cause,
                         Code code) {
    super(code, message, cause);
  }

  /**
   * 使用给定的错误代码，错误信息和错误原因构造一个SystemException
   *
   * @param message 错误信息
   * @param cause 错误原因
   * @param code 错误代码
   */
  public SystemException(Code code, String message, Throwable cause) {
    super(code, message, cause);
  }

  /**
   * @deprecated Use {@link SystemException#SystemException(Code, Throwable)}
   */
  @Deprecated
  public SystemException(Throwable cause, Code code) {
    super(code, cause);
  }

  /**
   * 使用给定的错误代码和错误原因构造一个SystemException
   * @param code 错误代码
   * @param cause 错误原因
   */
  public SystemException(Code code, Throwable cause) {
    super(code, cause);
  }

  /**
   * @deprecated Use {@link SystemException#SystemException(Code, String, Throwable, boolean, boolean)}
   */
  @Deprecated
  public SystemException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace,
                         Code code) {
    super(code, message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * 使用给定的一大堆信息构造一个FailureException
   * @param code 错误代码
   * @param message            错误信息
   * @param cause              错误原因
   * @param enableSuppression  whether or not suppression is enabled or
   *                           disabled
   * @param writableStackTrace whether or not the stack trace should be
   *                           writable
   */
  public SystemException(Code code, String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(code, message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * 给当前异常设置一对kv数据。异常处理方可以通过此机制得到异常抛出者定义的额外信息
   *
   * @param key   key, 不可为<code>null</code>
   * @param value value
   * @return 返回<code>this</code>, 调用者可以将多次{@link #add(String, Object)} 或 {@link
   * #addAll(Map)} 操作链接起来形成链式操作
   */
  public SystemException add(String key, Object value) {
    super.addDataEntry(key, value);
    return this;
  }

  /**
   * 给当前异常设置给定的Map包含的数据。异常处理方可以通过此机制得到异常抛出者定义的额外信息
   *
   * @param data 给定的异常数据。可以为<code>null</code>, 如果为<code>null</code>, 则 不做任何操作
   * @return 返回<code>this</code>, 调用者可以将多次{@link #add(String, Object)} 或 {@link
   * #addAll(Map)} 操作链接起来形成链式操作
   */
  public SystemException addAll(Map<String, Object> data) {
    super.addDataMap(data);
    return this;
  }
}
