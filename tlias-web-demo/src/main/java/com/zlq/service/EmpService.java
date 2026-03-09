package com.zlq.service;

import com.zlq.pojo.Emp;
import com.zlq.pojo.EmpQueryParam;
import com.zlq.pojo.LoginInfo;
import com.zlq.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam  param);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    List<Emp> list();


}
