package com.example.quran_online.network;

import com.example.quran_online.response.SurahDetailResponse;
import com.example.quran_online.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("surah")
    Call<SurahResponse> getSurah();

    @GET("sura/{language}/{id}")
    Call<SurahDetailResponse> getSurahDetail(@Path("language")String lan,
                                             @Path("id") int surahId);
}