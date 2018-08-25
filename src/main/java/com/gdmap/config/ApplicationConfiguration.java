package com.gdmap.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApplicationConfiguration {

  @Value("${gd.map.server.key:af73da021662e0ce04829c85968a9911}")
  private String SERVER_KEY;

  @Value("${gd.map.web.key:aa0cd0e5c381de57f8d1a6cc408cfb54}")
  private String WEB_KEY;

}
