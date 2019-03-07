package com.esparperez.brainiacapp.data.repositories;

public class ApiUtils {

    public static AnimeService getAnimeService() {
        return RetrofitClient.getInstance().getAnimeClient().create(AnimeService.class);
    }

    public static BookService getBookService() {
        return RetrofitClient.getInstance().getBookClient().create(BookService.class);
    }

    public static MovieService getMovieService() {
        return RetrofitClient.getInstance().getMovieClient().create(MovieService.class);
    }

    public static MusicService getMusicService() {
        return RetrofitClient.getInstance().getMusicClient().create(MusicService.class);
    }

    public static TvService getTvService() {
        return RetrofitClient.getInstance().getTvClient().create(TvService.class);
    }

}
