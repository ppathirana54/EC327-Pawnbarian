package com.example.pawnbarianmockup.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Credits:\nPriyan Pathirana\nAndrew Chen\nJaden Cho\nBenyamin Trachtenberg");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
