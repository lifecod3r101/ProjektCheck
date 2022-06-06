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
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Transaction;
import com.y4.projektcheck.Interfaces.CheckerInterfaceHolder;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Misc.GameLogic;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.Views.GameSessionActivity;

public class GameSessionPresenter implements CheckerInterfaceHolder.GameSessionOperations {
    private Constants constants = new Constants();
    private GameSessionView gameSessionView;
    private ListenerRegistration listenerRegistration;
    private String gameSessionId, hostId, oppId;
    private GameLogic gameLogic = new GameLogic();
    public static boolean isDisabledForP1, isDisabledForP2;
    public static GameSession session;


    public String getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getOppId() {
        return oppId;
    }

    public void setOppId(String oppId) {
        this.oppId = oppId;
    }

    public GameSessionPresenter() {

    }

    public GameSessionPresenter(GameSessionView gameSessionView, String gameSessionId, String hostId, String oppId) {
        this.gameSessionView = gameSessionView;
        this.gameSessionId = gameSessionId;
        this.hostId = hostId;
        this.oppId = oppId;
        showGameSessionInfo(gameSessionId);
        listenForMoves(gameSessionId);
    }

    public GameSessionPresenter(GameSessionView gameSessionView) {
        this.gameSessionView = gameSessionView;
    }


