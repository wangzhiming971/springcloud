package com.wang.springcloud.service;



import com.wang.springcloud.Dto.Dept;

import java.util.List;

/**
 * Created by Administrator on 2020/5/23 14:14
 */
public interface DeptService {
    public  boolean addDept(Dept dept);
    public Dept queryById(long id);
    public List<Dept> queryAll();
}
