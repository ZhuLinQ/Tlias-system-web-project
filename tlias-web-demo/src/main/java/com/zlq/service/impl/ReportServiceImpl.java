package com.zlq.service.impl;

import com.zlq.mapper.ClazzMapper;
import com.zlq.mapper.EmpMapper;
import com.zlq.mapper.StudentMapper;
import com.zlq.pojo.ClazzOption;
import com.zlq.pojo.JobOption;
import com.zlq.pojo.Student;
import com.zlq.service.ClazzService;
import com.zlq.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    ClazzMapper clazzMapper;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String,Object>> list = clazzMapper.countClazzData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazz")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("data")).toList();
        return new ClazzOption(clazzList,dataList);
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return this.studentMapper.degreeData();
    }
}
