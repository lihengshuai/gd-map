package com.gdmap.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author Loki on 17/9/18.
 */
public class JsonUtils {

  private static final ObjectMapper mapper = new ObjectMapper();

  private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

  /**
   * @param object obj to be json string.
   * @return json str
   */
  public static String toJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (IOException e) {
      logger.warn("write to json string error:" + object, e);
      return null;
    }
  }

  /**
   * @param jsonString string to be T list.
   * @param clazz class
   * @param <T> class type
   * @return the list json string format
   */
  public static <T> List<T> fromJsonToList(String jsonString, Class<T> clazz) {
    if (StringUtils.isEmpty(jsonString)) {
      return null;
    }

    try {
      return mapper.readValue(jsonString, new TypeReference<List<T>>() {
      });
    } catch (Exception e) {
      logger.warn("parse json string error:" + jsonString, e);
      return null;
    }
  }

  /**
   * @param jsonString string to be T.
   * @param clazz class
   * @param <T> class type
   * @return the class json string format
   */
  public static <T> T fromJson(String jsonString, Class<T> clazz) {
    if (StringUtils.isEmpty(jsonString)) {
      return null;
    }

    try {
      return mapper.readValue(jsonString, clazz);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
      return null;
    }
  }

}
