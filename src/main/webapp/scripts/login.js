//给按钮绑定单击时间
$(function () {
    $("#login").click(login);
})
//登录处理
function login() {
    //1.获取请求参数
    const username = $("#count").val().trim();
    const password = $("#password").val().trim();
    //添加JS/CSS样式之前先去除对应的样式
    $("#count_span").html("")
    $("#password_span").html("")
    //2.参数格式校验
    var ok = true;
    if (username==""){
        ok=false;
        $("#count_span").html("用户名为空")
    }
    if (password==""){
        ok = false;
        $("#password_span").html("密码为空")
    }
    if (ok){
        //3.发送Ajax
        $.ajax({
            url:base_path+"/user/login.do",
            type:"post",
            data:{"username":username,"password":password},
            dataType:"json",
            success:function (result) {
                //TODO

            },
            error:function () {
                alert("登录异常")
            }
        })
    }

}