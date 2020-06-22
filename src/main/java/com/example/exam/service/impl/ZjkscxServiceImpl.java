package com.example.exam.service.impl;

import com.example.exam.dao.ExamroundMapper;
import com.example.exam.dao.ZjkscxMapper;
import com.example.exam.entity.Examround;
import com.example.exam.entity.Zjkscx;
import com.example.exam.service.IExamroundService;
import com.example.exam.service.IZjkscxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZjkscxServiceImpl implements IZjkscxService {
    @Resource
    private ZjkscxMapper zjkscxMapper;
    @Transactional
    @Override
    public List<Zjkscx> getzjks() {
        return zjkscxMapper.getzjks();
    }
}
