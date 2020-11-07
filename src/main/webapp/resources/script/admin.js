var admin = {
    //封装相关ajax的url
    URL:{

        verify:function(){
            return '/admin/verify';
        }
    },
    //退出
    delCookie:function(){
        $.removeCookie('token',{domain:'localhost',path:'/admin'});
        var token=$.cookie('token');
        if(token ==null||!token){
            window.top.location.href = "/admin"
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
                    console.log("登陆成功！");
                    window.location.href = "/admin"
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
                window.location.href = "/admin"
            }
        }
    },

}