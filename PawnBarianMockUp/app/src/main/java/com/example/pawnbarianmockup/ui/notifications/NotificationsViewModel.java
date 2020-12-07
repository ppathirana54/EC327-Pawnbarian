package com.example.pawnbarianmockup.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Instructions:\n\n Click on a card to move the knight like that piece. Then click a square to move to it. " +
                "The energy shows you how many moves you have left this turn and hearts how many lives you have left. " +
                "When you finish your turn, click End Your Turn to let the slime move or respawn. " +
                "Then click Start Your turn to take your next move. If you end your turn next to the slime you will lose a life. " +
                "As the game progresses, you will draw more blank cards, and may draw all blank cards. Good luck!" +
                "\n\n\n\nCredits:\n\nPriyan Pathirana\nAndrew Chen\nJaden Cho\nBenyamin Trachtenberg");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

