layui.config({
	base: '/resources/static/admin/js/module/'
}).extend({
	dialog: 'dialog',
});

layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
	var form = layui.form(),
		layer = layui.layer,
		$ = layui.jquery,
		dialog = layui.dialog;
	//��ȡ��ǰiframe��nameֵ
	var iframeObj = $(window.frameElement).attr('name');
	//ȫѡ
	form.on('checkbox(allChoose)', function(data) {
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
		child.each(function(index, item) {
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});
	//��Ⱦ��
	form.render();	
	//�������
	$('.addBtn').click(function() {
		var url=$(this).attr('data-url');
		//��iframeObj���ݸ���������,ִ�в������ˢ��
		parent.page("�˵����", url, iframeObj, w = "700px", h = "620px");
		return false;

	}).mouseenter(function() {

		dialog.tips('���', '.addBtn');

	})
	//��������
	$('.listOrderBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'��ȷ��Ҫ����������',
			success:function(){
				layer.msg('ȷ����')
			},
			cancel:function(){
				layer.msg('ȡ����')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('��������', '.listOrderBtn');

	})	
	//��������ɾ��
	$('.delBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'��ȷ��Ҫɾ��ѡ����',
			success:function(){
				layer.msg('ɾ����')
			},
			cancel:function(){
				layer.msg('ȡ����')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('����ɾ��', '.delBtn');

	})	
	//�б����
	$('#table-list').on('click', '.add-btn', function() {
		var url=$(this).attr('data-url');
		//��iframeObj���ݸ���������
		parent.page("�˵����", url, iframeObj, w = "700px", h = "620px");
		return false;
	})
	//�б�ɾ��
	$('#table-list').on('click', '.del-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		dialog.confirm({
			message:'��ȷ��Ҫ����ɾ����',
			success:function(){
				layer.msg('ȷ����')
			},
			cancel:function(){
				layer.msg('ȡ����')
			}
		})
		return false;
	})
	//�б���ת
	$('#table-list,.tool-btn').on('click', '.go-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		window.location.href=url+"?id="+id;
		return false;
	})
	//�༭��Ŀ
	$('#table-list').on('click', '.edit-btn', function() {
		var That = $(this);
		var id = That.attr('data-id');
		var url=That.attr('data-url');
		//��iframeObj���ݸ���������
		parent.page("�˵��༭", url + "?id=" + id, iframeObj, w = "700px", h = "620px");
		return false;
	})
});

/**
 * ����iframe���ڵ�ˢ�²���
 */
var iframeObjName;

//��������ҳ��
function page(title, url, obj, w, h) {
	if(title == null || title == '') {
		title = false;
	};
	if(url == null || url == '') {
		url = "404.html";
	};
	if(w == null || w == '') {
		w = '700px';
	};
	if(h == null || h == '') {
		h = '350px';
	};
	iframeObjName = obj;
	//����ֻ��ˣ�ȫ����ʾ
	if(window.innerWidth <= 768) {
		var index = layer.open({
			type: 2,
			title: title,
			area: [320, h],
			fixed: false, //���̶�
			content: url
		});
		layer.full(index);
	} else {
		var index = layer.open({
			type: 2,
			title: title,
			area: [w, h],
			fixed: false, //���̶�
			content: url
		});
	}
}

/**
 * ˢ����ҳ,�رյ���
 */
function refresh() {
	//���ݴ��ݵ�nameֵ����ȡ��iframe���ڣ�ִ��ˢ��
	if(window.frames[iframeObjName]) {
		window.frames[iframeObjName].location.reload();

	} else {
		window.location.reload();
	}

	layer.closeAll();
}