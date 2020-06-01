package com.wang.springcloud.Controller;
import com.wang.springcloud.Dto.Dept;
import com.wang.springcloud.service.DeptService;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2020/5/23 14:33
 */
//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    //获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/dept/add")
    @ResponseBody
    public boolean add(@RequestBody(required = false)Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}")
    @ResponseBody
    public Dept get(@PathVariable("id") Long Id) {
        return deptService.queryById(Id);
    }

    @RequestMapping(value = "/dept/list")
    @ResponseBody
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //  注册进来的微服务~,获取一些信息
    @RequestMapping("/dept/discovery")
    @ResponseBody
    public  Object discovery(){
        //获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>services:"+services);

        //得到一个具体的微服务信息,通过具体的微服务id,applicationNmae
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId());
        }
        return this.discoveryClient;
    }
}
