package com.example.exam.service;

import com.example.exam.entity.Examround;

import java.util.List;
import java.util.Map;

public interface IExamroundService {
    public int check(int flag);
    public int setflag(int flag);
    public Map  getExamround();

    /**
     * 开次下拉框
     * @return
     */
    public List<Examround> getSelectExamList();


    /**
     * 修改考次状态
     * @param examRound
     */
    public void updateExam(String examRound);

    /**
     * 获取最近已经选择考次
     * @return
     */
    public Examround getSelectExam();

}
