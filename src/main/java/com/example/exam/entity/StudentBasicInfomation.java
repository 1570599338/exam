package com.example.exam.entity;/**
 * Created by 01370602 on 2020/6/23.
 */

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName StudentBasicInfomation
 *
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Data
public class StudentBasicInfomation {

    private String admissionNumber;
    private String studentId;
    private String examRound;
    private String proposedMajor;
    private String identityNumber;

    private String birthdate;
    private String  registrationDate;
    private String  phone;
    private String  address;
    private String postecode;
    private String city;
    private String county;
    private String registrationSchool;
    private String  employer;
    private String  aidNumber;
    private String  collectiveNumber;
    private String studentPhotoFilename;
    private String englishName;
    private String  majorName;
    private String majorLevel;
    private String majorType;
    private String  majorDirection;
    private String email;
    private Integer schoolRollStatus;
    private Integer gender;
    private Integer ethnicity;
    private Integer political;
    private Integer job;
    private Integer education;
    private Integer health;
    private Integer domicile;
    private Integer studentType;
    private Integer registrationType;
    private Integer deferment;
    private Integer cardStatus;
    private Integer idDocumentType;




}
