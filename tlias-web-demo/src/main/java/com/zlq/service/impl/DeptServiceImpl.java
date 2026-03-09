package com.zlq.service.impl;

import com.zlq.anno.LogOperation;
import com.zlq.mapper.DeptMapper;
import com.zlq.pojo.Dept;
import com.zlq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return this.deptMapper.findAll();
    }

    @Override
    //@LogOperation
    public void deletById(Integer id) {
        this.deptMapper.deletById(id);
    }

    @Override
    //@LogOperation
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        this.deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return this.deptMapper.getById(id);
    }

    @Override
    //@LogOperation
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        this.deptMapper.update(dept);
    }


}
