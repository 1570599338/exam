




var user_tab;
var user_list_param;
$(function () {
    user_list_setParm();
    const NO=0;
    user_tab = $('#user_tab').DataTable({
        // 'paging'      : true,
        // 'lengthChange': false,
        // 'searching'   : false,
        // 'ordering'    : true,
        // 'info'        : true,
        // 'autoWidth'   : false,
         "processing": true,
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "ordering": false,
        "info": true,
        "autoWidth": false,
       // "order" : [[2, 'desc']],

        "language": {
            "lengthMenu": " _MENU_ 条记录/每页",
            "zeroRecords": "对不起，暂时没有记录",
            "info": "第 _PAGE_页，共_PAGES_页",
            "infoEmpty": "暂无信息",
            "infoFiltered": "(从_MAX_条数据中筛选)",
            "paginate": {
                "previous":"上一页",
                "next" : "下一页"
            }
        },


        "ajax":{
             "url": "/student/pageList",
            "data":{"admissionNumber":$("#admissionNumber").val()?"123":$("#admissionNumber").val()},
             "type":"post"
        },

        "columns": [
            {"data": "admissionNumber"},
            {"data": "admissionNumber"},
            {"data": "studentId"},
            {"data": "gender"},

            {"data": "examRound"},
            {"data": "birthdate"},

            {"data": "postecode"}
        ],

        "columnDefs" : [
            {
                targets: 0,
                data: null,
                orderable:false,
                render: function (data) {
                    return '<input type="checkbox" class="userCheckbox" value="'+data+'"/>';
                }
            },
            {
                targets: 3,
                data: null,
                orderable:false,
                render: function (data) {
                    if(data==1){
                        return "男";
                    }

                    return "女";
                }
            },
            {
                "targets" : -1,
                "data" : null,
                orderable:false,
                "render" : function(data) {
                    var data = "'"+data+"'";
                    var btn1='<a class="btn btn-xs btn-warning"  target="modal" modal="hg" href=""><i class="fa fa-edit"></i>修改</a>  ';
                    var btn2 = '<a class="btn btn-xs btn-danger"  target="modal" modal="hg" onclick="user_list_delete('+data+')"><i class="fa fa-remove"></i>删除</a>  ';
                    return btn1+btn2;
                }
            }
        ]
    });
})


        function user_list_query() {
            user_list_setParm();

            user_tab.settings()[0].ajax.data = user_list_param;
            user_tab.ajax.reload();
        }

        //动态拼接参数
        function user_list_setParm() {
            var admissionNumber = $("#admissionNumber").val();

            user_list_param = {
                "admissionNumber" : admissionNumber
            };
        }