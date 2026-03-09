package com.zlq.service;

import com.zlq.pojo.ClazzOption;
import com.zlq.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    ClazzOption getStudentCountData();

    List<Map> getStudentDegreeData();
}
