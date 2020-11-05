layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var tool = {
        /**
         * �Ƴ������ֵ
         * @param arr   ����
         * @param val   ɾ����ֵ
         */
        removeByValue: function (arr, val) {
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] == val) {
                    arr.splice(i, 1);
                    break;
                }
            }
        },
        /**
         * ת���ַ�����ֹxxs
         * @param str
         * @returns {string}
         */
        stringEncode:function (str){
            var div=document.createElement('div');
            if(div.innerText){
                div.innerText=str;
            }else{
                div.textContent=str;//Support firefox
            }
            return div.innerHTML;
            }
        };

    exports('tool', tool);
});  