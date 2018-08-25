package com.gdmap.utils;

import com.gdmap.bean.RequestUrl;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class HttpUtils {

  private static final RestTemplate restTemplate = new RestTemplate();

  /**
   * do wecaht get request method.
   *
   * @param url request url
   * @param parameterMap request parameter
   * @param response response class
   * @param <T> response
   */
  @SuppressWarnings("unchecked")
  public static <T> T doGet(RequestUrl url, HashMap<String, String> parameterMap,
      Class<T> response) {

    if (url == null || parameterMap == null || response == null) {
      log.error("url : {}, parameterMap : {}, response : {}");
      throw new IllegalArgumentException();
    }

    try {

      ResponseEntity<Map> forEntity = restTemplate
          .getForEntity(toGetRequestUrl(url, parameterMap), Map.class);
      Map<String, Object> body = forEntity.getBody();

      if (forEntity.getStatusCode() == HttpStatus.OK) {
        return JsonUtils.fromJson(JsonUtils.toJson(forEntity.getBody()), response);
      }

      log.error("do wechat get request error ! {}", body);
      throw new IllegalArgumentException();

    } catch (Exception e) {
      log.error("do wechat get request error ! {}", e);
      throw new RuntimeException(e);
    }
  }

  private static URI toGetRequestUrl(RequestUrl url, HashMap<String, String> parameterMap) {

    try {
      URIBuilder uriBuilder = new URIBuilder(url.getCode());
      uriBuilder.setCharset(Charset.forName("UTF-8"));
      for (String key : parameterMap.keySet()) {
        uriBuilder.setParameter(key, parameterMap.get(key));
      }
      log.info("URI ==={}", uriBuilder.toString());
      return uriBuilder.build();
    } catch (URISyntaxException e) {
      log.error("get url error : {}", e);
      throw new RuntimeException(e);
    }
  }

  public static String doPost(URI uri, String xmlString) {

    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

      ResponseEntity<String> forEntity = restTemplate.postForEntity(uri,
          new HttpEntity<>(new String(xmlString.getBytes(), StandardCharsets.ISO_8859_1), headers),
          String.class);
      return new String(forEntity.getBody().getBytes(StandardCharsets.ISO_8859_1),
          StandardCharsets.UTF_8);

    } catch (Exception e) {
      log.error("do wx pay post  error ! {}", e);
      throw new IllegalArgumentException();
    }
  }

}
