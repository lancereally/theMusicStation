$(function () {
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
                    type:"post",
                    data:{
                        songListId:1
                    },
                    dataType:"json",
                    success:function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                ss.songSet.push({
                                    songName:data[i].songName,
                                    songDuration:data[i].songDuration,
                                    singerName:data[i].singerName,
                                    albumName:data[i].album.albumName
                                });
                            }
                        } else {
                            alert("表中无记录");
                        }
                    }
                });
            }
        }
    });
    var sinfo = new Vue({
        el: "#songInfo",
        data: {
            songCount:"",
            songPlayCount:""
        },
        methods:{
            getSongCount:function() {
                sinfo.songCount;
                $.ajax({
                    url:"/MyMusic/songlist/countshow",
                    type:"post",
                    data:{songListId:1},
                    dataType:"json",
                    success:function (data) {
                        songCount=data;
                    }
                })
            },
            getSongPlayCount:function () {
                sinfo.songPlayCount;
                $.ajax({
                    url:"/MyMusic/songlist/playcountshow",
                    type:"post",
                    data:{songListId:1},
                    dataType:"json",
                    success:function (data) {
                        songPlayCount=data;
                    }
                })
            }
        }
    });
    ss.getSongSet();
    sinfo.getSongCount();
    sinfo.getSongPlayCount();
});