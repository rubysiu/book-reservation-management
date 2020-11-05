layui.use(['layer', 'form', 'element', 'jquery', 'dialog'], function() {
	var layer = layui.layer;
	var element = layui.element();
	var form = layui.form();
	var $ = layui.jquery;
	var dialog = layui.dialog;
	var hideBtn = $('#hideBtn');
	var mainLayout = $('#main-layout');
	var mainMask = $('.main-mask');
	//�����������
	element.on('nav(leftNav)', function(elem) {
		var navA = $(elem).find('a');
		var id = navA.attr('data-id');
		var url = navA.attr('data-url');
		var text = navA.attr('data-text');
		if(!url){
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//�л���ѡ�
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
		mainLayout.removeClass('hide-side');
	});
	//�����������
	element.on('nav(rightNav)', function(elem) {
		var navA = $(elem).find('a');
		var id = navA.attr('data-id');
		var url = navA.attr('data-url');
		var text = navA.attr('data-text');
		if(!url){
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//�л���ѡ�
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);
			
		}
		mainLayout.removeClass('hide-side');
	});
	//�˵�������ʾ
	hideBtn.on('click', function() {
		if(!mainLayout.hasClass('hide-side')) {
			mainLayout.addClass('hide-side');
		} else {
			mainLayout.removeClass('hide-side');
		}
	});
	//���ֵ������
	mainMask.on('click', function() {
		mainLayout.removeClass('hide-side');
	})

	//ʾ��һ�������
//	layer.open({
//		  type: 1
//		  ,title: false //����ʾ������
//		  ,closeBtn: false
//		  ,area: '300px;'
//		  ,shade: 0.8
//		  ,id: 'LAY_layuipro' //�趨һ��id����ֹ�ظ�����
//		  ,resize: false
//		  ,btn: ['����Χ��', '���ܾ̾�']
//		  ,btnAlign: 'c'
//		  ,moveType: 1 //��קģʽ��0����1
//		  ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">��̨ģ��1.1�汾���ո��£�<br><br><br>�����б�ҳ...<br><br>�༭ɾ����������<br><br>ʧȥ����������<br>�����б�ҳ<br>�����б�ҳ<br>�����б�ҳ</div>'
//		  ,success: function(layero){
//		    var btn = layero.find('.layui-layer-btn');
//		    btn.find('.layui-layer-btn0').attr({
//		      href: 'http://www.layui.com/'
//		      ,target: '_blank'
//		    });
//		  }
//		});
});