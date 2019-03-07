package com.esparperez.brainiacapp.data.repositories;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String ANIME_URL = "";
    private static final String BOOK_URL = "";
    private static final String MOVIE_URL = "";
    private static final String MUSIC_URL = "http://api.musixmatch.com/ws/1.1/";
    private static final String TV_URL = "";

    public static RetrofitClient instance = null;

    private static Retrofit animeRetrofit;
    private static Retrofit bookRetrofit;
    private static Retrofit movieRetrofit;
    private static Retrofit musicRetrofit;
    private static Retrofit tvRetrofit;

    /*
     * Se crea una misma instancia de cliente okHttp y GsonConverter para todas las instancias de
     * clientes retrofit para evitar comprometer el rendimiento de la aplicación.
     */
    private OkHttpClient okHttpClient = new OkHttpClient();
    private GsonConverterFactory gsonConverter = GsonConverterFactory.create();

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Retrofit getAnimeClient() {
        if (animeRetrofit == null) {
            animeRetrofit = new Retrofit.Builder()
                    .baseUrl(ANIME_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverter)
                    .build();
        }
        return animeRetrofit;
    }

    public Retrofit getBookClient() {
        if (bookRetrofit == null) {
            bookRetrofit = new Retrofit.Builder()
                    .baseUrl(BOOK_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverter)
                    .build();
        }
        return bookRetrofit;
    }

    public Retrofit getMovieClient() {
        if (movieRetrofit == null) {
            movieRetrofit = new Retrofit.Builder()
                    .baseUrl(MOVIE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverter)
                    .build();
        }
        return movieRetrofit;
    }

    public Retrofit getMusicClient() {
        if (musicRetrofit == null) {
            musicRetrofit = new Retrofit.Builder()
                    .baseUrl(MUSIC_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverter)
                    .build();
        }
        return musicRetrofit;
    }

    public Retrofit getTvClient() {
        if (tvRetrofit == null) {
            tvRetrofit = new Retrofit.Builder()
                    .baseUrl(TV_URL)
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverter)
                    .build();
        }
        return tvRetrofit;
    }
}