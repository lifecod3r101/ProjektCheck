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

public class PlayerProfileInteractor implements CheckerInterfaceHolder.ShowUserInfoViewOperations {
    private Constants constants = new Constants();

    @Override
    public void showLoggedInUser() {
        constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot snapshot = task.getResult();
                    if (snapshot.exists()) {
                        Player player = snapshot.toObject(Player.class);
                    }
                }
            }
        });
    }
}
