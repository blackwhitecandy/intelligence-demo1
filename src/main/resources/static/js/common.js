// 主导航
jQuery(document).ready(function(){
	var qcloud={};
	$('[_t_nav]').hover(function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').each(function(){
		$(this)[ _nav == $(this).attr('_t_nav') ? 'addClass':'removeClass' ]('hover');
		});
		$('#'+_nav).stop(true,true).slideDown(200);
		}, 150);
	},function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').removeClass('hover');
		$('#'+_nav).stop(true,true).slideUp(200);
		}, 150);
	});
});
// TAB切换
$(function() {
function tabs(tabTit, on, tabCon) {
    $(tabCon).each(function() {
        $(this).children().eq(0).show();
    });
    $(tabTit).each(function() {
        $(this).children().eq(0).addClass(on);
    });
    $(tabTit).children().click(function() {
        $(this).addClass(on).siblings().removeClass(on);
        var index = $(tabTit).children().index(this);
        $(tabCon).children().eq(index).show().siblings().hide();
    });
}
tabs(".tab-tit", "curr", ".tab-con");
tabs(".tab-tit2", "curr", ".tab-con2");
});
// TAB切换
function showDiv(obj, num, len) {
    for (var id = 0; id <= len; id++) {
        var ss = obj + id;
        var snav = obj + "nav" + id;
        if (id == num) {
            try {
                document.getElementById(ss).style.display = "block"
            } catch(e) {};
            try {
                document.getElementById(snav).className = "curr"
            } catch(e) {};
        } else {
            try {
                document.getElementById(ss).style.display = "none"
            } catch(e) {};
            try {
                document.getElementById(snav).className = ""
            } catch(e) {};
        }
    }
}
// Drop菜单
function dropMenu(obj) {
    $(obj).each(function() {
        var theSpan = $(this);
        var theMenu = theSpan.find(".menu");
        var tarHeight = theMenu.height();
        theMenu.css({
            height: 0,
            opacity: 0
        });
        theSpan.hover(function() {
            $(this).addClass("drop-hover");
            theMenu.stop().show().animate({
                height: tarHeight,
                opacity: 1
            },
            20);
        },
        function() {
            $(this).removeClass("drop-hover");
            theMenu.stop().animate({
                height: 0,
                opacity: 0
            },
            20,
            function() {
                $(this).css({
                    display: "none"
                });
            });
        });
    });
}
$(document).ready(function() {
    dropMenu(".drop-menu");
});
// Drop按钮
$(function() {
  $(".drop-btn").hover(function() {
		$(this).toggleClass("curr").siblings().removeClass("curr");
  });
});
// Drop选项
$(function() {
	$(".text-select").click(function() {
		var span = $(".drop-select .menu");
		if (span.css("display") == "none") {
			span.show();
			$(".drop-select").addClass("drop-hover");
		} else {
			span.hide();
			$(".drop-select").removeClass("drop-hover");
		}
	});
	$(".drop-select .menu a").click(function() {
		var txt = $(this).text();
		$(".text-select").val(txt);
		var value = $(this).attr("rel");
		$(".drop-select .menu").hide();
		$(".drop-select").removeClass("drop-hover");
	});
});
// 展开收起项目菜单
$(function() {
  $(".folditem-menu").click(function() {
  if ($(this).parents("dl").find(".folditem").css("display") == "none") {
    $(this).parents("dl").find(".folditem").fadeIn().show();
    $(this).removeClass("opened");
  } else {
    $(this).parents("dl").find(".folditem").hide();
    $(this).addClass("opened");
  }
  });
  $(".folditem-open").click(function() {
    $(".folditem").fadeIn().show();
    $(".folditem-menu").removeClass("opened");
  });
  $(".folditem-close").click(function() {
    $(".folditem").fadeOut().hide();
    $(".folditem-menu").addClass("opened");
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
// 加HOVER
$(function() {
  $(".select-hover .item").hover(function() {
	if($(this).hasClass("hover")){	
		$(this).removeClass("hover");
	}else{	
		$(this).addClass("hover");
	}
  });
});
// 更多项目
$(function() {
  $(".moreitem-link").click(function() {
  if ($(this).parents(".mselect-item").find(".moreitem").css("display") == "none") {
    $(this).parents(".mselect-item").find(".moreitem").fadeIn().show();
    $(this).addClass("opened");
  } else {
    $(this).parents(".mselect-item").find(".moreitem").hide();
    $(this).removeClass("opened");
  }
  });
});
// 展开更多选项
$(function() {
  $(".moreselect-link").click(function() {
  if ($(".moreselect").css("display") == "none") {
    $(".moreselect").fadeIn().show();
    $(this).addClass("opened");
  } else {
    $(".moreselect").hide();
    $(this).removeClass("opened");
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
// POP弹窗
function PopLayer(show) {
    for (var i = 1; i < 1000; i++) {
        if (i == show) {
            if (document.getElementById("pop" + i).style.display == "none") {
                document.getElementById("pop" + i).style.display = "block";
                document.getElementById("pop" + i).className = "fade in";
            } else {
                document.getElementById("pop" + i).style.display = "none";
                document.getElementById("pop" + i).className = "fade";
            }
        }
    }
}
// 收起菜单
$(function() {
    $(".foldmenu-btn").click(function() {
        var offset = $(".foldmenu");
        var offcon = $("#fold_menu");
        if (offset.css("marginLeft") == "-280px") {
			$(offcon).addClass("foldmenu-open");
            $(offset).animate({
                marginLeft: "-560px",
            },
            100);
            $(offcon).animate({
                paddingLeft: "0",
            },
            100);
            $(offcon).animate({
                paddingLeft: "20px",
            },
            100);
        } else {
			$(offcon).removeClass("foldmenu-open");
            $(offset).animate({
                marginLeft: "-280px",
            },
            100);
            $(offcon).animate({
               paddingLeft: "320px",
            },
            100);
            $(offcon).animate({
               paddingLeft: "280px",
            },
            100);
        }
    })
})
// 展开收起
function Unfolding(show) {
    for (var i = 1; i < 1000; i++) {
        if (i == show) {
            if (document.getElementById("fold" + i).style.display == "none") {
                document.getElementById("fold" + i).style.display = "";
                document.getElementById("switch").className = "btn-open";
                document.getElementById("switch").innerHTML = "<i class='icon-arrow'></i>收起";
            } else {
                document.getElementById("fold" + i).style.display = "none";
                document.getElementById("switch").className = "btn-fold";
                document.getElementById("switch").innerHTML = "<i class='icon-arrow'></i>展开";
            }
        }
    }
}
// 展开收起
function Unfolding2(show) {
    for (var i = 1; i < 1000; i++) {
        if (i == show) {
            if (document.getElementById("fold" + i).style.display == "none") {
                document.getElementById("fold" + i).style.display = "";
                document.getElementById("switch").className = "btn-open";
                document.getElementById("switch").innerHTML = "<i class='icon-arrow'></i>收起标注";
            } else {
                document.getElementById("fold" + i).style.display = "none";
                document.getElementById("switch").className = "btn-fold";
                document.getElementById("switch").innerHTML = "<i class='icon-arrow'></i>查看标注";
            }
        }
    }
}
// 工具条
$(function() {
  $(".ctrolGuide a").hover(function() {
	if($(this).hasClass("hover")){	
		$(this).removeClass("hover");
	}else{	
		$(this).addClass("hover");
	}
  });
});
// 返回顶部底部
$(function() {
  $(".ctrolPanel > a.t").click(function() {
    $("html,body").animate({
      scrollTop: 0
    },
    200);
    return false;
  });
  $(".ctrolPanel > a.b").click(function() {
    $("html,body").animate({
      scrollTop: $(document).height()
    },
    200);
    return false;
  });
});
