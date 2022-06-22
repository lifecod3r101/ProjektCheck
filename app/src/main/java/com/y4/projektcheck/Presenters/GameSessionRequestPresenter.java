package com.y4.projektcheck.Presenters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.GameSession;

import java.util.Objects;

public class GameSessionRequestPresenter implements CheckerInterfaceHolder.GameSessionRequestOperations {
    private PlayersView playersView;
    private GameSession gameSession;
    private Constants constants = new Constants();
    private DocumentSnapshot lastSnap;
    private ListenerRegistration registration;


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
            query = constants.getFirebaseFirestore().collectionGroup("GameSession").whereEqualTo("playerFound", false).whereEqualTo("gameEnded",false).whereEqualTo("hostTerminate",false).whereNotEqualTo("playerHostId", Constants.getFirebaseAuth().getCurrentUser().getUid()).startAfter(lastSnap);
        } else {
            query = constants.getFirebaseFirestore().collectionGroup("GameSession").whereEqualTo("playerFound", false).whereEqualTo("gameEnded",false).whereEqualTo("hostTerminate",false).whereNotEqualTo("playerHostId", Constants.getFirebaseAuth().getCurrentUser().getUid());
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
                            playersView.getSessionsAvailable(gameSession, false);
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
    public void listenForUpdate(String hostPlayerId, String joiningPlayerId, String gameSessionId) {
        Query gameSessionQuery = constants.getFirebaseFirestore().collection("Player").document(hostPlayerId).collection("GameSession").whereEqualTo("gameSessionPlayers.Player2", Constants.getFirebaseAuth().getCurrentUser().getUid());
        registration = gameSessionQuery.addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.e("ListenError", "onEvent: ".concat(Objects.requireNonNull(error.getMessage())));
                }
                for (DocumentChange documentChange : value.getDocumentChanges()) {
                    switch (documentChange.getType()) {
                        case ADDED:
                            break;
                        case MODIFIED:
                            if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerFound"))) {
                                playersView.getPlaying();
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

    @Override
    public void requestToPlaySession(String hostPlayerId, String joiningPlayerId, String joiningPlayerUserName, String gameSessionId) {
        DocumentReference hostPlayerRef = constants.getFirebaseFirestore().collection("Player").document(hostPlayerId);
        DocumentReference playerRequestingRef = constants.getFirebaseFirestore().collection("Player").document(joiningPlayerId);
        DocumentReference hostPlayerGameRef = constants.getFirebaseFirestore().collection("Player").document(hostPlayerId).collection("GameSession").document(gameSessionId);
        hostPlayerRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        playerRequestingRef.update("available", false, "inSession", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
        hostPlayerGameRef.update("gameSessionPlayers.Player2", joiningPlayerId, "gameSessionPlayers.Player2UserName", joiningPlayerUserName, "playerFound", true, "playerOneColour", "White", "playerTwoColour", "Yellow", "gameStartTime", FieldValue.serverTimestamp(), "gameSessionPlayers.Player2", joiningPlayerId, "playerOneTurn", true, "playerTwoTurn", false, "hostTerminate", false, "oppLeft", false).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        listenForUpdate(hostPlayerId, joiningPlayerId, gameSessionId);
    }


    @Override
    public void acceptRequest(String requestedSessionId, String hostPlayerId, String joiningPlayerId) {

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

        void getPlaying();
    }
}
