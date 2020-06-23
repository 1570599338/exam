package com.example.exam.dao;/**
 * Created by 01370602 on 2020/6/23.
 */

import com.example.exam.entity.StudentBasicInfomation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName StudentBasicInfomationMapper
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Mapper
public interface StudentBasicInfomationMapper {

    @Select({"<script> " +
            "select admission_number admissionNumber,student_id studentId,exam_round examRound,identity_number identityNumber,name,birthdate," +
            "registration_date registrationDate,phone,address,postecode,city,county,registration_school  registrationSchool,employer,aid_number aidNumber," +
            "collective_number collectiveNumber,student_photo_filename studentPhotoFilename,english_name englishName,major_name majorName,major_level majorLevel," +
            "major_type majorType,major_direction  majorDirection,email, school_roll_status  schoolRollStatus,gender,ethnicity,political,job,education,health,domicile," +
            "student_type studentType,registration_type registrationType,deferment,card_status  cardStatus,id_document_type  idDocumentType from student_basic_infomation" +
            " where 1=1 <when test='admissionNumber!=null'> AND admission_number like '%${admissionNumber}%' </when>" +
            " </script>"})
    public List<StudentBasicInfomation> StudentBasicInfomationList(@Param("admissionNumber") String admissionNumber);
}



















