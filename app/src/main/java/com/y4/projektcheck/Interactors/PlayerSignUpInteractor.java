package com.y4.projektcheck.Interactors;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Models.UserName;
import com.y4.projektcheck.Presenters.PlayerSignUpPresenter;

public class PlayerSignUpInteractor implements CheckerInterfaceHolder.GetUserInfoViewOperations {
    private String playerUserName, playerEmailAddress;
    private PlayerSignUpPresenter playerSignUpPresenter;

    public void getPlayerInfo(Player player) {
        playerUserName = player.getPlayerUserName();
        playerEmailAddress = player.getPlayerEmailAddress();
    }

    @Override
    public void signUpLoginUser() {
        Constants constants = new Constants();
        Player player = new Player();
        UserName userName = new UserName();
        player.setPlayerUserId(Constants.getFirebaseAuth().getCurrentUser().getUid());
        player.setPlayerUserName(playerUserName);
        player.setPlayerEmailAddress(playerEmailAddress);
        player.setMatchesPlayed(0);
        player.setPlayerWins(0);
        player.setPlayerDraws(0);
        player.setPlayerLosses(0);
        player.setPlayerCumScore(0);
        userName.setUserId(Constants.getFirebaseAuth().getCurrentUser().getUid());
        constants.getFirebaseFirestore().collection("UserName").document(playerUserName).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot d = task.getResult();
                    if (d.exists()) {
                        playerSignUpPresenter.userNameExists(playerUserName);
                    } else {
                        constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).set(player).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                }
                            }
                        });
                        constants.getFirebaseFirestore().collection("UserName").document(playerUserName).set(userName).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                }
                            }
                        });

                    }
                }
            }
        });
    }
}
