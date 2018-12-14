package com.androidProject.footballChampionship.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidProject.footballChampionship.R;
import com.androidProject.footballChampionship.databinding.ActivityLoginBinding;
import com.androidProject.footballChampionship.viewmodel.LoginViewModel;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new LoginViewModel(this);
        binding.setViewmodel(viewModel);
    }
}
