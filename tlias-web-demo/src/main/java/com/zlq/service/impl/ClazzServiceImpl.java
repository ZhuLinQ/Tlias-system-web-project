package com.zlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zlq.mapper.ClazzMapper;
import com.zlq.pojo.Clazz;
import com.zlq.pojo.ClazzQueryParam;
import com.zlq.pojo.PageResult;
import com.zlq.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> clazzList = this.clazzMapper.list(param);
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        this.clazzMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        this.clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return this.clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        this.clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> listAll() {
        return this.clazzMapper.listAll();
    }
}
