package core.util;

import core.ErrorCode;
import core.FailureException;
import org.hashids.Hashids;

/**
 * Date: 16/8/19 Time: AM12:48
 *
 * @author Loki
 */
public class HashUtils {

  private static Hashids hashids = new Hashids("xzl salt", 6);

  /**
   * Encodes a given id, returns a encoded string
   *
   * @param id the id to encode
   * @return encoded string
   */
  public static String encode(long id) {
    return hashids.encode(id);
  }

  /**
   * Decodes a encoded String to its underlying id. If anything goes wrong, a {@link
   * FailureException} will be thrown
   *
   * @param str the encoded String to decode, cannot be <code>null</code> or empty
   * @return decoded string
   */
  public static long decode(String str) {
    if (str == null || str.isEmpty()) {
      throw new FailureException(ErrorCode.INVALID_PARAMS, "cannot decode empty string");
    }
    try {
      return hashids.decode(str)[0];
    } catch (Exception e) {
      throw new FailureException(ErrorCode.INVALID_PARAMS,
          "input string " + str + " cannot be decoded");
    }
  }
}
