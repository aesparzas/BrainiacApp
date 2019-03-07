package com.esparperez.brainiacapp.data.repositories;


import com.esparperez.brainiacapp.data.repositories.pojos.MusicResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.esparperez.brainiacapp.utils.Constants.MUSIXMATCH_API_KEY;

public interface MusicService {
    @GET("chart.tracks.get?chart_name=top&page=1&page_size=5&country=it&f_has_lyrics=1&apikey=" + MUSIXMATCH_API_KEY)
    Call<MusicResult> getTopMusic();
}
