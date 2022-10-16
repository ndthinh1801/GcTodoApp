package com.example.gctodoapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gctodoapp.executor.AppExecutors;
import com.example.messagelibrary.util.StringUtil;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private AppExecutors mAppExecutor;

    @Inject
    MainViewModel(AppExecutors appExecutor) {
        mAppExecutor = appExecutor;
    }

    private MutableLiveData<String> _messageLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getMessageLiveData() {
        return _messageLiveData;
    }

    private MutableLiveData<Boolean> _loadingLiveData = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLoadingLiveData() {
        return _loadingLiveData;
    }

    public void analyseMessage(String message) {
        _loadingLiveData.setValue(true);
        mAppExecutor.diskIO().execute(() -> {
            _loadingLiveData.postValue(false);
            String jsonResult = StringUtil.splitMessageToJson(message);
            if (!jsonResult.isEmpty()) {
                _messageLiveData.postValue(jsonResult);
            }
        });
    }
}
