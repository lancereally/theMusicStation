//我的音乐js文件
$(function () {
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
});