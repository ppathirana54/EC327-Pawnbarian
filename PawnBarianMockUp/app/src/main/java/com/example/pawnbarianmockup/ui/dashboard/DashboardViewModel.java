package com.example.pawnbarianmockup.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Instructions:Use corresponding cards below to move, try to stay alive!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}