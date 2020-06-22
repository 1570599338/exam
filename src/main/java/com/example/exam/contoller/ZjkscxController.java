package com.example.exam.contoller;


import com.example.exam.entity.JsonResult;
import com.example.exam.entity.Zjkscx;
import com.example.exam.service.IZjkscxService;
import com.example.exam.utils.Const;
import com.example.exam.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zjkscx")
public class ZjkscxController {
    @Autowired
    private IZjkscxService zjkscxService;

    @RequestMapping("")
    public ModelAndView demoPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/point");
        // 用户数据
        PageUtils.bindUserData(modelAndView, request);

        // 左侧导航栏,根据用户权限创建导航栏数组
        modelAndView.addObject("links", Const.pages);

        // 页面元素
        PageUtils.bindPageData(modelAndView, "考生考籍档案管理", "在籍考生查询", "page.js");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/showzjks")
    public JsonResult selectExam(HttpServletResponse response) {
        try {
            List<Zjkscx> list = zjkscxService.getzjks();
            return new JsonResult(Const.RESULT_SUCCESS_CODE, Const.RESULT_SUCCESS_MSG, list == null ? new ArrayList<Zjkscx>() : list);
        } catch (Exception e) {
            return new JsonResult(Const.RESULT_ERROR_CODE, Const.RESULT_ERROR_MSG);
        }
    }
}
