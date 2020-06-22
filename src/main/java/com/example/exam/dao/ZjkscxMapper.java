package com.example.exam.dao;

import com.example.exam.entity.Examround;
import com.example.exam.entity.Zjkscx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZjkscxMapper {

    @Select({"select getAdmission_number from student_basic_infomation where student_id=#{student_id}"})
    public List<Zjkscx> getzjks();
}
