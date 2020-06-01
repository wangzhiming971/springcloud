package com.wang.springcloud.controller;

import com.wang.springcloud.Dto.Dept;
import com.wang.springcloud.Service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2020/5/23 17:11
 */
@RestController
public class DeptConsumerController {
    @Autowired
    DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add( Dept dept) {
        return deptClientService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }
}
