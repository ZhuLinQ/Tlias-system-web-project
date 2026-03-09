package com.zlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zlq.mapper.StudentMapper;
import com.zlq.pojo.PageResult;
import com.zlq.pojo.Student;
import com.zlq.pojo.StudentQueryParam;
import com.zlq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Student> studentList = this.studentMapper.pageList(param);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        this.studentMapper.delete(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        this.studentMapper.insert(student);
    }

    @Override
    public Student listById(Integer id) {
        return this.studentMapper.listById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        this.studentMapper.update(student);
    }

    @Override
    public void updateViolationScore(Integer id, Integer score) {
        this.studentMapper.updateViolationScore(id, score);
    }

}
