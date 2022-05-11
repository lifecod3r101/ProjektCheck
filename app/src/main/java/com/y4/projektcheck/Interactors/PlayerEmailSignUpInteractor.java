package com.y4.projektcheck.Interactors;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Presenters.PlayerEmailSignUpPresenter;

import java.util.Random;

public class PlayerEmailSignUpInteractor implements CheckerInterfaceHolder.RecogniseUser {
    private PlayerEmailSignUpPresenter playerEmailSignUpPresenter = new PlayerEmailSignUpPresenter();
    private int minInt = 1000;
    private Random random = new Random();
    private int maxInt = random.nextInt(Integer.MAX_VALUE - minInt) + minInt;
    private String emailAddressAuth;

    public void getEmailAddress(String playerEmailAddress) {
        emailAddressAuth = playerEmailAddress;
    }

    @Override
    public void firebaseSignUpAuth() {
        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder().setUrl("https://projektcheck.page.link/verify?uid=".concat(String.valueOf(maxInt))).setAndroidPackageName("com.y4.projektcheck", true, null).setHandleCodeInApp(true).setDynamicLinkDomain("projektcheck.page.link").build();
        Constants.getFirebaseAuth().sendSignInLinkToEmail(emailAddressAuth, actionCodeSettings).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    playerEmailSignUpPresenter.checkResultSuccess(task.isSuccessful(), task);
                } else {
                    playerEmailSignUpPresenter.checkResultSuccess(!task.isSuccessful(), task);
                }
            }
        });
    }
}
