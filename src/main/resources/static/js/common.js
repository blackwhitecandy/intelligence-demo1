// 获取信息
$(function() {
  $('#getInfo').on('click', function(){
    layer.open({
      type: 1,
      title: '获取信息',
      area: ['600px', '360px'],
      shadeClose: true,
      content: $('#getInfoCon')
    });
  });
});
// 添加属性
$(function() {
  $('.addto').on('click', function(){
    layer.open({
      type: 1,
      title: '增加主题分类',
      area: ['800px'],
      shadeClose: true,
      content: $('#addtoSort')
    });
  });
});
// 删除全部属性
$(function() {
  $('.empty').on('click', function(){
    layer.confirm('您确定要删除全部这类属性？', {
      title: '提示',
      btn: ['确定','取消'],
    });
  });
});
// 筛选
$(function() {
  $('#filterBtn').on('click', function(){
    layer.open({
      type: 1,
      title: '筛选',
      area: ['800px'],
      shadeClose: true,
      content: $('#filterItem'),
      btn: ['应用筛选','取消筛选'],
    });
  });
});
// 文献对比
$(function() {
  $('.num').on('click', function(){
    layer.open({
      type: 1,
      title: '文献对比',
      area: ['1000px','600px'],
      shadeClose: true,
      //scrollbar: false,
      content: $('#documentNum'),
    });
  });
});
// 编辑
$(function() {
  $('.edit').on('click', function(){
    layer.open({
      type: 1,
      title: '编辑',
      area: ['500px'],
      shadeClose: true,
      content: $('#editItem'),
      btn: ['修改','取消'],
    });
  });
});



// 排列形式
$(function() {
    $(".array-mod .array a").click(function(){
        var pat=$(this).parents(".array-mod"),
            pat2=$(this).parents(".array"),
            cmd=$(this).attr("cmd"),
            cu="curr";
        if(cmd=="list"){	
            pat2.find("[cmd='list']").addClass(cu);
            pat2.find("[cmd='view']").removeClass(cu);
            pat.find(".data-list").show();
            pat.find(".data-view").hide();
        }
        if(cmd=="view"){
            pat2.find("[cmd='list']").removeClass(cu);
            pat2.find("[cmd='view']").addClass(cu);
            pat.find(".data-list").hide();
            pat.find(".data-view").show();
        }
    });
});
// 单选项
$(function() {
  $(".database label").click(function() {
    $(this).parents(".database").find("label").removeClass("curr");
    $(this).addClass("curr");
  });
});
// 单选分类
$(function() {
  $(".select-sort a").click(function() {
    $(this).parents(".select-sort").find("a").removeClass("curr");
    $(this).addClass("curr");
  });
});
// 多选项目
$(function() {
  $(".mselect-item .chose").click(function() {
	if($(this).hasClass("checked")){	
		$(this).removeClass("checked");
	}else{	
		$(this).addClass("checked");
	}
  });
});
// 全选反选
$(function() {
    $("#selectAll").click(function() {
        $("#selectList :checkbox").attr("checked", true);
    });
    $("#selectUn").click(function() {
        $("#selectList :checkbox").attr("checked", false);
    });
    $("#selectRe").click(function() {
        $("#selectList :checkbox").each(function() {
            $(this).attr("checked", !$(this).attr("checked"));
        });
    });
});
