package com.zlq.mapper;


import com.zlq.pojo.LogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select * from tlias.operate_log")
    public List<LogInfo> list(Integer pageNum, Integer pageSize);
}
