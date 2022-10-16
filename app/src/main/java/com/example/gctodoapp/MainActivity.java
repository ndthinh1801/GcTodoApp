package com.example.gctodoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gctodoapp.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initView();
    }

    private void initView() {
        binding.swipeRefresh.setEnabled(false);
        binding.analyseBtn.setOnClickListener(view -> {
            String message = binding.messageEdt.getText().toString();
            if (!message.isEmpty()) {
                viewModel.analyseMessage(message);
            }
        });
        viewModel.getMessageLiveData().observe(this, json -> {
            binding.resultTv.setText(json);
        });
        viewModel.getLoadingLiveData().observe(this, this::setLoading);
    }

    public void setLoading(boolean isShowing) {
        if (binding.swipeRefresh.isRefreshing() != isShowing) {
            binding.swipeRefresh.setRefreshing(isShowing);
        }
    }
}