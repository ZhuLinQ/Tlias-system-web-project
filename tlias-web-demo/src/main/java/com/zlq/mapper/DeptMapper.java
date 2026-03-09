package com.zlq.mapper;


import com.zlq.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface DeptMapper {

    //利用@Results以及@Result注解映射字段
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })

    //也可以在sql语句中起别名，如：select id, name, create_time as createTime, update_time as updateTime from dept order by update_time desc
    @Select("select id, name, create_time, update_time from dept order by update_time desc ")
    public List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deletById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    //在项目当中启动驼峰命名，可以自动映射
}
