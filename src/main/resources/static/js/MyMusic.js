//我的音乐js文件
$(function () {
    var song = new Vue({
        el:"#songList",
        data:{
            likeSongList:[],
            shouSongList:[],
            url:""
        },
        methods:{
            getLikeSongList:function () {
                song.likeSongList=[];
                $.ajax({
                    url:"/MyMusic/likesonglist",
                    type:"post",
                    data:{userId:5},
                    dataType:"json",
                    success:function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                song.likeSongList.push({
                                    songlistId:data[i].songlistId,
                                    songlistName:data[i].songlistName,
                                    songlistCount:data[i].songlistCount,
                                    songlistPicUrl:data[i].songlistPicUrl
                                });
                            }
                        } else {
                            alert("表中无记录");
                        }
                    }
                })
            },
            getShouSongList:function () {
                song.shouSongList=[];
                $.ajax({
                    url:"/MyMusic/shousonglist",
                    type:"post",
                    data:{userId:5},
                    dataType:"json",
                    success:function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                song.shouSongList.push({
                                    songlistId:data[i].songlistId,
                                    songlistName:data[i].songlistName,
                                    songlistCount:data[i].songlistCount,
                                    songlistPicUrl:data[i].songlistPicUrl
                                });
                            }
                        } else {
                            alert("表中无记录");
                        }
                    }
                })
            },
            goTo:function (slId) {
                song.url= 'my_songlist.html' + '?songListId=' + escape(slId);
                // alert(url)
            }
        }
    });
    song.getLikeSongList();
    song.getShouSongList();
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
// //   layui引用
//     $("a[class='create_btn']").click(function () {
//
//         console.log("ssss0");
//         layui.use('layer', function(){
//             var layer = layui.layer;
//
//             layer.msg('hello');
//         });
//     });
    //创建按钮使用
    $("a[class='create_btn']").click(function () {
        $("div[class='mymusic_create']").css("display", "inline");
        $("div[class='control']").css("display", "inline")
    });
    $("span[class='cre_close']").click(function () {
        $("div[class='mymusic_create']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    $("button[name='dbtn']").click(function () {
        $("div[class='mymusic_create']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    //新建歌单
    $("button[name='nbtn']").click(function () {
        var songListId = 0;
        $.ajax({
            url:"/MyMusic/createSonglist",
            type:"post",
            data: {
                songListName:$("input[class='cre_text']").val(),
            },
            dataType:"json",
            success:function (data) {
                if(data == true){
                    $.ajax({
                        url:"/MyMusic/selectId",
                        type:"post",
                        data:{
                            songListName:$("input[class='cre_text']").val()
                        },
                        dataType:"text",
                        success:function (dd) {
                            songListId = parseInt(dd);
                            $.ajax({
                                url:"/MyMusic/insertRelation",
                                type:"post",
                                data:{
                                    // songListUserVo:,
                                    songListId:songListId,
                                    userId:5,
                                    usRelation:1
                                },
                                dataType:"json",
                                success:function (data) {
                                    if(data==true){
                                        layui.use('layer', function () {
                                            var layer = layui.layer;
                                            layer.msg('成功创建歌单！');
                                        });
                                        setTimeout("window.location.reload()","1000");
                                    }
                                }
                            });
                        }
                    })
                }
            }
        })


    });
});