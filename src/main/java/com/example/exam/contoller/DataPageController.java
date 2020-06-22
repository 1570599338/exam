package com.example.exam.contoller;

import com.example.exam.entity.Examround;
import com.example.exam.service.IExamroundService;
import com.example.exam.utils.Const;
import com.example.exam.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DataPageController {

    @Autowired
    private IExamroundService examroundService;

    @RequestMapping("/")
    public ModelAndView indexPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/index");
        // 用户数据
        PageUtils.bindUserData(modelAndView, request);
        try {
            Examround bean = examroundService.getSelectExam();
            modelAndView.addObject("exam",bean==null?"无":bean.getExamround());
        } catch (Exception e) {
            e.printStackTrace();
        }



        // 左侧导航栏,根据用户权限创建导航栏数组
        modelAndView.addObject("links", Const.pages);

        // 页面元素
       // PageUtils.bindPageData(modelAndView, "首页", "首页", "exam.js");
        PageUtils.bindPageData(modelAndView, "首页", "首页", "index.js");

        return modelAndView;
    }


}
