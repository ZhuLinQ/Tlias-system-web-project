package com.zlq.mapper;


import com.zlq.pojo.Clazz;
import com.zlq.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
     public List<Clazz> list(ClazzQueryParam param);

     void deleteById(Integer id);

     void insert(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> listAll();

    @MapKey("clazz")
    List<Map<String, Object>> countClazzData();
}
