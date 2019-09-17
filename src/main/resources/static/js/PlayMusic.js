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
                                cover: playSong.songPicUrl,
                                lrc: playSong.songLyric
                            }]
                        });
                        ap.on('play',function () {
                            $("div[class='layui-anim']").trigger("click");
                        })
                    }
                })
            }
        }
    });


    playSong.getSongInfo();



    // ap.on('playing', function () {
    //     console.log("77777")
    // })

});
