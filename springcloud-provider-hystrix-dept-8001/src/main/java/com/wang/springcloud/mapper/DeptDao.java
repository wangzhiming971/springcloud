package com.wang.springcloud.mapper;

import com.wang.springcloud.Dto.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/5/23 14:14
 */
@Mapper
@Repository
public interface DeptDao {
    public  Boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
