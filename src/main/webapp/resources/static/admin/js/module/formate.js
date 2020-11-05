layui.define(function(exports){
    var formate = {
        /**
         * ��ȡ��ǰ�����ں���
         * ����һ��ʱ���,���������Ϊ��ǰʱ��
         * ע�⣺�����uinxʱ����ǵó���1000, ����php����time()��õ�ʱ�����Ҫ����1000
         * @type String timestamp Ҫת����ʱ�����ʽ 1469504554276
         * @returns {String} ���ڸ�ʽ: 2016-07-26 10:55:38
         */
        ge_time_format:function(timestamp){
            if(timestamp){
                var date = new Date(timestamp*1000);
            }else{
                var date = new Date();
            }
            Y = date.getFullYear(),
                m = date.getMonth()+1,
                d = date.getDate(),
                H = date.getHours(),
                i = date.getMinutes(),
                s = date.getSeconds();
            if(m<10){
                m = '0'+m;
            }
            if(d<10){
                d = '0'+d;
            }
            if(H<10){
                H = '0'+H;
            }
            if(i<10){
                i = '0'+i;
            }
            if(s<10){
                s = '0'+s;
            }
            var t = Y+'-'+m+'-'+d+' '+H+':'+i+':'+s;
            return t;
        },
        /**
         * ���ں���תΪʱ�����ʽ
         * ����һ������ʱ���ʽ,�����������ǻ�ȡ���ڵ�ʱ����
         * @type String strtime Ҫת��������ʱ���ʽ 2016-07-26 10:55:38
         * @return {String} ʱ�����ʽ: 1469504554276
         */
        get_unix_time_stamp:function (strtime) {
            if(strtime){
                var date = new Date(strtime);
            }else{
                var date = new Date();
            }
            time1 = date.getTime();   //�ᾫȷ������---����Ϊ13λ
            //time2 = date.valueOf(); //�ᾫȷ������---����Ϊ13λ
            //time3 = Date.parse(date); //ֻ�ܾ�ȷ���룬���뽫��0������---����Ϊ10λ
            return time1;
        }
    };

    //���test�ӿ�
    exports('formate', formate);
});



