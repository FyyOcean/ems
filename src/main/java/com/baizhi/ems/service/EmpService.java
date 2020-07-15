package com.baizhi.ems.service;

import com.baizhi.ems.entity.Emp;

import java.util.List;

public interface EmpService  {
    //接口中定义的查询所有的员工的方法
    List<Emp> findAll();
    //保存员工
    void save(Emp emp);

    void deleteById(String id);
    //根据id查询员工信息
    Emp findOne(String id);
    //更细员工信息
    void update(Emp emp);
}
