$(function () {
    //获取url值
    var url = location.search,
        songListId = {};
    //如果url有id
    if(url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i++) {
            songListId[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    //
    // console.log('传过来的参数是:', songListId.songListId);
    // alert( songListId.songListId);
    var ss = new Vue({
        el: "#songVue",
        data: {
            songSet: []
        },
        methods: {
            getSongSet: function () {
                ss.songSet = [];
                $.ajax({
                    url: "/MyMusic/songlist/songshow",
                    type: "post",
                    data: {
                        songListId: songListId.songListId
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                ss.songSet.push({
                                    songName: data[i].songName,
                                    songDuration: data[i].songDuration,
                                    singerName: data[i].singerName,
                                    albumName: data[i].album.albumName
                                });
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                });
            }
        }
    });
    var sinfo = new Vue({
        el: "#songInfo",
        data: {
            songCount: "",
            songPlayCount: ""
        },
        methods: {
            getSongCount: function () {
                sinfo.songCount;
                $.ajax({
                    url: "/MyMusic/songlist/countshow",
                    type: "post",
                    data: {songListId: songListId.songListId},
                    dataType: "json",
                    success: function (data) {
                        songCount = data;
                    }
                })
            },
            getSongPlayCount: function () {
                sinfo.songPlayCount;
                $.ajax({
                    url: "/MyMusic/songlist/playcountshow",
                    type: "post",
                    data: {songListId: songListId.songListId},
                    dataType: "json",
                    success: function (data) {
                        songPlayCount = data;
                    }
                })
            }
        }
    });
    var comment = new Vue({
        el: "#songComment",
        data: {
            awComment:[],
            commentList: [],
            userHeadUrl1:""
        },
        methods: {
            getComment: function () {
                comment.commentList = [];
                $.ajax({
                    url: "/MyMusic/songlist/showComment",
                    type: "post",
                    data: {
                        songListId: songListId.songListId
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            comment.commentList = data;
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            },
            //查询当前登录用户的头像
            getPic:function () {
                $.ajax({
                    url:"/MyMusic/showSonglistInfo",
                    type:"post",
                    data:{
                        songListId: songListId.songListId,
                        userId:5
                    },
                    dataType:"json",
                    success:function (data) {
                        comment.userHeadUrl1=data.usersSet[0].userHeadUrl;
                    }
                })
            },
            getAwComment:function () {
                comment.awComment = [];
                $.ajax({
                    url:"/MyMusic/songlist/awComment",
                    type:"post",
                    data:{
                        songListId: songListId.songListId
                    },
                    dataType:"json",
                    success:function (data) {
                        if (data.length > 0) {
                            comment.awComment = data;
                        } else {
                        }
                    }
                })
            },
            dianzanAw:function (songlcId,index) {
                $.ajax({
                    url:"/MyMusic/dianzan",
                    type:"post",
                    data:{
                        songlcId:songlcId
                    },
                    dataType:"json",
                    success:function (data) {
                        if(data==1){
                            comment.awComment[index].songlcLikes =  comment.awComment[index].songlcLikes +1;
                        }
                    }
                })
            },
            dianzan:function (songlcId,index) {
                $.ajax({
                    url:"/MyMusic/dianzan",
                    type:"post",
                    data:{
                        songlcId:songlcId
                    },
                    dataType:"json",
                    success:function (data) {
                        if(data==1){
                            comment.commentList[index].songlcLikes+=1;
                        }
                    }
                })
            }
        },
        filters: {
            formatDate:function(val) {
                var value=new Date(val);
                var year=value.getFullYear();
                var month=padDate(value.getMonth()+1);
                var day=padDate(value.getDate());
                var hour=padDate(value.getHours());
                var minutes=padDate(value.getMinutes());
                var seconds=padDate(value.getSeconds());
                return year+'-'+month+'-'+day+' '+hour+':'+minutes+':'+seconds;
            }
        },
    });
    var songList = new Vue({
        el: "#listInfo",
        data: {
            songlistId:"",
            songlistName: "",
            songlistCreateTime: "",
            songlistPicUrl: "",
            songlistDescription:"",
            songlistTag:[],
            userName: "",
            userHeadUrl: "",
            url:""
            // listMsg:[]
        },
        methods: {
            getListInfo: function () {
                // songList.listMsg=[];
                $.ajax({
                    url: "/MyMusic/showSonglistInfo",
                    type: "post",
                    data: {
                        songListId: songListId.songListId,
                        userId: 5
                    },
                    dataType: "json",
                    success: function (data) {
                        songList.songlistId=data.songlistId;
                        songList.songlistName=data.songlistName;
                        songList.songlistCreateTime=data.songlistCreateTime;
                        songList.songlistPicUrl=data.songlistPicUrl;
                        songList.songlistDescription=data.songlistDescription;
                        if(data.songlistTag!=null)
                            songList.songlistTag=data.songlistTag.split(" ");
                        songList.userName=data.usersSet[0].userName;
                        songList.userHeadUrl=data.usersSet[0].userHeadUrl
                    }
                });
            },
            goToEdit:function (songlistId) {
                songList.url= 'MyMusic_edit.html' + '?songListId=' + escape(songlistId);
            }
        },
        filters: {
            formatDate:function(val) {
                var value=new Date(val);
                var year=value.getFullYear();
                var month=padDate(value.getMonth()+1);
                var day=padDate(value.getDate());
                var hour=padDate(value.getHours());
                var minutes=padDate(value.getMinutes());
                var seconds=padDate(value.getSeconds());
                return year+'-'+month+'-'+day+' '+hour+':'+minutes+':'+seconds;
            }
        },
    });
    ss.getSongSet();
    sinfo.getSongCount();
    sinfo.getSongPlayCount();
    comment.getComment();
    comment.getPic();
    comment.getAwComment();
    songList.getListInfo();
    //富文本
    // var E = window.wangEditor;
    // var editor = new E('#editPic', '#editText');
    // // editor.customConfig.uploadImgShowBase64 = true;
    // // editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
    //
    // editor.customConfig.menus = [
    //     'emoticon' // 表情
    // ];
    $("#msg_send").click(function () {
       $.ajax({
           url:"/MyMusic/songlist/insert",
           type:"post",
           data:{
               songlistId: songListId.songListId,
               songlcText:$("textarea[class='msg_info']").val(),
               userId:5
           },
           dataType:"json",
           success:function (data) {
               if(data==1){
                   layui.use('layer', function () {
                       var layer = layui.layer;
                       layer.msg('评论成功！');
                   });
                   setTimeout("window.location.reload()","1000");
               }
           }
       })
    });
});
var padDate=function(va){
    va=va<10?'0'+va:va;
    return va
};