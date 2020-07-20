package com.course.system.mapper;

import com.course.system.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface TestMapper {
    List<Test> list();
}
