package com.zlq.service;

import com.zlq.pojo.LogInfo;
import com.zlq.pojo.PageResult;

import java.util.List;

public interface LogService {
    PageResult<LogInfo> page(Integer pageNum, Integer pageSize);
}
