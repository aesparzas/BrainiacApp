package com.esparperez.brainiacapp.game;

import android.util.Log;

import com.esparperez.brainiacapp.data.repositories.ApiUtils;
import com.esparperez.brainiacapp.data.repositories.MusicService;
import com.esparperez.brainiacapp.data.repositories.pojos.MusicResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataResult {

    private Question question;

    public DataResult() {}

    public void loadAnimeData() {

    }

    public void loadBookData() {

    }

    public void loadMovieData() {

    }

    public void loadMusicData() {

        ArrayList<MusicResult.TrackList> animeList = null;
        ArrayList<MusicResult.TrackList> bookList = null;
        ArrayList<MusicResult.TrackList> movieList = null;
        ArrayList<MusicResult.TrackList> tvList = null;

        MusicService service = ApiUtils.getMusicService();
        Call<MusicResult> call = service.getTopMusic();
        call.enqueue(new Callback<MusicResult>() {
            @Override
            public void onResponse(Call<MusicResult> call, Response<MusicResult> response) {
                if (response.isSuccessful()){
                    ArrayList<MusicResult.TrackList> musicList
                            = new ArrayList<>(response.body().getMessage().getBody().getTrackList());
                    setupQuestion(musicList);
                    Log.e("INTERACTOR", "OK");
                }
            }

            @Override
            public void onFailure(Call<MusicResult> call, Throwable t) {
                Log.e("INTERACTOR", t.getMessage());
            }
        });
    }

    public void loadTvData() {

    }

    private void setupQuestion(ArrayList<MusicResult.TrackList> trackList) {

        int typeQuestion = (int) (Math.random() * 4) + 1;
        int answer = (int) (Math.random() * 4) + 1;
        String trackName;
        String artistName;
        String albumName;
        String genreName;

        question = new Question();

        switch (typeQuestion) {
            // trackName
            case 1:
                question.setQuestion("Es una canción de este Artista: "
                        + trackList.get(answer).getTrack().getArtistName());
                question.setFirstOption(trackList.get(0).getTrack().getTrackName());
                question.setSecondOption(trackList.get(1).getTrack().getTrackName());
                question.setThirdOption(trackList.get(2).getTrack().getTrackName());
                question.setFourthOption(trackList.get(3).getTrack().getTrackName());
                question.setAnswer(trackList.get(answer).getTrack().getTrackName());
                break;
            // artistName
            case 2:
                question.setQuestion("Es una canción de este Artista: "
                        + trackList.get(answer).getTrack().getArtistName());
                question.setFirstOption(trackList.get(0).getTrack().getTrackName());
                question.setSecondOption(trackList.get(1).getTrack().getTrackName());
                question.setThirdOption(trackList.get(2).getTrack().getTrackName());
                question.setFourthOption(trackList.get(3).getTrack().getTrackName());
                question.setAnswer(trackList.get(answer).getTrack().getTrackName());
                break;
            // albumName
            case 3:
                question.setQuestion("Es una canción de este Artista: "
                        + trackList.get(answer).getTrack().getArtistName());
                question.setFirstOption(trackList.get(0).getTrack().getTrackName());
                question.setSecondOption(trackList.get(1).getTrack().getTrackName());
                question.setThirdOption(trackList.get(2).getTrack().getTrackName());
                question.setFourthOption(trackList.get(3).getTrack().getTrackName());
                question.setAnswer(trackList.get(answer).getTrack().getTrackName());
                break;
            // genreName
            case 4:
                question.setQuestion("Es una canción de este Artista: "
                        + trackList.get(answer).getTrack().getArtistName());
                question.setFirstOption(trackList.get(0).getTrack().getTrackName());
                question.setSecondOption(trackList.get(1).getTrack().getTrackName());
                question.setThirdOption(trackList.get(2).getTrack().getTrackName());
                question.setFourthOption(trackList.get(3).getTrack().getTrackName());
                question.setAnswer(trackList.get(answer).getTrack().getTrackName());
                break;
        }
    }

    public Question getQuestion() {
        return question;
    }
}
