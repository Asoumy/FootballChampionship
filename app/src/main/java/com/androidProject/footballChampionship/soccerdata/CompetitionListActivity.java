package com.androidProject.footballChampionship.soccerdata;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import com.project.footballdata.api.api.FootballData;
import com.project.footballdata.api.models.Competition;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CompetitionListActivity extends ListActivity {


    private FootballData footballData;
    private List<Competition> competitions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        footballData = FootballData.getInstance();
        loadData();
    }

    private void loadData() {
        footballData.competitions().enqueue(new Callback<List<Competition>>() {
            @Override
            public void onResponse(Call<List<Competition>> call, Response<List<Competition>> response) {
                competitions = response.body();
                showData();
            }

            @Override
            public void onFailure(Call<List<Competition>> call, Throwable t) {

            }
        });
    }

    private void showData() {
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, competitions));
    }
}
