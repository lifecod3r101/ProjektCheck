package com.y4.projektcheck.Presenters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.y4.projektcheck.Misc.Constants;

public class PlayerEmailSignUpPresenter {
    private EmailSignUpView emailSignUpView;


    public PlayerEmailSignUpPresenter(EmailSignUpView emailSignUpView) {
        this.emailSignUpView = emailSignUpView;
    }

    public PlayerEmailSignUpPresenter() {
    }


    public void readSaveEmailAddress(String emailAddress) {
        if (!emailAddress.isEmpty()) {
            ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder().setUrl("https://checker-bit64.firebaseapp.com/verify?uid=".concat(String.valueOf(1000))).setAndroidPackageName("com.y4.projektcheck", true, null).setHandleCodeInApp(true).build();
            Constants.getFirebaseAuth().sendSignInLinkToEmail(emailAddress, actionCodeSettings).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    emailSignUpView.showSuccess(emailAddress, task);
                }
            });
        }
    }


    public interface EmailSignUpView {
        void checkEmailEmptyOrValid(String playerEmailAddress);

        void showSuccess(String emailAddressAuth, Task<Void> task);
    }

    public void emailAddressIsEmptyOrNotEmail(String playerEmailAddress) {
        emailSignUpView.checkEmailEmptyOrValid(playerEmailAddress);
    }
}