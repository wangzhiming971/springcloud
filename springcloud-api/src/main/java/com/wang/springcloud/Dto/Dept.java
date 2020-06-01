package com.wang.springcloud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/5/23 13:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)//链式写法
//Dept 实体类
public class Dept  {
    private Long deptNo;
    private String deptName;
    private String db_source;
    /*
    * 链式写法
    * Dept dept = new Dept();
    * dept.setDeptNo().setDeptName().setDb_source()
    *
    * */
}
