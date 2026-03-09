package com.zlq.service;

import com.zlq.pojo.Clazz;
import com.zlq.pojo.ClazzQueryParam;
import com.zlq.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam param);

    void deleteById(Integer id);

    void add(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> listAll();
}
