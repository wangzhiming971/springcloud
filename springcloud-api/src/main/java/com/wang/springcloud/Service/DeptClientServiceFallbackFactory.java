package com.wang.springcloud.Service;

import com.wang.springcloud.Dto.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptNo(id).
                        setDeptName("id->+"+id+"没有对应的信息，客户端提供了降级信息,这个服务已关闭").
                        setDb_source("No database!");
            }

            @Override
            public List<Dept> queryAll() {
                List<Dept> list = new ArrayList<Dept>();
                list.add(new Dept(Long.valueOf(99), "客户端提供了降级信息,这个服务已关闭", "No database"));
                return list;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
