package com.baizhi.ems.dao;

import com.baizhi.ems.entity.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDAO {
    //查询所有
    List<Emp> findALL();
    //保存员工的方法
    void save(Emp emp);
    //删除员工
    void deleteById(String id);
    //根据id查询员工信息
    Emp findOne(String id);

    void update(Emp emp);
}
