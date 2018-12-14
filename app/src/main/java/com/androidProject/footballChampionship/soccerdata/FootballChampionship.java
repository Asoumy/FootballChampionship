package com.androidProject.footballChampionship.soccerdata;

import android.app.Application;

import com.project.footballdata.api.api.FootballData;

public class FootballChampionship extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

         FootballData.setApiKey("af484c207192455d8b5fbe28eb03a35c");
    }
}
