package com.gdmap.controller;

import com.gdmap.bean.RequestUrl;
import com.gdmap.bean.gene.Extensions;
import com.gdmap.bean.gene.Geo;
import com.gdmap.bean.gene.IP;
import com.gdmap.bean.gene.Regeo;
import com.gdmap.config.ApplicationConfiguration;
import com.gdmap.utils.HttpUtils;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gd")
public class MapController {

  @Autowired
  private ApplicationConfiguration acf;

  @RequestMapping("/geo")
  public Object geo(@RequestParam("address") String address) {

    HashMap<String, String> param = new HashMap<>();
    param.put("address", address);
    param.put("key", acf.getSERVER_KEY());
    return HttpUtils.doGet(RequestUrl.GEOCODE_GEO, param, Geo.class);
  }

  @GetMapping("/regeo")
  public Object regeo(@RequestParam("location") String location,
      @RequestParam("radius") int radius, @RequestParam("extensions") Extensions extensions) {
    HashMap<String, String> param = new HashMap<>();
    param.put("location", location);
    param.put("radius", String.valueOf(radius));
    param.put("extensions", extensions.getCode());
    param.put("key", acf.getSERVER_KEY());
    return HttpUtils.doGet(RequestUrl.GEOCODE_REGEO, param, Regeo.class);
  }

  @GetMapping("/ip")
  public Object ip(@RequestParam("ip") String ip) {
    HashMap<String, String> param = new HashMap<>();
    param.put("ip", ip);
    param.put("key", acf.getSERVER_KEY());
    return HttpUtils.doGet(RequestUrl.GEOCODE_IP, param, IP.class);
  }

}
