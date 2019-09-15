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
        el:"#editVue",
        data:{
            songlistName:"",
            songlistPicUrl:"",
            songlistDescription:""
        },
        methods:{
            getSongListInfo:function () {
                $.ajax({
                    url: "/MyMusic/showSonglistInfo",
                    type: "post",
                    data: {
                        songListId:songListId.songListId,
                        userId: 5
                    },
                    dataType: "json",
                    success: function (data) {
                        editInfo.songlistName=data.songlistName;
                        editInfo.songlistPicUrl=data.songlistPicUrl;
                        editInfo.songlistDescription=data.songlistDescription
                    }
                })
            }
        }
    });
    editInfo.getSongListInfo();

});