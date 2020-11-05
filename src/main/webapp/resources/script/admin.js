var admin = {
    //封装相关ajax的url
    URL:{

        verify:function(){
            return '/admin/verify';
        }
    },
    //验证学号和密码
    validateAdmin:function(token){
        if(!token){
            return "nothing";
        }else {
            if(admin.verifyWithDatabase(token)){
                console.log("验证成功！");
                return "success";
            }else{
                console.log("验证失败！");
                return "mismatch";
            }
        }
    },
    //将学号和用户名与数据库匹配
    verifyWithDatabase:function(token){
        var result=false;
        var params={};
        params.token=token;
        var verifyUrl=admin.URL.verify();
        $.ajax({
            type:'post',
            url:verifyUrl,
            data:params,
            datatype:'josn',
            async:false,                       //同步调用，保证先执行result=true,后再执行return result;
            success:function(data){

                if(data.result=='SUCCESS'){
                    window.location.reload();
                    //弹出登录成功！
                    alert("登陆成功！");
                    result=true;
                }else{
                    result=false;
                }
            }
        });
        // console.log("我是验证结果："+result);
        return result;

    },

    //预定图书逻辑
    detail:{
        //预定也初始化
        init:function(params){
            var token=$.cookie('token');
            if (!token||token ==null){
                $('#input-19').keydown(function (even){
                    token=$('#input-19').val();
                    if(event.keyCode==13){
                        //调用validateAdmin函数验证用户id和密码。
                        var temp=admin.validateAdmin(token);
                        if(temp=="success"){
                            //学号与密码匹配正确，将学号密码保存在cookie中。不设置cookie过期时间，这样即为session模式，关闭浏览器就不保存密码了。
                            $.cookie('token', token, {  path: '/admin'});
                            // 跳转到预约逻辑
                            var appointbox=$('#appoint-box');
                            admin.appointment(token,appointbox);
                    }


                    }
                });
            }else{
                var appointbox=$('#appoint-box');
                admin.appointment(bookId,studentId,appointbox);
            }
        }
    },
    appointment:function(bookId,studentId, node){
        console.log("我执行预约的方法!" );
        node.html('<button class="btn btn-primary btn-lg" id="appointmentBtn">预约</button>');

        var appointmentUrl = bookappointment.URL.appoint(bookId,studentId);
        console.log("appointmentUrl:"+appointmentUrl);
        //绑定一次点击事件
        $('#appointmentBtn').one('click', function () {
            //执行预约请求
            //1、先禁用请求
            $(this).addClass('disabled');
            //2、发送预约请求执行预约
            $.post(appointmentUrl,{},function(result){   //Ajax强大之处，向Controller方法提出请求和返回结果在一处!
                if(result && result['success']){         //同时还可以连续取对象的子对象！
                    var appointResult=result['data'];
                    console.log("appointResult"+appointResult);
                    var state=appointResult['state'];
                    console.log("state"+state);
                    var stateInfo=appointResult['stateInfo'];
                    console.log("stateInfo"+stateInfo);
                    //显示预约结果                                                          把结果显示给页面，完成了jsp的工作

                    node.html('<span class="label label-success">'+stateInfo+'</span>');
                }       //因为公用一个node所以，用来显示“stateInfo”时就不会显示上面的“预约”
                console.log('result'+result);
            });
        });


    },
}