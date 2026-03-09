package com.zlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zlq.mapper.EmpExprMapper;
import com.zlq.mapper.EmpMapper;
import com.zlq.pojo.*;
import com.zlq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
PageHelper分页插件注意事项：
    1.PageHelper的底层是通过拦截实现的，所以对应的sql语句不要加分号
    2.PageHelper仅能对紧随其后的查询语句进行分页操作
 */
@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam param) {
        //原始方式分页查询
//        return new PageResult<Emp>(this.empMapper.count(), this.empMapper.list((page-1)*pageSize, pageSize));


        //pagehelper方式分页查询
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> empList = this.empMapper.list(param);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    //开启事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        this.empMapper.insert(emp);
        List<EmpExpr> exprList = emp.getExprList();
        //log.info("after insert");
//        if(CollectionUtils.isEmpty(empExprList)){
//            log.info("empExprList is empty");
//        }
        if (!CollectionUtils.isEmpty(exprList)) {
            //log.info("may i log out?");
            exprList.forEach(empExpr -> {
                log.info("id:{}", emp.getId());
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        //删除员工
        this.empMapper.deleteByIds(ids);
        //删除员工对应的工作经历
        this.empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        return this.empMapper.getById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        //1. 更新员工信息
        emp.setUpdateTime(LocalDateTime.now());
        this.empMapper.updateById(emp);
        //2. 删除员工对应的工作经历
        this.empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        //3. 插入新的员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            this.empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> list() {
        return this.empMapper.listAll();
    }

}
