$(function(){
    var hotSongList = new Vue({
        el: "#hotSongList",
        data: {
            songListSet: [],
            url:""
        },
        methods:{
            sendSongListId:function(SongListId){
                hotSongList.url="my_songList.html"+"?songListId="+escape(SongListId);
            },
            getSongList:function () {
                hotSongList.songListSet = [];
                $.ajax({
                    url: "/index/hotSong/selectEightSongList",
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                hotSongList.songListSet.push({
                                    songListId:data[i].songlistId,
                                    songListName: data[i].songlistName,
                                    songListPicUrl:data[i].songlistPicUrl,
                                });
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            }
        }
    });
    $("span[name='ang']").click(function () {
        alert("11")
    })
    var Leaderboard1 = new Vue({
        el:"#Leaderboard1",
        data:{
            songSet:[],
            url:""
        },
        methods:{
            sendSongId:function(SongId){
                Leaderboard1.url="PlayMusic.html"+"?id="+escape(SongId);
            },
            getSong:function () {
                Leaderboard1.songSet = [];
                $.ajax({
                    url:"Index/playTime/selectSongByPlayTimes",
                    type:"post",
                    dataType :"json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                Leaderboard1.songSet.push({
                                    songId: data[i].songId,
                                    songName: data[i].songName,
                                });
                                // if(i<3)
                                //     $("span[class='no']").css(" color","#c10d0c");
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            }

        }

    });
    var Leaderboard2 = new Vue({
        el:"#Leaderboard2",
        data:{
            songSet:[],
            url:""
        },
        methods:{
            sendSongId:function(SongId){
                Leaderboard2.url="PlayMusic.html"+"?id="+escape(SongId);
            },
            getSong:function () {
                Leaderboard2.songSet = [];
                $.ajax({
                    url:"Index/CreateTime/selectSongByCreateTime",
                    type:"post",
                    dataType :"json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                Leaderboard2.songSet.push({
                                    songId: data[i].songId,
                                    songName: data[i].songName,
                                });
                                // if(i<3)
                                //     $("span[class='no']").css(" color","#c10d0c");
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            }

        }
    });
    var Leaderboard3 = new Vue({
        el:"#Leaderboard3",
        data:{
            songSet:[],
            url:""
        },
        methods:{
            sendSongId:function(SongId){
                Leaderboard3.url="PlayMusic.html"+"?id="+escape(SongId);
            },
            getSong:function () {
                Leaderboard3.songSet = [];
                $.ajax({
                    url:"Index/tenSong/selectTenSong",
                    type:"post",
                    dataType :"json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                Leaderboard3.songSet.push({
                                    songId: data[i].songId,
                                    songName: data[i].songName,
                                });
                                // if(i<3)
                                //     $("span[class='no']").css(" color","#c10d0c");
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            }

        }
    });
    var Album = new Vue({
        el:"#album",
        data:{
            AlbumSet1:[],
            AlbumSet2:[],
            AlbumSet3:[],
            url:""
        },
        methods:{

            getAlbum:function(){
                Album.AlbumSet=[];
                $.ajax({
                    url:"index/albumRecomment/select15Album",
                    type:"post",
                    dataType:"json",
                    success:function(data){
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                if(i>=0&&i<5) {
                                    Album.AlbumSet1.push({
                                        albumId: data[i].albumId,
                                        albumName: data[i].albumName,
                                        albumPicUrl: data[i].albumPicUrl,
                                        singer: data[i].singer
                                    });
                                }
                                else if(i>=5&&i<10){
                                    Album.AlbumSet2.push({
                                        albumId: data[i].albumId,
                                        albumName: data[i].albumName,
                                        albumPicUrl: data[i].albumPicUrl,
                                        singer: data[i].singer
                                    });
                                }
                                else{
                                    Album.AlbumSet3.push({
                                        albumId: data[i].albumId,
                                        albumName: data[i].albumName,
                                        albumPicUrl: data[i].albumPicUrl,
                                        singer: data[i].singer
                                    });
                                }
                                // if(i<3)
                                //     $("span[class='no']").css(" color","#c10d0c");
                            }
                        } else {
                            // alert("表中无记录");
                        }
                    }
                })
            }
        }
    })
    hotSongList.getSongList();
    Leaderboard1.getSong();
    Leaderboard2.getSong();
    Leaderboard3.getSong();
    Album.getAlbum();
})