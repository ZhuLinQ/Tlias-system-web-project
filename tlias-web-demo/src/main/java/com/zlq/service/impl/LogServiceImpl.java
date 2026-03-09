package com.zlq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zlq.mapper.LogMapper;
import com.zlq.pojo.LogInfo;
import com.zlq.pojo.PageResult;
import com.zlq.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<LogInfo> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogInfo> logList = logMapper.list(pageNum,pageSize);
        Page<LogInfo> p = (Page<LogInfo>) logList;
        return new PageResult<LogInfo>(p.getTotal(), p.getResult());
        /*
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> empList = this.empMapper.list(param);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
         */
    }
}
