package com.example.exam.dao;

import com.example.exam.entity.Examround;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamroundMapper {
    @Select({"SELECT exam_round ,flag FROM exam_round"})
    public Map getExamround( );

    @Insert({"insert exam_round into(flag,exam_round) value(#{flag},#{examround})"})
    public int add(int flag,String examround );

    @Select({"select flag,exam_round examRound from exam_round where flag=0 order by createAt desc"})
    public List<Examround> getSelectExamList();

    /**
     * 修改考次状态
     * @param examRound
     */
    @Update({"update exam_round set flag=1,updateAt=now() where exam_round=#{examRound}"})
    public void updateExam(String examRound);


    /**
     * 获取最近已经选择考次
     * @return
     */
    @Select({"select flag,exam_round examRound from exam_round where flag=1 order by updateAt desc limit 1"})
    public Examround getSelectExam();







}
