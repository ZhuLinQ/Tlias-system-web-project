package com.zlq.controller;


import com.zlq.pojo.PageResult;
import com.zlq.pojo.Result;
import com.zlq.pojo.Student;
import com.zlq.pojo.StudentQueryParam;
import com.zlq.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam  param){
        PageResult<Student> pageResult =  this.studentService.page(param);
        return Result.success(pageResult);
    }


    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("delete student by id:{}", ids);
        this.studentService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("add student:{}", student);
        this.studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result listById(@PathVariable Integer id){
        Student student = this.studentService.listById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("update student:{}", student);
        this.studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolationScore(@PathVariable("id") Integer id, @PathVariable("score") Integer score){
        log.info("update student violation:{}", id);
        this.studentService.updateViolationScore(id, score);
        return Result.success();
    }
}
