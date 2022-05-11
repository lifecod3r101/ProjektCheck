package com.y4.projektcheck.Interactors;

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
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Presenters.GameSessionRequestPresenter;

import java.util.HashMap;
import java.util.Map;

public class GameSessionRequestInteractor implements CheckerInterfaceHolder.GameSessionRequestOperations {

    private String requestingPlayerId, requestedPlayerId;
    private GameSessionRequestPresenter gameSessionRequestPresenter = new GameSessionRequestPresenter();
    private Constants constants = new Constants();
    private GameSession gameSession;
    private DocumentSnapshot lastSnap;
    private Player player;

    public void readPlayersIds(String requestingPlayerId, String requestedPlayerId) {
        this.requestingPlayerId = requestingPlayerId;
        this.requestedPlayerId = requestedPlayerId;
    }


    @Override
    public void showAvailablePlayers() {
        Query query = null;
        if (lastSnap != null) {
            query = constants.getFirebaseFirestore().collection("Player").startAfter(lastSnap);
        } else {
            query = constants.getFirebaseFirestore().collection("Player");
        }
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot snapshot : task.getResult()) {
                        Player player = snapshot.toObject(Player.class);
                        gameSessionRequestPresenter.getPlayersAvailable(player);
                    }
                }
            }
        });
    }

    @Override
    public void requestSession() {
        gameSession = new GameSession();
        Map<String, Object> playingPlayers = new HashMap<>();
        playingPlayers.put("Player1", requestingPlayerId);
        playingPlayers.put("Player2", requestedPlayerId);
        gameSession.setGameSessionPlayers(playingPlayers);
        gameSession.setPlayerAccepted(false);
        String sessionId = constants.getFirebaseFirestore().collection("Player").document(requestedPlayerId).collection("GameSession").document().getId();
        constants.getFirebaseFirestore().collection("Player").document(requestedPlayerId).collection("GameSession").document(sessionId).set(gameSession).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        constants.getFirebaseFirestore().collection("Player").document(requestingPlayerId).collection("GameSession").document(sessionId).set(gameSession).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }

    @Override
    public void acceptRequest(String requestedSessionId) {
        DocumentReference playerRequestingRef = constants.getFirebaseFirestore().collection("Player").document(requestingPlayerId);
        DocumentReference playerRequestedRef = constants.getFirebaseFirestore().collection("Player").document(requestedPlayerId);
        playerRequestingRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
        playerRequestingRef.collection("GameSession").document(requestedSessionId).update("playerAccepted", true, "gameStartTime", FieldValue.serverTimestamp()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        playerRequestedRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        playerRequestedRef.collection("GameSession").document(requestedSessionId).update("playerAccepted", true, "gameStartTime", FieldValue.serverTimestamp()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });

    }

    @Override
    public void declineRequest(String requestedSessionId) {
        constants.getFirebaseFirestore().collection("Player").document(requestingPlayerId).collection("GameSession").document(requestedSessionId).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        constants.getFirebaseFirestore().collection("Player").document(requestedPlayerId).collection("GameSession").document(requestedSessionId).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }
}
