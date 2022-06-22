package com.y4.projektcheck.Interfaces;

import android.content.Intent;

import com.google.firebase.auth.FirebaseUser;

public interface CheckerInterfaceHolder {
    interface GetUserInfoViewOperations {
        void readExistingUserInformation(String userId);

        void writeUserInformation(String emailAddress);

        void signUpLoginUser(String playerUserName);
    }

    interface RecogniseUser {
        void getFirebaseSignInLink(Intent intent, String emailGet);
    }

    interface MainMenuOperations {
        void getUserInformation(FirebaseUser firebaseUser);

        void createSession(String hostPlayerId,String hostUserName);

    }

    interface OwnSessionOperations {
        void showOwnSession();

        void listenForUpdate();
    }

    interface GameSessionRequestOperations {
        void showAvailableSessions();

        void requestToPlaySession(String hostPlayerId, String joiningPlayerId, String joiningPlayerUserName,String gameSessionId);

        void listenForUpdate(String hostPlayerId, String joiningPlayerId, String gameSessionId);


        void acceptRequest(String requestedSessionId, String hostPlayerId, String joiningPlayerId);

        void removeSession(String hostPlayerId, String requestedSessionId);
    }


    interface PlayerProfileOperations {
        void showLoggedInUser(FirebaseUser firebaseUser);
    }

    interface GameSessionOperations {
        void showGameSessionInfo(String gameSessionId);

        void updateOnTerminate();

        void updateOnLeave();

        void getPlayerMove(int currPlayerMove, int oppPlayerMove, int eliminatedPlayerMove, int prevPiecePos);

        void listenForMoves(String gameSessionId);

        void gameEnded(String winningPlayerId,String losingPlayerId,long winningPlayerScore, long losingPlayerScore);
    }


}
