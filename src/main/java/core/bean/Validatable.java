package core.bean;

import core.FailureException;

/**
 * 表明实现此接口的类是一个可验证合法性的bean
 * <p>
 * Created by Loki on 03/01/2018.
 */
public interface Validatable {


  /**
   * 验证http请求bean的合法性，若非法则抛出对应的FailureException
   *
   * @throws FailureException 验证失败的原因。实现的class应该抛出由能代表非法原因的错误码和描述构造的FailureException
   */
  void validate() throws FailureException;
}
