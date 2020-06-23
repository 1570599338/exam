let exanroundJq = $("#examround-form [name=examround]");
$("#examround-form [name=examround]").click(function () {
    var url="/examround/selectExam"; //访问后台去数据库查询select的选项,此处需填写后台接口路径
    $.ajax({
        type:"get",
        url:url,
        success:function(userList){
            var unitObj=document.getElementById("mySelect"); //页面上的<html:select>元素
            if(userList.code==9999){
                msgJq.addClass('text-danger');
                msgJq.text(userList.message);
            }
            $("#mySelect").empty();
            unitObj.options.add(new Option("请选考次","",true,true));
            if(userList!=null){ //后台传回来的select选项
                for(var i=0;i<userList.data.length;i++){
                    //遍历后台传回的结果，一项项往select中添加option
                    unitObj.options.add(new Option(userList.data[i].examround,userList.data[i].examround));
                }
            }
        },
        error:function(){
            msgJq.alert('Error');
        }
    })
});


$("#examround-form button").click(function () {



    var options=$("#mySelect option:selected");//获取选中的项
    var optionValue = options.val();
    var optionText = options.text();
    // alert("jquery方法拿到选中项的值： " + options.val());
    // alert("jquery方法拿到选中项的文本： " + options.text());


    let exanround = exanroundJq.val();
    let url = "/examround/addExam";
    let dataObj = {
        value: optionValue,
        text: optionText
    }
  if(!optionValue || !optionText){
      alert("请正确切换考次！");

      return false;

  }
    $.post(url, dataObj, function (jsonObject) {
        if (jsonObject.hasOwnProperty('code')) {
            if (jsonObject.code === 1111) {
                alert(jsonObject.message);
                location.replace('/');
            }else{
                // msgJq.removeClass('text-danger');
                // msgJq.addClass('text-info');
                alert(jsonObject.message);
            }
        }
    });


});

