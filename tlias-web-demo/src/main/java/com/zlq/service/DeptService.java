package com.zlq.service;

import com.zlq.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    void deletById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
