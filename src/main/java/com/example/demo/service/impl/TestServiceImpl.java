package com.example.demo.service.impl;

import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    @Transactional
    public void test() {
        testMapper.insert("Rick");
        int i =1/0;
        testMapper.insertT2("successfully");
    }
}
