package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface TestMapper {

    @Insert({"INSERT INTO test(T1) values(#{str,jdbcType=VARCHAR})"})
    void insert(String str);

    @Insert({"INSERT INTO test2(T2) values(#{str,jdbcType=VARCHAR})"})
    void insertT2(String str);
}
