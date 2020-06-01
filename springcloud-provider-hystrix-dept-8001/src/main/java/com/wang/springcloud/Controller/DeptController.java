package com.wang.springcloud.Controller;
import com.mysql.jdbc.StringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.springcloud.Dto.Dept;
import com.wang.springcloud.Service.DeptClientService;
import com.wang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

   @GetMapping("dept/get/{id}")
   @HystrixCommand(fallbackMethod = "queryHystrixById")
   public Dept queryById(@PathVariable("id") Long id)  {
       Dept dept= deptService.queryById(id);
       if(dept==null){
           throw new RuntimeException("Id=>"+id+"，为空，请检查");
       }
       return  dept;
   }

    public Dept queryHystrixById(@PathVariable("id") Long id)  {
        return new Dept().setDeptNo(id).
                setDeptName("Id为空=>导致数据查询不到!").
                setDb_source("this mysql no database");
    }
}
