package com.zlq.service;

import com.zlq.pojo.PageResult;
import com.zlq.pojo.Student;
import com.zlq.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam param);

    void delete(List<Integer> ids);

    void add(Student student);

    Student listById(Integer id);

    void update(Student student);

    void updateViolationScore(Integer id, Integer score);
}
