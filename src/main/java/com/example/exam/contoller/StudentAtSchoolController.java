package com.example.exam.contoller;/**
 * Created by 01370602 on 2020/6/23.
 */

import com.example.exam.entity.JsonResult;
import com.example.exam.entity.StudentBasicInfomation;
import com.example.exam.entity.Zjkscx;
import com.example.exam.service.IStudentBasicInfomationService;
import com.example.exam.service.IZjkscxService;
import com.example.exam.utils.Const;
import com.example.exam.utils.PageUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName StudentAtSchoolController
 *
 * @Author
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@RestController
@RequestMapping("/student")
public class StudentAtSchoolController {

    @Autowired
    private IStudentBasicInfomationService service;

    @RequestMapping("/studenPage")
    public ModelAndView demoPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("student");
        // 用户数据
        PageUtils.bindUserData(modelAndView, request);

        // 左侧导航栏,根据用户权限创建导航栏数组
        modelAndView.addObject("links", Const.pages);

        // 页面元素
        PageUtils.bindPageData(modelAndView, "考生考籍档案管理", "在籍考生查询", "student.js");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/pageList")
    public JsonResult selectExam(HttpServletResponse response){//, @RequestParam(name = "draw")Integer draw, @RequestParam(name = "start")Integer start) {

       // int length = 5;//固定前台展示的每页记录数，否则用length值
      //  PageHelper.startPage(start==null?0:start / length + 1, length);
   /**     JsonObject jsonResponse = new JsonObject();
        List<Template> list=null;
        String searchValue = request.getParameter("search[value]");//实现搜索功能
        if("".equals(searchValue)){
        list = tem.findAllList();
        }else{
    list = tem.searchListByName("%" + searchValue + "%");
        }
        jsonResponse.addProperty("draw", draw);
        jsonResponse.addProperty("recordsTotal", ((Page<Tem>) list).getTotal());
        jsonResponse.addProperty("recordsFiltered",((Page<Tem>) list).getTotal());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm")
                .create();
        jsonResponse.add("data", gson.toJsonTree(list));
        return jsonResponse.toString();
    **/
        try {
            List<StudentBasicInfomation> list = service.StudentBasicInfomationList();
//            Map<String,Object> map = new HashMap<>();
//            map.put("draw", draw);
//            map.put("recordsTotal", ((Page<Zjkscx>) list).getTotal());
//            map.put("recordsFiltered",((Page<Zjkscx>) list).getTotal());
            return new JsonResult(Const.RESULT_SUCCESS_CODE, Const.RESULT_SUCCESS_MSG, list == null ? new ArrayList<StudentBasicInfomation>() : list);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(Const.RESULT_ERROR_CODE, Const.RESULT_ERROR_MSG);
        }
    }
}
