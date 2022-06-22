package com.y4.projektcheck.Presenters;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.firestore.DocumentSnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Models.UserName;

import java.util.Objects;

public class PlayerSignUpPresenter implements CheckerInterfaceHolder.RecogniseUser, CheckerInterfaceHolder.GetUserInfoViewOperations {
    private Player player;
    private SignUpProcessView signUpProcessView;
    private Constants constants = new Constants();

    public PlayerSignUpPresenter() {

    }

    public PlayerSignUpPresenter(SignUpProcessView signUpProcessView) {
        this.player = new Player();
        this.signUpProcessView = signUpProcessView;
    }

    @Override
    public void getFirebaseSignInLink(Intent intent, String emailGet) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener(new OnSuccessListener<PendingDynamicLinkData>() {
            @Override
            public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                Uri signUpLink = null;
                if (pendingDynamicLinkData != null) {
                    signUpLink = pendingDynamicLinkData.getLink();
                } else {

                }
                if (signUpLink != null) {
                    String verifyEmailLink = intent.getData().toString();
                    if (Constants.getFirebaseAuth().isSignInWithEmailLink(verifyEmailLink)) {
                        if (emailGet != null) {
                            try {
                                Constants.getFirebaseAuth().signInWithEmailLink(emailGet, verifyEmailLink).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            AuthResult authResult = task.getResult();
                                            if (authResult.getAdditionalUserInfo().isNewUser()) {
                                                writeUserInformation(emailGet);
                                            }
                                            if (authResult.getUser().isEmailVerified()) {
                                                readExistingUserInformation(authResult.getUser().getUid());
                                            } else {

                                            }
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {

                    }
                }
            }
        });
    }

    @Override
    public void readExistingUserInformation(String userId) {
        constants.getFirebaseFirestore().collection("Player").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult();
                    if (snapshot.exists()) {
                        String userName = snapshot.getString("playerUserName");
                        if (!Objects.requireNonNull(userName).isEmpty()) {
                            signUpProcessView.checkPlayerExists(task.getResult().exists());
                        } else {

                        }
                    }
                }
            }
        });
    }

    @Override
    public void writeUserInformation(String emailAddress) {
        Player player = new Player();
        player.setPlayerUserId(Constants.getFirebaseAuth().getCurrentUser().getUid());
        player.setPlayerUserName("");
        player.setPlayerEmailAddress(emailAddress);
        player.setMatchesPlayed(0);
        player.setPlayerWins(0);
        player.setPlayerDraws(0);
        player.setPlayerLosses(0);
        player.setPlayerCumScore(0);
        player.setAvailable(false);
        player.setInSession(false);
        constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).set(player).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }

    @Override
    public void signUpLoginUser(String playerUserName) {
        UserName userName = new UserName();
        userName.setUserId(Constants.getFirebaseAuth().getCurrentUser().getUid());
        constants.getFirebaseFirestore().collection("UserName").document(playerUserName).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult();
                    if (snapshot.exists()) {
                        signUpProcessView.checkUserNameTaken(true, playerUserName);
                    } else {
                        signUpProcessView.checkUserNameTaken(false, playerUserName);
                        constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).update("available", true, "playerUserName", playerUserName).addOnCompleteListener(new OnCompleteListener<Void>() {
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

    public interface SignUpProcessView {
        void checkUserNameEmpty(String playerUserName);

        void checkUserNameTaken(boolean snapshotExists, String userName);

        void checkPlayerExists(boolean exists);
    }

    public void checkIfUserNameEmpty(String playerUserName) {
        signUpProcessView.checkUserNameEmpty(playerUserName);
    }

    public void getPlayerUserName(String playerUserName) {
        signUpLoginUser(playerUserName);
    }
}