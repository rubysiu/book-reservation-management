var admin = {
    //��װ���ajax��url
    URL:{

        verify:function(){
            return '/admin/verify';
        }
    },
    //�˳�
    delCookie:function(){
        $.removeCookie('token',{domain:'localhost',path:'/admin'});
        var token=$.cookie('token');
        if(token ==null||!token){
            window.top.location.href = "/admin"
        }
    },
    //��֤ѧ�ź�����
    validateAdmin:function(token){

        if(!token){
            return "nothing";
        }else {
            if(admin.verifyWithDatabase(token)){
                console.log("��֤�ɹ���");
                return "success";
            }else{
                console.log("��֤ʧ�ܣ�");
                return "mismatch";
            }
        }
    },
    //��ѧ�ź��û��������ݿ�ƥ��
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
            async:false,                       //ͬ�����ã���֤��ִ��result=true,����ִ��return result;
            success:function(data){

                if(data.result=='SUCCESS'){
                    window.location.reload();
                    //������¼�ɹ���
                    console.log("��½�ɹ���");
                    window.location.href = "/admin"
                    result=true;
                }else{
                    result=false;
                }
            }
        });
        // console.log("������֤�����"+result);
        return result;

    },

    //Ԥ��ͼ���߼�
    detail:{
        //Ԥ��Ҳ��ʼ��
        init:function(params){
            var token=$.cookie('token');
            if (!token||token ==null){
                $('#input-19').keydown(function (even){
                    token=$('#input-19').val();
                    if(event.keyCode==13){
                        //����validateAdmin������֤�û�id�����롣
                        var temp=admin.validateAdmin(token);
                        if(temp=="success"){
                            //ѧ��������ƥ����ȷ����ѧ�����뱣����cookie�С�������cookie����ʱ�䣬������Ϊsessionģʽ���ر�������Ͳ����������ˡ�
                            $.cookie('token', token, {  path: '/admin'});
                            // ��ת��ԤԼ�߼�
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