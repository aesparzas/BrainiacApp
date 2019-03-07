package com.esparperez.brainiacapp.data.repositories.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MusicResult {

    @SerializedName("message")
    @Expose
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public class Message {

        @SerializedName("body")
        @Expose
        private Body body;

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

    public class Body {

        @SerializedName("track_list")
        @Expose
        private ArrayList<TrackList> trackList = null;

        public ArrayList<TrackList> getTrackList() {
            return trackList;
        }

        public void setTrackList(ArrayList<TrackList> trackList) {
            this.trackList = trackList;
        }
    }

    public class TrackList {
        @SerializedName("track")
        @Expose
        private Track track;

        public Track getTrack() {
            return track;
        }

        public void setTrack(Track track) {
            this.track = track;
        }
    }

    public class Track {
        @SerializedName("track_name")
        @Expose
        private String trackName;

        @SerializedName("artist_name")
        @Expose
        private String artistName;

        @SerializedName("album_name")
        @Expose
        private String albumName;

        @SerializedName("music_genre_name")
        @Expose
        private String musicGenreName;

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public String getMusicGenreName() {
            return musicGenreName;
        }

        public void setMusicGenreName(String musicGenreName) {
            this.musicGenreName = musicGenreName;
        }
    }

}