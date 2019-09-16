//我的音乐js文件
$(function () {
    //vue使用
    var song = new Vue({
        el:"#songList",
        data:{
            likeSongList:[],
            shouSongList:[],
            url:"",
            eurl:"",
            songListId:""
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
            },
            goToE:function (songListId) {
                song.eurl= 'MyMusic_edit.html' + '?songListId=' + escape(songListId);
                // alert(song.eurl)
            },
            getSongListId:function(songListId){
                song.songListId = songListId;
                // alert(songListId)
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
    //创建按钮使用

    $("a[class='create_btn']").click(function () {
        $("div[class='mymusic_create']").css("display", "inline");
        $("div[class='control']").css("display", "inline")
    });
    $("span[name='cre_end']").click(function () {
        $("div[class='mymusic_create']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    $("button[name='dbtn']").click(function () {
        $("div[class='mymusic_create']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    //删除按钮使用
    //在 jquery中，如果需要进行动态添加元素，并且添加的元素要具有动态绑定事件的效果，那么可以把元素的绑定事件交给父元素或者body元素来实现
    $('body').on('click',"a[name='del_sl']",function(){
        $("div[class='mymusic_del']").css("display", "inline");
        $("div[class='control']").css("display", "inline")
    }) ;
    // $("a[name='del_sl']").click(function () {
    //     $("div[class='mymusic_del']").css("display", "inline");
    //     $("div[class='control']").css("display", "inline")
    // });
    $("span[name='del_end']").click(function () {
        $("div[class='mymusic_del']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    $("button[name='del_btn']").click(function () {
        $("div[class='mymusic_del']").css("display", "none");
        $("div[class='control']").css("display", "none")
    });
    //删除歌单
    $("button[name='confirm_btn']").click(function () {
        $.ajax({
            url:"/MyMusic/deleteSonglist",
            type:"post",
            data:{
                songListId:song.songListId
            },
            dataType:"json",
            success:function (data) {
                if(data == 1){
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.msg('成功删除歌单！');
                    });
                    setTimeout("window.location.reload()","1000");
                }else{
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.msg('删除歌单失败！');
                    });
                    setTimeout("window.location.reload()","1000");
                }
            }
        })
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