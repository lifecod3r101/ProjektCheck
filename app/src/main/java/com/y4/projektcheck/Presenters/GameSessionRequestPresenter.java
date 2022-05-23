package com.y4.projektcheck.Presenters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.GameSession;

import java.util.HashMap;
import java.util.Map;

public class GameSessionRequestPresenter implements CheckerInterfaceHolder.GameSessionRequestOperations {
    private PlayersView playersView;
    private GameSession gameSession;
    private Constants constants = new Constants();
    private DocumentSnapshot lastSnap;
    private String requestingPlayerId, requestedPlayerId;
    private boolean isNotAvailable;

    public GameSessionRequestPresenter() {
    }

    public GameSessionRequestPresenter(PlayersView playersView) {
        this.gameSession = new GameSession();
        this.playersView = playersView;
        showAvailableSessions();
    }


    @Override
    public void showAvailableSessions() {
        Query query = null;
        if (lastSnap != null) {
            query = constants.getFirebaseFirestore().collectionGroup("GameSession").whereEqualTo("playerFound", false).whereNotEqualTo("gameSessionPlayers.Player1", Constants.getFirebaseAuth().getCurrentUser().getUid()).startAfter(lastSnap);
        } else {
            query = constants.getFirebaseFirestore().collectionGroup("GameSession").whereEqualTo("playerFound", false).whereNotEqualTo("gameSessionPlayers.Player1", Constants.getFirebaseAuth().getCurrentUser().getUid());
        }
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot snapshot : task.getResult()) {
                        GameSession gameSession = snapshot.toObject(GameSession.class);
                        if (task.getResult().isEmpty()) {
                            playersView.getSessionsAvailable(gameSession, true);
                        } else {
                            playersView.getSessionsAvailable(gameSession, true);
                        }
                    }
                    if (task.getResult().size() != 0) {
                        lastSnap = task.getResult().getDocuments().get(task.getResult().size() - 1);
                    }
                }
            }
        });
    }

    @Override
    public void requestToPlaySession(String hostPlayerId) {

    }


    @Override
    public void acceptRequest(String requestedSessionId, String hostPlayerId, String joiningPlayerId) {
        DocumentReference playerRequestingRef = constants.getFirebaseFirestore().collection("Player").document(joiningPlayerId);
        DocumentReference hostPlayerRef = constants.getFirebaseFirestore().collection("Player").document(hostPlayerId);
        playerRequestingRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
        hostPlayerRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        hostPlayerRef.collection("GameSession").document(requestedSessionId).update("playerFound", true, "gameStartTime", FieldValue.serverTimestamp(), "gameSessionPlayers.Player2", joiningPlayerId).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }

    @Override
    public void removeSession(String hostPlayerId, String createdSessionId) {
        constants.getFirebaseFirestore().collection("Player").document(hostPlayerId).collection("GameSession").document(createdSessionId).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }

    public interface PlayersView {
        void getSessionsAvailable(GameSession gameSession, boolean isNotAvailable);
    }

}
