package com.example.exam.service.impl;

import com.example.exam.dao.ExamroundMapper;
import com.example.exam.entity.Examround;
import com.example.exam.service.IExamroundService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ExamroundService implements IExamroundService {
    @Resource
    private ExamroundMapper examroundMapper;

    @Transactional
    @Override
    public Map getExamround() {

        return examroundMapper.getExamround() ;
    }

    @Transactional
    @Override
    public int check(int flag) {
        return 0;
    }
    @Transactional
    @Override
    public int setflag(int flag) {
        return 0;
    }


    /**
     * 开次下拉框
     *
     * @return
     */
    @Override
    public List<Examround> getSelectExamList() {
        return examroundMapper.getSelectExamList();
    }

    /**
     * 修改考次状态
     *
     * @param examRound
     */
    @Override
    public void updateExam(String examRound) {
        examroundMapper.updateExam(examRound);
    }

    /**
     * 获取最近已经选择考次
     *
     * @return
     */
    @Override
    public Examround getSelectExam() {
        return examroundMapper.getSelectExam();
    }

}
