package com.example.exam.utils;

import java.util.ArrayList;
import java.util.List;

public class Const {
    public static final String SITE_NAME = "考籍管理";
    public static final String SITE_NAME_HTML = "<b>考籍管理</b>系统";

    public static final int RESULT_SUCCESS_CODE = 1111;
    public static final String RESULT_SUCCESS_MSG = "操作成功！";
    public static final int RESULT_ERROR_CODE = 9999;
    public static final String RESULT_ERROR_MSG = "网络开小差～！";


    // 用户权限所对应的功能菜单
    public static final Page[] pages = {
           // new Page("考生考籍档案管理", "foo", "user-tie", 1, new Page(
           //         "设置当前考次", "setCurrentexam", "user-tie", 1,null)),
            new Page("考生考籍档案管理", "foo", "user-tie", 1, new Page(
                    "设置当前考次", "./examround/getexamround", "user-tie", 1,null)

            ),


            new Page("在籍考生查询", "./zjkscx", "th-list",2,  new Page(
                    "在籍考生查询", "./student/studenPage", "user-tie", 1,null)),






            new Page("按地区统计", "./", "th-list",2, null),
            new Page("功能3", "baz", "globe-americas", 1, new Page(
                    "子功能1", "qux", "shopping-cart", 1, null)),

            new Page("功能4", "baz", "globe-americas", 1, new Page(
                    "子功能2", "qux", "shopping-cart", 1, new Page(
                        "三级功能", "foobar", "shopping-cart", 1, null)
                )
            ),
            };
}
