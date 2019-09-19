$(function () {
    //获取url值
    var url = location.search,
        songId = {};
    //如果url有id
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            songId[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    //Vue歌曲信息
    var playSong = new Vue({
        el: "#songInfo",
        data: {
            songName: "",
            songLyric: "",
            songUrl: "",
            songPicUrl: "",
            singerName: "",
            albumName: ""
        },
        methods: {
            getSongInfo: function () {
                $.ajax({
                    url: "/MyMusic/songInfo/show",
                    type: "post",
                    data: {songId: songId.songId},
                    dataType: "json",
                    success: function (data) {
                        playSong.songName = data.songName;
                        playSong.songLyric = data.songLyric;
                        playSong.songUrl = data.songUrl;
                        playSong.songPicUrl = data.songPicUrl;
                        playSong.singerName = data.singerName;
                        playSong.albumName = data.album.albumName;
                        const ap = new APlayer({
                            container: document.getElementById('aplayer'),

                            lrcType: 1,
                            audio: [{
                                name: playSong.songName,
                                artist: playSong.singerName,
                                url: playSong.songUrl,
                                lrc: playSong.songLyric
                            }]
                        });
                        var startL =  $("#loopDiv").attr("data-anim");
                        var endL =$("#loopDiv").attr("class");
                        ap.on('play',function () {
                            $("#loopDiv").attr("class",startL);
                        });
                        ap.on('pause',function () {
                            $("#loopDiv").attr("class",endL);
                        })
                        $("#play_btn").click(function () {
                            alert("wai")
                            ap.on('pause', function () {
                                alert("li")
                                console.log('player play');
                            });
                        });
                    }
                })
            }
        }
    });
    //Vue歌曲评论
    var sComment = new Vue({
        el:"#songComment",
        data:{
            awComment:[],
            commentList: [],
            userHeadUrl1:""
        },
        methods:{
            //查询精彩评论
            getSongAwC:function () {
                sComment.awComment=[];
                $.ajax({
                    url:"/PlayMusic/showAwComment",
                    type:"post",
                    data:{
                        songId:songId.songId
                    },
                    dataType:"json",
                    success:function (data) {
                        sComment.awComment=data;
                    }
                })
            },
            //查询全部评论
            getSongComment:function () {
                sComment.commentList=[];
                $.ajax({
                    url:"/PlayMusic/showComment",
                    type:"post",
                    data:{
                        songId:songId.songId
                    },
                    dataType:"json",
                    success:function (data) {
                        sComment.commentList=data;
                    }
                })
            },
            //查询用户头像
            getUserPic:function () {
                $.ajax({
                    url:"/PlayMusic/showUserHead",
                    type:"post",
                    data:{
                        userId:5
                    },
                    dataType:"json",
                    success:function (data) {
                        sComment.userHeadUrl1=data.userHeadUrl;
                    }
                })
            },
            //点赞评论
            likeComment:function (songcId,index) {
                $.ajax({
                    url:"/PlayMusic/addCommentLike",
                    type:"post",
                    data:{
                        songcId:songcId
                    },
                    dataType:"json",
                    success:function (data) {
                        if(data==1){
                            sComment.commentList[index].songcLikes +=1;
                        }
                    }
                })
            },
            //点赞精彩评论
            likeAwComment:function (songcId,index) {
                $.ajax({
                    url:"/PlayMusic/addCommentLike",
                    type:"post",
                    data:{
                        songcId:songcId
                    },
                    dataType:"json",
                    success:function (data) {
                        if(data==1){
                            sComment.awComment[index].songcLikes =  sComment.awComment[index].songcLikes +1;
                        }
                    }
                })
            }
        },
        filters:{
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
        }
    });
    //Vue用户推荐
    var senduser = new Vue({
        el:"#tuijian",
        data:{
            userHeadUrl:[],
            songListDet:[]
        },
        methods: {
            getUserHeadPic:function() {
                senduser.userHeadUrl=[];
                $.ajax({
                    url:"/PlayMusic/likeSong/userShow",
                    type:"post",
                    data:{
                        songId:songId.songId
                    },
                    dataType:"json",
                    success:function (data) {
                        senduser.userHeadUrl=data;
                    }
                })
            },
            getSongListDet:function () {
                senduser.songListDet=[];
                $.ajax({
                    url:"/PlayMusic/show/likeSongList",
                    type:"post",
                    data:{
                        songId:songId.songId
                    },
                    dataType:"json",
                    success:function (data) {
                        senduser.songListDet=data;
                    }
                })
            }
        }
    });
    playSong.getSongInfo();
    sComment.getSongAwC();
    sComment.getSongComment();
    sComment.getUserPic();
    senduser.getUserHeadPic();
    senduser.getSongListDet();
    $("#msg_send").click(function () {
        $.ajax({
            url:"/PlayMusic/insertComment",
            type:"post",
            data:{
                songId: songId.songId,
                songcText:$("textarea[class='msg_info']").val(),
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
    })
});
var padDate=function(va){
    va=va<10?'0'+va:va;
    return va
};
