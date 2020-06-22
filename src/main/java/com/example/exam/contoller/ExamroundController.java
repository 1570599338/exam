package com.example.exam.contoller;

import com.example.exam.entity.Examround;
import com.example.exam.entity.JsonResult;
import com.example.exam.service.IExamroundService;
import com.example.exam.utils.Const;
import com.example.exam.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/examround")
public class ExamroundController {
    @Autowired
    private IExamroundService examroundService;

    @RequestMapping("/getexamround")
    public ModelAndView demoPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("examround");
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
        PageUtils.bindPageData(modelAndView, "考生考籍档案管理", "设置当前考次", "exam.js");

        return modelAndView;
    }


    /**
     * 选择考次
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectExam")
    public JsonResult selectExam(HttpServletResponse response){
        try {
            List<Examround> list = examroundService.getSelectExamList();
            return new JsonResult(Const.RESULT_SUCCESS_CODE, Const.RESULT_SUCCESS_MSG,list==null? new ArrayList<Examround>():list);
        } catch (Exception e) {
            return new JsonResult(Const.RESULT_ERROR_CODE, Const.RESULT_ERROR_MSG);
        }
    }


    /**
     * 选择考次
     * @param response
     * @param value
     * @param text
     * @return
     */
    @ResponseBody
    @PostMapping("/addExam")
    // 可以设置默认值情况
    public JsonResult addExam(HttpServletResponse response,@RequestParam(name = "value") String value,@RequestParam(name = "text")String text){
        System.out.printf("value"+value+"text"+text);
        try {
            examroundService.updateExam(value);
            return new JsonResult(Const.RESULT_SUCCESS_CODE, Const.RESULT_SUCCESS_MSG);
        } catch (Exception e) {
            return new JsonResult(Const.RESULT_ERROR_CODE, Const.RESULT_ERROR_MSG);
        }
    }


}
