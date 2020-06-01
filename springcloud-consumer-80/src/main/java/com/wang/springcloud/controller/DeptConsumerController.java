package com.wang.springcloud.controller;

import com.wang.springcloud.Dto.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2020/5/23 17:11
 */
@RestController
public class DeptConsumerController {
    // 理解消费者，不应该有service层
    //RestFul风格 RestTemplate ...供我们直接调用就可以了！注册到spring中
    //(url 实体:map, Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务方法，简单的restful服务模板
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/";

    //http://localhost:8001/dept/list

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add( Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }
}
