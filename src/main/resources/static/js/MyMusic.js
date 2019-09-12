//我的音乐js文件
$(function () {
    //创建歌单展开和收起
    $("span[name='create']").click(function () {
        if ($("#f_list").css("display") == "none") {
            $("#f_list").css("display", "inline");
            $("i[name='l1']").css({
                "border-color": "#ccc transparent transparent",
                "border-style": "solid dashed dashed",
                "border-width": "8px 7px 0"
            });
        } else {
            $("#f_list").css("display", "none");
            $("i[name='l1']").css({
                "border": "8px solid #ccc",
                "border-color": "transparent transparent transparent #ccc",
                "border-style": "dashed dashed dashed solid",
                "margin-right": "0"
            })
        }
    });
    //收藏歌单展开和收起
    $("span[name='shoucang']").click(function () {
        if ($("#s_list").css("display") == "none") {
            $("#s_list").css("display", "inline");
            $("i[name='l2']").css({
                "border-color": "#ccc transparent transparent",
                "border-style": "solid dashed dashed",
                "border-width": "8px 7px 0"
            });
        } else {
            $("#s_list").css("display", "none");
            $("i[name='l2']").css({
                "border": "8px solid #ccc",
                "border-color": "transparent transparent transparent #ccc",
                "border-style": "dashed dashed dashed solid",
                "margin-right": "0"
            })
        }
    });
//   layui引用
    $("a[class='create_btn']").click(function () {

        console.log("ssss0");
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.msg('hello');
        });
    });
    //创建按钮使用
    // $("a[class='create_btn']").click(function () {
    //     $("div[class='mymusic_create']").css("display", "inline");
    //     $("div[class='control']").css("display", "inline")
    // });
    // $("span[class='cre_close']").click(function () {
    //     $("div[class='mymusic_create']").css("display", "none");
    //     $("div[class='control']").css("display", "none")
    // });
    // $("button[name='dbtn']").click(function () {
    //     $("div[class='mymusic_create']").css("display", "none");
    //     $("div[class='control']").css("display", "none")
    // });
});