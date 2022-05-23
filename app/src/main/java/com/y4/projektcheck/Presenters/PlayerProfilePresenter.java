package com.y4.projektcheck.Presenters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.Player;

public class PlayerProfilePresenter implements CheckerInterfaceHolder.PlayerProfileOperations {
    private Constants constants = new Constants();
    private PlayerProfileView playerProfileView;

    public PlayerProfilePresenter() {

    }

    public PlayerProfilePresenter(PlayerProfileView playerProfileView, FirebaseUser firebaseUser) {
        this.playerProfileView = playerProfileView;
        showLoggedInUser(firebaseUser);
    }

    @Override
    public void showLoggedInUser(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            constants.getFirebaseFirestore().collection("Player").document(firebaseUser.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot snapshot = task.getResult();
                        if (snapshot.exists()) {
                            Player player = snapshot.toObject(Player.class);
                            playerProfileView.getLoggedInUserInfo(player);
                        }
                    }
                }
            });
        }
    }

    public interface PlayerProfileView {
        void getLoggedInUserInfo(Player player);
    }
}
