//加载笔记本对应的笔记
function loadBookNotes() {
    //获取请求参数
    $("#book_ul").find("a").removeClass("checked");
    var bookId = $(this).data("bookId");
        //选中状态
    $(this).find("a").addClass("checked");
    //参数校验
    //发送Ajax
    $.ajax({
        url:base_path+"/note/loadNotes.do",
        type:"post",
        data:{"bookId":bookId},
        dataType:"json",
        success:function (result) {
            //添加数据之前先清空
            $("#note_ul").empty();
            if (result.status==0){
                var notes= result.data;
                for (var i=0; i<notes.length; i++){
                    var noteTitle = notes[i].cn_note_title;
                    var noteId = notes[i].cn_note_id;
                    createNoteLi(noteTitle,noteId);
                }
            }
        },
        error:function () {
            alert("显示笔记异常")
        }
    })
}
function createNoteLi(noteTitle,noteId) {
    <!-- 动态生成笔记li元素 -->
    var sli = '';
    sli += '<li class="online">';
    sli += '<a >';
    sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
    sli += ' </a>';
    sli += '<div class="note_menu" tabindex=\'-1\'>';
    sli += '<dl>';
    sli += '<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>\n';
    sli += '<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>\n';
    sli += '<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>\n';
    sli += '</dl>';
    sli += '</div>';
    sli += '</li>';
    //给li绑定bookId数据
    //data是jQuery的方法，要使用该方法必须将DOM对象转换为jQuery对象
    var $sli = $(sli);
    $sli .data("noteId",noteId);
    //在boo_ul下追加li
    $("#note_ul").append($sli)
}
//根据笔记Id加载笔记
function loadNote() {
    //获取请求参数
    $("#note_ul a").removeClass("checked");
    var noteId = $(this).data("noteId");
    $(this).find("a").addClass("checked");
    $.ajax({
        url: base_path+"/note/loadNote.do",
        type: "post",
        data: {"noteId":noteId},
        dataType: "json",
        success:function (result) {
            if (result.status==0){
                var note =result.data;
                $("#input_note_title").val(note.cn_note_title);
                //使用富文本编译器设置body
                 um.setContent(note.cn_note_body);
            }
        },
        error:function () {
            alert("查询笔记详情异常")
        }
    })
}
//保存笔记
function updateNote() {
    //获取请求参数
    var title = $("#input_note_title").val().trim();
    var body=um.getContent();
    var $li = $("#note_ul a.checked").parent();
    var noteId=$li.data("noteId");
    //参数格式校验
    if ($li.length==0){
        alert("请选择要保存的笔记")
    }else if (title==""){
        $("#note_title_span").html("<font color='red'>标题不能为空</font>>")
    }else {
        //发送ajax
        $.ajax({
            url:base_path+"/note/update.do",
            type:"post",
            data:{"title":title,"noteId":noteId,"body":body},
            dataType:"json",
            success:function (result) {
                //TODO
                //更新笔记列表中的li元素
                var sli = '';
                sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
                //将选中li元素的a内容替换成sli
                $li.find("a").html(sli);
                alert(result.msg);
            },
            error:function () {
                alert("更新笔记异常")
            }
        })
    }
}
//创建笔记
function addNote() {
    //获取参数
    var noteTitle = $("#input_note").val().trim();
    var userId = getCookie("uid");
    var bookId =$("#book_ul a.checked").parent().data("bookId");
    //参数校验
    $("#note_span").html = "";
    var ok = true;
    if (noteTitle==""){
        ok=false;
        $("#note_span").html("笔记名称不能为空");
        // alert("笔记名称不能为空")
    }
    if (userId==null){
        ok=false;
        window.location.href = "log_in.html";
    }
    if (ok){
        //发送ajax
        $.ajax({
            url:base_path+"/note/addNote.do",
            type:"post",
            data:{"noteTitle":noteTitle,"userId":userId,"bookId":bookId},
            dataType:"json",
            success:function (result) {
                //TODO
                //关闭对话框
                closeAlertWindow();
                if (result.status==0){
                    //添加新的noteLi
                    var noteTitle = result.data.cn_note_title;
                    var noteId=result.data.cn_note_id;
                    createNoteLi(noteTitle,noteId);
                }
                alert(result.msg);
            },
            error:function () {
                alert("添加异常 ")
            }
        })
    }
}
//笔记菜单的显示
function showMenu() {
    //进来之前先隐藏
    hideMenu();
   // var $menu= $("#note_ul a.checked").next();
    //this:指的是下拉菜单按钮
    var $menu = $(this).parent().next()
   //下拉一秒
   $menu.slideDown(1000);
    //打开菜单之前先清除菜单
    $("#note_ul a").removeClass("checked");
    $(this).parent().addClass("checked");
   //jQuery解决冒泡事件
   return false;
}
//隐藏菜单
function hideMenu() {
    $("#note_ul div").hide();
}
//删除笔记
function deleteNote() {
    //获取请求
    var $li = $("#note_ul a.checked").parent();
    var noteId = $li.data("noteId")
    //参数校验
    //发送Ajax
    $.ajax({
        url:base_path+"/note/delete.do",
        type:"post",
        data:{"noteId":noteId},
        dataType:"json",
        success:function (result) {
            //1.关闭删除对话框
            closeAlertWindow();
            if (result.status==0){
                //2.删除对应的li
                $li.remove();
            }
            //提示信息
            alert(result.msg);
        },
        error:function () {
            alert("删除笔记异常")
        }
    })

}