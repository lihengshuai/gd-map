package com.gdmap.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestUrl {

  GEOCODE_GEO("https://restapi.amap.com/v3/geocode/geo", "geo"),
  GEOCODE_REGEO("https://restapi.amap.com/v3/geocode/regeo", "regeo"),
  GEOCODE_IP("https://restapi.amap.com/v3/ip", "ip"),;

  private String code;

  private String description;
}