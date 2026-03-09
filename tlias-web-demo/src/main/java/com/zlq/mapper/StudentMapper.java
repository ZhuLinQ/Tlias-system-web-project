package com.zlq.mapper;


import com.zlq.pojo.Student;
import com.zlq.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> pageList(StudentQueryParam param);


    void delete(List<Integer> ids);

    void insert(Student student);

    Student listById(Integer id);

    void update(Student student);

    void updateViolationScore(Integer id, Integer score);

    @MapKey("name")
    List<Map> degreeData();
}
