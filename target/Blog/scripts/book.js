//根据用户id查询笔记本信息
function loadUserBook() {
    //1.获取请求参数
    //获取用户id
    var uid=getCookie("uid");
    //2.参数格式校验
    if (uid==null){
        window.location.href="log_in.html";
    }
    //3.发送Ajax
    $.ajax({
        url:base_path+"/book/loadbooks.do",
        type:"post",
        data:{"userId":uid},
        dataType:"json",
        success:function (result) {
            if(result.status==0){
                var books=result.data;
                for (var i =0; i<books.length; i++){
                    var bookName=books[i].cn_notebook_name;
                    var bookId =books[i].cn_notebook_id;
                    createBookLi(bookId,bookName);
                }
            }
        },
        error:function () {
            alert("查询用户笔记本异常")
        }
    })
}
//创建笔记LI
function createBookLi(bookId,bookName) {
    <!-- 动态生成笔记本列表li -->
    var lis = '';
    lis +='<li class="online">';
    lis +='<a>';
    lis +='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
    lis +='</i>'+bookName+'</a></li>';
    //DOm对象转换为jQuery对象
    var $lis=$(lis);
    //给li绑定bookId数据
    //data是jQuery的方法，要使用该方法必须将DOM对象转换为jQuery对象
    $lis.data("bookId",bookId);
    //在boo_ul下追加li
    $("#book_ul").append($lis)
}

//笔记本的创建
function addBook() {
    //获取请求参数
    //笔记本名称
    var bookName = $("#input_notebook").val().trim();
    //用户ID
    var userId = getCookie("uid");
    //参数格式校验
    ok = true;
    if (bookName==""){
        ok = false;
        $("#notebook_span").html("笔记本名称为空");
    }
    if (userId == null){
        ok =false;
        window.location.href = "log_in.html";
    }
    if (ok){
//发送ajax
        $.ajax({
            url: base_path+"/book/add.do",
            type: "post",
            data: {"userId":userId,"bookName":bookName},
            dataType: "json",
            success:function (result) {
                //或者把关闭弹出给提取出来
                closeAlertWindow();
                //TODO
                if (result.status==0){
                    var bookId = result.data.cn_notebook_id;
                    // //1.关闭对话框
                    // closeAlertWindow();
                    //2.将新创建的笔记本添加到li中
                    createBookLi(bookId,bookName)
                    //弹出成功提示框
                    alert(result.msg);
                }
                    // //1.关闭对话框
                    // closeAlertWindow();
                    //2.弹出错误提示框
                    alert(result.msg);

            },
            error:function () {
                alert("创建笔记异常")
            }
        })
    }
}