    @Override
    public void showGameSessionInfo(String gameSessionId) {
        constants.getFirebaseFirestore().collectionGroup("GameSession").whereEqualTo("gameSessionPlayers.Player1", hostId).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        GameSession gameSession = documentSnapshot.toObject(GameSession.class);
                        gameSessionView.gameSessionInfo(gameSession);
                        session = documentSnapshot.toObject(GameSession.class);
                    }
                }
            }
        });
        constants.getFirebaseFirestore().collection("Player").document(hostId).collection("GameSession").document(gameSessionId).update("playerOneTurn", true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    if (GameSessionActivity.otherIntent.hasExtra("playerOne")) {
                        gameSessionView.updateTurn(true);
                    } else if (GameSessionActivity.otherIntent.hasExtra("playerTwo")) {
                        gameSessionView.updateTurn(false);
                    }
                }
            }
        });
    }

    @Override
    public void getPlayerMove(int currPlayerMove, int oppPlayerMove, int eliminatedPlayerMove, int prevPiecePos) {
        DocumentReference documentReference = constants.getFirebaseFirestore().collection("Player").document(GameSessionActivity.hostIdPass).collection("GameSession").document(GameSessionActivity.sessionIdPass);
        constants.getFirebaseFirestore().runTransaction(new Transaction.Function<Void>() {
            @Nullable
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentSnapshot snapshot = transaction.get(documentReference);
                boolean isPlayerOneTurn = Boolean.TRUE.equals(snapshot.getBoolean("playerOneTurn"));
                boolean isPlayerTwoTurn = Boolean.TRUE.equals(snapshot.getBoolean("playerTwoTurn"));
                if (isPlayerOneTurn) {
                    if (eliminatedPlayerMove > 0) {
                        transaction.update(documentReference, "playerOneTurn", false, "playerTwoTurn", true, "gameSessionPlayerMoves.Player1Played", currPlayerMove, "gameSessionPlayerMoves.Player1Reflected", oppPlayerMove, "gameSessionPlayerMoves.Player2Eliminated", eliminatedPlayerMove, "gameSessionPlayerMoves.Player1Prev", prevPiecePos, "gameSessionAvailableSpaces", FieldValue.arrayRemove(currPlayerMove), "gameSessionAvailableSpaces", FieldValue.arrayUnion(prevPiecePos, gameLogic.reflectPosition(prevPiecePos)), "gameSessionPlayerScores.player1Elimination", FieldValue.increment(5));
                    } else {
                        transaction.update(documentReference, "playerOneTurn", false, "playerTwoTurn", true, "gameSessionPlayerMoves.Player1Played", currPlayerMove, "gameSessionPlayerMoves.Player1Reflected", oppPlayerMove, "gameSessionPlayerMoves.Player2Eliminated", eliminatedPlayerMove, "gameSessionPlayerMoves.Player1Prev", prevPiecePos, "gameSessionAvailableSpaces", FieldValue.arrayRemove(currPlayerMove), "gameSessionAvailableSpaces", FieldValue.arrayUnion(prevPiecePos, gameLogic.reflectPosition(prevPiecePos)));
                    }
                }
                if (isPlayerTwoTurn) {
                    if (eliminatedPlayerMove > 0) {
                        transaction.update(documentReference, "playerOneTurn", true, "playerTwoTurn", false, "gameSessionPlayerMoves.Player2Played", currPlayerMove, "gameSessionPlayerMoves.Player2Reflected", oppPlayerMove, "gameSessionPlayerMoves.Player1Eliminated", eliminatedPlayerMove, "gameSessionPlayerMoves.Player2Prev", prevPiecePos, "gameSessionAvailableSpaces", FieldValue.arrayRemove(currPlayerMove), "gameSessionAvailableSpaces", FieldValue.arrayUnion(prevPiecePos, gameLogic.reflectPosition(prevPiecePos)), "gameSessionPlayerScores.player2Elimination", FieldValue.increment(5));
                    } else {
                        transaction.update(documentReference, "playerOneTurn", true, "playerTwoTurn", false, "gameSessionPlayerMoves.Player2Played", currPlayerMove, "gameSessionPlayerMoves.Player2Reflected", oppPlayerMove, "gameSessionPlayerMoves.Player1Eliminated", eliminatedPlayerMove, "gameSessionPlayerMoves.Player2Prev", prevPiecePos, "gameSessionAvailableSpaces", FieldValue.arrayRemove(currPlayerMove), "gameSessionAvailableSpaces", FieldValue.arrayUnion(prevPiecePos, gameLogic.reflectPosition(prevPiecePos)));
                    }
                }
                return null;
            }
        }).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                }
            }
        });
    }


    @Override
    public void listenForMoves(String gameSessionId) {
        if (GameSessionActivity.otherIntent.hasExtra("playerOne")) {
            Query gameSessionQry = constants.getFirebaseFirestore().collection("Player").document(getHostId()).collection("GameSession");
            listenerRegistration = gameSessionQry.whereEqualTo("gameSessionPlayers.Player1", getHostId()).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (error != null) {
                        Log.e("MoveErrorListen", error.getMessage());
                    }
                    for (DocumentChange documentChange : value.getDocumentChanges()) {
                        session = documentChange.getDocument().toObject(GameSession.class);
                        switch (documentChange.getType()) {
                            case ADDED:
                                break;
                            case MODIFIED:
                                if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerOneTurn"))) {
                                    gameSessionView.reflect(documentChange.getDocument().getLong("gameSessionPlayerMoves.Player2Reflected"), documentChange.getDocument().getLong("gameSessionPlayerMoves.Player2Prev"), documentChange.getDocument().getLong("gameSessionPlayerMoves.Player1Eliminated"), false);
                                    gameSessionView.updateTurn(true);
                                } else if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerTwoTurn"))) {
                                    gameSessionView.updateTurn(false);
                                    isDisabledForP1 = true;
                                }
                                break;
                            case REMOVED:
                                break;
                        }
                    }
                }
            });
        } else if (GameSessionActivity.otherIntent.hasExtra("playerTwo")) {
            Query gameSessionQry = constants.getFirebaseFirestore().collection("Player").document(hostId).collection("GameSession");
            listenerRegistration = gameSessionQry.whereEqualTo("gameSessionPlayers.Player1", hostId).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (error != null) {
                        Log.e("MoveErrorListen", error.getMessage());
                    }
                    for (DocumentChange documentChange : value.getDocumentChanges()) {
                        session = documentChange.getDocument().toObject(GameSession.class);
                        switch (documentChange.getType()) {
                            case ADDED:
                                break;
                            case MODIFIED:
                                if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerTwoTurn"))) {
                                    gameSessionView.reflect(documentChange.getDocument().getLong("gameSessionPlayerMoves.Player1Reflected"), documentChange.getDocument().getLong("gameSessionPlayerMoves.Player1Prev"), documentChange.getDocument().getLong("gameSessionPlayerMoves.Player2Eliminated"), true);
                                    gameSessionView.updateTurn(true);
                                } else if (Boolean.TRUE.equals(documentChange.getDocument().getBoolean("playerOneTurn"))) {
                                    gameSessionView.updateTurn(false);
                                    isDisabledForP2 = true;
                                }
                                break;
                            case REMOVED:
                                break;
                        }
                    }
                }
            });
        }
    }

    @Override
    public void recordScore() {

    }


    public interface GameSessionView {
        void gameSessionInfo(GameSession gameSession);

        void updateTurn(boolean isTurn);

        void reflect(long reflect, long prev, long eliminated, boolean isPlayerOne);
    }
}
