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
                                    albumName:data[i].albumName
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
    ss.getSongSet();

});