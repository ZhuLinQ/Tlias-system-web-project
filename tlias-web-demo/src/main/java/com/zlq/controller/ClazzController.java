package com.zlq.controller;


import com.zlq.pojo.Clazz;
import com.zlq.pojo.ClazzQueryParam;
import com.zlq.pojo.PageResult;
import com.zlq.pojo.Result;
import com.zlq.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;


    /**
     * 分页查询
     * @param param
     * @return
     */
    @GetMapping
    public Result page(ClazzQueryParam  param){
        PageResult<Clazz> pageResult =  this.clazzService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 删除班级
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("delete class by id:{}", id);
        this.clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("add class:{}", clazz.toString());
        this.clazzService.add(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("get class by id:{}", id);
        Clazz clazz = this.clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("update class:{}", clazz.toString());
        this.clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        List<Clazz> list = this.clazzService.listAll();
        return Result.success(list);
    }
}
