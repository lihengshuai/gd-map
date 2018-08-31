package core;

import java.util.Map;

/**
 * 通用异常，指业务请求失败, 即Failure。当请求不合法，或请求合法但业务处理出现可预期失败时
 * 抛出此异常
 * <p>
 * Date: 16/9/5
 * Time: 下午5:11
 *
 * @author Loki
 */
public class FailureException extends AbstractException {

  /**
   * 构造一个请求失败Exception
   */
  public FailureException() {
    this(ErrorCode.REQUEST_FAILED);
  }

  /**
   * 使用给定的错误信息构造一个请求失败Exception
   *
   * @param message 错误信息
   */
  public FailureException(String message) {
    this(ErrorCode.REQUEST_FAILED, message);
  }

  /**
   * 使用给定的ErrorCode构造一个Exception
   *
   * @param code 错误代码
   */
  public FailureException(Code code) {
    super(code);
  }

  /**
   * 使用给定的错误信息和错误码构造一个FailureException
   *
   * @param message 错误信息
   * @param code    错误代码
   * @deprecated Use {@link FailureException#FailureException(Code, String)}
   */
  @Deprecated
  public FailureException(String message, Code code) {
    super(code, message);
  }

  /**
   * 使用给定的错误信息和错误码构造一个FailureException
   *
   * @param message 错误信息
   * @param code    错误代码
   */
  public FailureException(Code code, String message) {
    super(code, message);
  }

  /**
   * 使用给定的错误信息和错误码构造一个FailureException
   *
   * @param message 错误信息
   * @param code    错误代码
   * @deprecated Use {@link FailureException#FailureException(Code, String)}
   */
  @Deprecated
  public FailureException(String message, Throwable cause,
      Code code) {
    super(code, message, cause);
  }

  /**
   * 使用给定的错误信息和错误码构造一个FailureException
   *
   * @param code    错误代码
   * @param cause   失败原因
   * @param message 错误信息
   */
  public FailureException(Code code, String message, Throwable cause) {
    super(code, message, cause);
  }

  /**
   * 使用给定的错误码和错误信息构造一个FailureException
   *
   * @param cause 错误原因
   * @param code  错误代码
   * @deprecated Use {@link FailureException#FailureException(Code, Throwable)}
   */
  @Deprecated
  public FailureException(Throwable cause, Code code) {
    super(code, cause);
  }

  /**
   * 使用给定的错误码和错误信息构造一个FailureException
   *
   * @param cause 错误原因
   * @param code  错误代码
   */
  public FailureException(Code code, Throwable cause) {
    super(code, cause);
  }

  /**
   * 使用给定的一大堆信息构造一个FailureException
   *
   * @param message            错误信息
   * @param cause              错误原因
   * @param enableSuppression  whether or not suppression is enabled or
   *                           disabled
   * @param writableStackTrace whether or not the stack trace should be
   *                           writable
   * @param code               错误代码
   * @deprecated Use {@link FailureException#FailureException(Code, String,
   * Throwable, boolean, boolean)}
   */
  @Deprecated
  public FailureException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace,
      Code code) {
    super(code, message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * 使用给定的一大堆信息构造一个FailureException
   *
   * @param message            错误信息
   * @param cause              错误原因
   * @param enableSuppression  whether or not suppression is enabled or
   *                           disabled
   * @param writableStackTrace whether or not the stack trace should be
   *                           writable
   * @param code               错误代码
   */
  public FailureException(Code code, String message, Throwable cause,
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
  public FailureException add(String key, Object value) {
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
  public FailureException addAll(Map<String, Object> data) {
    super.addDataMap(data);
    return this;
  }
}
