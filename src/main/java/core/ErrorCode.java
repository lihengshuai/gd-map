package core;

/**
 * 通用错误代码
 * <p>
 * Date: 16/9/10 Time: 下午5:17
 *
 * @author Loki
 */
public enum ErrorCode implements Code {

  /**
   * 请求参数错误。通常指请求发起方没有按照约定传递错误的参数
   */
  INVALID_PARAMS(400, "请求参数错误"),

  /**
   * 业务处理失败，通常不是由代码异常引起的，通常是业务原因，如规则不允许等
   */
  REQUEST_FAILED(450, "业务处理失败"),

  /**
   * 服务器异常，通常是由于代码逻辑错误导或外部服务不可用造成的致的非预期错误
   */
  SERVER_ERROR(500, "服务异常"),

  /**
   * 服务暂不可用
   */
  SERVICE_UNAVAILABLE(550, "服务暂不可用");

  private final int code;
  private final String description;

  private ErrorCode(int code, String description) {
    this.code = code;
    this.description = description;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String toString() {
    return code + ": " + description;
  }
}
