$(function () {
    var tagVal = [];
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
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer;
        var form = layui.form;
        form.on('checkbox(tt)', function (data) {
            var len = $(".tag-sel:checked").length;
            if (len > 3) {
                $(data.elem).next().attr("class", "layui-unselect layui-form-checkbox");
                $(data.elem).prop("checked", false);
                layer.msg('最多选择三个标签！！');
            }
            console.log(len);
            console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        });
    });
    //输出选中标签的值
    $("#doSave").click(function () {
        $("input:checkbox[class='tag-sel']:checked").each(function (index) {
            tagVal[index] = $(this).val()
        });
        //保存标签
        $.ajax({
            url: "/MyMusic/editTag",
            type: "post",
            data: {
                songlistTag: tagVal[0] + " " + tagVal[1] + " " + tagVal[2],
                songlistId: songListId.songListId
            },
            dataType: "json",
            success: function (data) {
                if (data == 1) {
                    layer.msg('标签保存成功！！');
                    $("div[class='edit_tag']").css("display", "none");
                }
            }
        })
    });
    //在input file内容改变的时候触发事件
    $('#pic_show').change(function () {
        //获取input file的files文件数组;
        //$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
        //这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
        var file = $('#pic_show').get(0).files[0];
        //创建用来读取此文件的对象
        var reader = new FileReader();
        //使用该对象读取file文件
        reader.readAsDataURL(file);
        //读取文件成功后执行的方法函数
        reader.onload = function (e) {
            //读取成功后返回的一个参数e，整个的一个进度事件
            console.log(e);
            //选择所要显示图片的img，要赋值给img的src就是e中target下result里面
            //的base64编码格式的地址
            $('#SongListPic').get(0).src = e.target.result;
            // $('#avatar').attr("src","e.target.result");
        };
    });

    //保存修改按钮
    // $("#savabtn").click(function () {
    //     $.ajax({
    //         url: "/MyMusic/editSonglist",
    //         type: "post",
    //         data: {
    //             songlistId: songListId.songListId,
    //             songlistName: $("input[class='name_text']").val(),
    //             songlistPicUrl: "",
    //             songlistDescription: $("textarea[class='text_info']").val()
    //         },
    //         dataType: "json",
    //         success: function (data) {
    //             if (data == 1) {
    //                 layui.use('layer', function () {
    //                     var layer = layui.layer;
    //                     layer.msg('编辑成功！');
    //                 });
    //                 setTimeout("window.location.reload()", "1000");
    //             }
    //         }
    //     })
    // })
    $("#savabtn").click(function () {
        $.ajax({
            url: "/MyMusic/songList/uploadFile",
            type: "post",
            data: {
                "imageFile": $('#SongListPic')[0].src,
            },
            dataType: "text",
            success: function (data) {
                $('#SongListPic').attr("src", data);
                $.ajax({
                    url: "/MyMusic/editSonglist",
                    type: "post",
                    data: {
                        songlistId: songListId.songListId,
                        songlistName: $("input[class='name_text']").val(),
                        songlistPicUrl: data,
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
            }
        })
    })
});
