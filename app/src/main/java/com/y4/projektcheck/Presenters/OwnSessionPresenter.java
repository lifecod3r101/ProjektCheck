package com.y4.projektcheck.Presenters;

import static com.y4.projektcheck.Views.OwnSessionActivity.sessionIdPass;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.GameSession;

public class OwnSessionPresenter implements CheckerInterfaceHolder.OwnSessionOperations {
    private OwnSessionView ownSessionView;
    private Constants constants = new Constants();
    private String sessionId;
    private ListenerRegistration registration;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public OwnSessionPresenter() {

    }

    public OwnSessionPresenter(OwnSessionView ownSessionView, String ownSessionId) {
        this.ownSessionView = ownSessionView;
        showOwnSession(sessionIdPass);
    }

    @Override
    public void showOwnSession(String ownSessionId) {
        if (Constants.getFirebaseAuth().getCurrentUser() != null) {
            Query query = constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).collection("GameSession");
            query.whereEqualTo("currSessionId", ownSessionId).whereEqualTo("hostTerminate", false).whereEqualTo("playerFound", false).whereEqualTo("gameEnded", false).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot snapshot : task.getResult()) {
                            GameSession gameSession = snapshot.toObject(GameSession.class);
                            ownSessionView.ownSessionInfo(gameSession);
                        }
                    }
                }
            });
            listenForUpdate();
        }
    }

    @Override
    public void listenForUpdate() {
        Query query = constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).collection("GameSession");
        registration = query.whereEqualTo("currSessionId", sessionIdPass).addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("ErrorRead", error.getMessage());
                }
                for (DocumentChange documentChange : value.getDocumentChanges()) {
                    switch (documentChange.getType()) {
                        case ADDED:
                            break;
                        case MODIFIED:
                            if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerFound"))) {
                                ownSessionView.getPlaying(documentChange.getDocument().getString("gameSessionPlayers.Player2UserName"));
                                registration.remove();
                            }
                            break;
                        case REMOVED:
                            break;
                    }
                }
            }
        });
    }

    public interface OwnSessionView {
        void ownSessionInfo(GameSession gameSession);

        void getPlaying(String playerUserName);
    }
}
