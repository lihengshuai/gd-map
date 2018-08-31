package core;

/**
 * 所有错误码的enum定义都应该实现此接口, e.g. {@link ErrorCode}。此接口与{@link SystemException}
 * 搭配使用
 *
 * @author Loki
 * @see SystemException
 */
public interface Code {

  /**
   * return the code number of this error code
   *
   * @return the code as an int
   */
  int getCode();

  /**
   * return the error code description
   *
   * @return the code description
   */
  String getDescription();
}
