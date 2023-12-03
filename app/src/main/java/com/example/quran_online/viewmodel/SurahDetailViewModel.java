package com.example.quran_online.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran_online.repositpry.SurahDetailRepo;
import com.example.quran_online.response.SurahDetailResponse;

public class SurahDetailViewModel extends ViewModel {

    public SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel() {
        surahDetailRepo = new SurahDetailRepo();
    }
    public LiveData<SurahDetailResponse> getSurahDetail(String lan , int id){
        return surahDetailRepo.getSurahDetail(lan,id);
    }
}
