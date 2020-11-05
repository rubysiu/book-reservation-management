var admin = {
    //��װ���ajax��url
    URL:{

        verify:function(){
            return '/admin/verify';
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
                    alert("��½�ɹ���");
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
                var appointbox=$('#appoint-box');
                admin.appointment(bookId,studentId,appointbox);
            }
        }
    },
    appointment:function(bookId,studentId, node){
        console.log("��ִ��ԤԼ�ķ���!" );
        node.html('<button class="btn btn-primary btn-lg" id="appointmentBtn">ԤԼ</button>');

        var appointmentUrl = bookappointment.URL.appoint(bookId,studentId);
        console.log("appointmentUrl:"+appointmentUrl);
        //��һ�ε���¼�
        $('#appointmentBtn').one('click', function () {
            //ִ��ԤԼ����
            //1���Ƚ�������
            $(this).addClass('disabled');
            //2������ԤԼ����ִ��ԤԼ
            $.post(appointmentUrl,{},function(result){   //Ajaxǿ��֮������Controller�����������ͷ��ؽ����һ��!
                if(result && result['success']){         //ͬʱ����������ȡ������Ӷ���
                    var appointResult=result['data'];
                    console.log("appointResult"+appointResult);
                    var state=appointResult['state'];
                    console.log("state"+state);
                    var stateInfo=appointResult['stateInfo'];
                    console.log("stateInfo"+stateInfo);
                    //��ʾԤԼ���                                                          �ѽ����ʾ��ҳ�棬�����jsp�Ĺ���

                    node.html('<span class="label label-success">'+stateInfo+'</span>');
                }       //��Ϊ����һ��node���ԣ�������ʾ��stateInfo��ʱ�Ͳ�����ʾ����ġ�ԤԼ��
                console.log('result'+result);
            });
        });


    },
}