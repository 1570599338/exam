package com.example.exam.service.impl;/**
 * Created by 01370602 on 2020/6/23.
 */

import com.example.exam.dao.StudentBasicInfomationMapper;
import com.example.exam.entity.StudentBasicInfomation;
import com.example.exam.service.IStudentBasicInfomationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName StudentBasicInfomationServiceImpl
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Service
public class StudentBasicInfomationServiceImpl implements IStudentBasicInfomationService {
//    public PageInfo<StudentBasicInfomation> queryTextConfigList(StudentBasicInfomation reqTextDTO) {
//        PageHelper.startPage(Integer.parseInt(reqTextDTO.getPageNum()),Integer.parseInt(reqTextDTO.getPageSize()));
//        List<StudentBasicInfomation> list = rAuditTextConfigMapper.queryTextConfigList(reqTextDTO);
//        return new PageInfo<>(list);
//    }

    @Autowired
   private StudentBasicInfomationMapper studentBasicInfomationMapper;


    @Override
    public List<StudentBasicInfomation> StudentBasicInfomationList(String admissionNumber) {
        return studentBasicInfomationMapper.StudentBasicInfomationList(admissionNumber);
    }


}
