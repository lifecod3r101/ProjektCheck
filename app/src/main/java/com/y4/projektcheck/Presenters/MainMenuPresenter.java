package com.y4.projektcheck.Presenters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Views.MainMenuActivity;

import java.util.HashMap;
import java.util.Map;

public class MainMenuPresenter implements CheckerInterfaceHolder.MainMenuOperations {
    private GameSession gameSession = new GameSession();
    private Constants constants = new Constants();
    private MainMenuView mainMenuView;
    private MainMenuActivity mainMenuActivity = new MainMenuActivity();
    private boolean sessionExists;


    public boolean isSessionExists() {
        return sessionExists;
    }

    public void setSessionExists(boolean sessionExists) {
        this.sessionExists = sessionExists;
    }

    public MainMenuPresenter() {

    }

    public MainMenuPresenter(MainMenuView mainMenuView, FirebaseUser firebaseUser) {
        this.mainMenuView = mainMenuView;
        getUserInformation(firebaseUser);
    }

    public interface MainMenuView {
        void userInformation(Player player);

        void userExists(FirebaseUser firebaseUser, String action, String extraAction);

        void userExists(FirebaseUser firebaseUser, String action, String extraAction, boolean sessionExists);
    }

    public void checkUserExists(FirebaseUser firebaseUser, String action, String extraAction) {
        mainMenuView.userExists(firebaseUser, action, extraAction, isSessionExists());
    }

    @Override
    public void getUserInformation(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot snapshot = task.getResult();
                        if (snapshot.exists()) {
                            Player player = snapshot.toObject(Player.class);
                            mainMenuView.userInformation(player);
                        }
                    }
                }
            });
            Query query = constants.getFirebaseFirestore().collection("Player").document(Constants.getFirebaseAuth().getCurrentUser().getUid()).collection("GameSession");
            query.whereEqualTo("gameSessionPlayers.Player1", firebaseUser.getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                            if (documentSnapshot.exists()) {
                                setSessionExists(true);
                            } else {
                                setSessionExists(false);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public void createSession(String hostPlayerId) {
        gameSession = new GameSession();
        Map<String, Object> playingPlayers = new HashMap<>();
        playingPlayers.put("Player1", hostPlayerId);
        playingPlayers.put("Player2", "");
        gameSession.setGameSessionPlayers(playingPlayers);
        Map<String, Integer> sessionMoves = new HashMap<>();
        playingPlayers.put("Player1Played", 0);
        playingPlayers.put("Player1Reflected", 0);
        playingPlayers.put("Player2Played", 0);
        playingPlayers.put("Player2Reflected", 0);
        gameSession.setGameSessionPlayerMoves(sessionMoves);
        gameSession.setPlayerFound(false);
        String sessionId = constants.getFirebaseFirestore().collection("Player").document(hostPlayerId).collection("GameSession").document().getId();
        gameSession.setGameSessionId(sessionId);
        constants.getFirebaseFirestore().collection("Player").document(hostPlayerId).collection("GameSession").document(sessionId).set(gameSession).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
        mainMenuActivity.setSessionId(sessionId);
    }
}