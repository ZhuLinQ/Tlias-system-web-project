package com.zlq.controller;


import com.zlq.anno.LogOperation;
import com.zlq.pojo.Dept;
import com.zlq.pojo.Result;
import com.zlq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @GetMapping
    //@LogOperation
    public Result list() {
        return Result.success(this.deptService.findAll());
    }

    @DeleteMapping
    @LogOperation
    public Result delet(Integer id){
        this.deptService.deletById(id);
        return Result.success();
    }

    @PostMapping
    @LogOperation
    public Result add(@RequestBody Dept dept){
        this.deptService.add(dept);
        return Result.success();
    }

//    @GetMapping("/depts/{id}")
//    public Result getInfo(@PathVariable("id") Integer deptId){
//        return Result.success();
//    }
    @GetMapping("/{id}")
    //@PathVariable注解的作用是获取路径中的参数
    public Result getInfo(@PathVariable Integer id){
        return Result.success(this.deptService.getById(id));
    }

    @PutMapping
    @LogOperation
    public Result update(@RequestBody Dept dept){
        this.deptService.update(dept);
        return Result.success();
    }
}
