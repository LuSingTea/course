package com.course.server.service;

import com.course.server.domain.Test;
import com.course.server.domain.TestExample;
import com.course.server.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName : TestService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-20 20:45
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> list() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo(1);
        testExample.setOrderByClause("id desc");

        return testMapper.selectByExample(testExample);
    }

}
