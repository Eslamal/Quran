package com.example.quran_online.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quran_online.repositpry.SurahRepo;
import com.example.quran_online.response.SurahResponse;

public class SurahViewModel extends ViewModel {
    private SurahRepo surahRepo;

    public SurahViewModel() {
        surahRepo=new SurahRepo() ;
    }
    public LiveData<SurahResponse>getSurah(){
        return surahRepo.getSurah();
    }
}
