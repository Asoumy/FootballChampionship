package com.androidProject.footballChampionship.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidProject.footballChampionship.R;
import com.androidProject.footballChampionship.model.ModelUser;
import com.androidProject.footballChampionship.viewmodel.MainViewModel;
import com.androidProject.footballChampionship.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_USER = "extra_user";

    ActivityMainBinding binding;
    MainViewModel viewModel;

    public static Intent newIntent(Context context, ModelUser user){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        GET USER DATA
        ModelUser user = getIntent().getParcelableExtra(EXTRA_USER);

        viewModel = new MainViewModel(this, user);
        binding.setViewmodel(viewModel);
    }
}
