package com.y4.projektcheck.Presenters;

import android.util.Patterns;

import com.google.android.gms.tasks.Task;
import com.y4.projektcheck.Interactors.PlayerEmailSignUpInteractor;

public class PlayerEmailSignUpPresenter {
    private final PlayerEmailSignUpInteractor emailSignUpInteractor = new PlayerEmailSignUpInteractor();
    private EmailSignUpView emailSignUpView;
    private String emailAddressAuth;


    public PlayerEmailSignUpPresenter() {

    }

    public PlayerEmailSignUpPresenter(EmailSignUpView emailSignUpView) {
        this.emailSignUpView = emailSignUpView;
    }


    public interface EmailSignUpView {
        void checkEmailEmptyOrValid(Boolean isEmpty, Boolean isNotEmail);

        void showSuccess(Boolean isSuccessful, String emailAddressAuth, Task<Void> task);

    }

    public void readSavePlayerEmailAddress(String playerEmailAddress) {
        emailSignUpInteractor.getEmailAddress(playerEmailAddress);
        emailAddressAuth = playerEmailAddress;
    }

    public void checkResultSuccess(Boolean result, Task<Void> task) {
        if (result) {
            emailSignUpView.showSuccess(true, emailAddressAuth, task);
        } else {
            emailSignUpView.showSuccess(false, emailAddressAuth, task);
        }
    }


    public void emailAddressIsEmptyOrNotEmail(String playerEmailAddress) {
        if (playerEmailAddress.isEmpty()) {
            emailSignUpView.checkEmailEmptyOrValid(true, false);
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(playerEmailAddress).matches()) {
            emailSignUpView.checkEmailEmptyOrValid(false, true);
        }
    }
}
