$(function () {
    var url = location.search,
        songListId = {};
    //如果url有id
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            songListId[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    // alert(songListId.songListId)
    var editInfo = new Vue({
        el: "#editVue",
        data: {
            songlistName: "",
            songlistPicUrl: "",
            songlistDescription: ""
        },
        methods: {
            getSongListInfo: function () {
                $.ajax({
                    url: "/MyMusic/showSonglistInfo",
                    type: "post",
                    data: {
                        songListId: songListId.songListId,
                        userId: 5
                    },
                    dataType: "json",
                    success: function (data) {
                        editInfo.songlistName = data.songlistName;
                        editInfo.songlistPicUrl = data.songlistPicUrl;
                        editInfo.songlistDescription = data.songlistDescription
                    }
                })
            }
        }
    });
    editInfo.getSongListInfo();
    //标签选择
    $("a[class='sel_tag']").click(function () {
        $("div[class='edit_tag']").css("display", "inline");
        // parent.window.showControl();
    });
    $("span[class='tag_close']").click(function () {
        $("div[class='edit_tag']").css("display", "none");
        // parent.window.closeControl();
    });
    //标签多选限制
    layui.use(['layer','form'],function () {
        var layer = layui.layer;
        var form = layui.form;
        form.on('checkbox(tt)', function(data){
            var len=$(".tag-sel:checked").length;
            if(len>3){
                $(data.elem).next().attr("class","layui-unselect layui-form-checkbox");
                $(data.elem).prop("checked",false);
                layer.msg('最多选择三个标签！！');
            }
            console.log(data.elem); //得到checkbox原始DOM对象
            console.log(data.elem.checked); //是否被选中，true或者false
            console.log(data.value); //复选框value值，也可以通过data.elem.value得到
            console.log(data.othis); //得到美化后的DOM对象
        });
    });

    //保存修改按钮
    $("#savabtn").click(function () {
        $.ajax({
            url: "/MyMusic/editSonglist",
            type: "post",
            data: {
                songlistId: songListId.songListId,
                songlistName: $("input[class='name_text']").val(),
                songlistPicUrl: "",
                songlistDescription: $("textarea[class='text_info']").val()
            },
            dataType: "json",
            success: function (data) {
                if (data == 1) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.msg('编辑成功！');
                    });
                    setTimeout("window.location.reload()", "1000");
                }
            }
        })
    })
});
