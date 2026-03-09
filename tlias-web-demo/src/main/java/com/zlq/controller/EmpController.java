package com.zlq.controller;

import com.zlq.pojo.Emp;
import com.zlq.pojo.EmpQueryParam;
import com.zlq.pojo.PageResult;
import com.zlq.pojo.Result;
import com.zlq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    EmpService empService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam  param){
        PageResult<Emp> pageResult = this.empService.page(param);
        return Result.success(pageResult);
    }

    @PostMapping
    //@RequestBody作用是：将请求体中json格式的数据，转为对应的对象
    public Result save(@RequestBody Emp  emp){
        this.empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("id:{}", ids);
        this.empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("get information by id:{}", id);
        Emp emp = this.empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("update emp by Id:{}", emp.getId());
        this.empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        List<Emp> list = this.empService.list();
        return Result.success(list);
    }
}
