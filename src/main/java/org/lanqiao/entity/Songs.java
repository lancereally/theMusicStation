package org.lanqiao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "songs")
public class Songs {

    @Id
    @Indexed
    private int id;
    @Indexed
    private String songName;
    @Indexed
    private String singerName;
    @Indexed
    private String songDuration;
    @Indexed
    private String albumName;

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }

        if(getClass() != o.getClass()){
            return false;
        }
        Songs songs = (Songs) o;
        if(!songName.equals(songs.songName)){
            return false;
        }
        if(!songDuration.equals(songs.songDuration)){
            return false;
        }
        if(!albumName.equals(songs.albumName)){
            return false;
        }
        if(!singerName.equals(songs.singerName)){
            return false;
        }
        return true;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }



    @Override
    public int hashCode() {
        return 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
