package com.y4.projektcheck.Interfaces;

import android.content.Intent;

import com.google.firebase.auth.FirebaseUser;
import com.y4.projektcheck.Models.Player;

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

        void createSession(String hostPlayerId);

    }

    interface GameSessionRequestOperations {
        void showAvailableSessions();

        void requestToPlaySession(String hostPlayerId);

        void acceptRequest(String requestedSessionId, String hostPlayerId, String joiningPlayerId);

        void removeSession(String hostPlayerId, String requestedSessionId);
    }


    interface PlayerProfileOperations {
        void showLoggedInUser(FirebaseUser firebaseUser);
    }

    interface GameSessionOperations {
        void getPlayerMove();

        void recordScore();
    }


}
