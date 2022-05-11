package com.y4.projektcheck.Interfaces;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.y4.projektcheck.Models.Player;

public interface CheckerInterfaceHolder {
    interface GetUserInfoViewOperations {
        void signUpLoginUser();
    }

    interface RecogniseUser {
        void firebaseSignUpAuth();
    }

    interface GameSessionRequestOperations {
        void showAvailablePlayers();

        void requestSession();

        void acceptRequest(String requestedSessionId);

        void declineRequest(String requestedSessionId);
    }

    interface CheckUserActions {
        void validateInput(String s);

        void validateInput(String s, boolean isEmpty);

        void validateInput(String s, boolean isEmpty, boolean isNotEmail);
    }

    interface ShowUserInfoViewOperations {
        void showLoggedInUser();
    }

    interface GameSessionOperations {
        void getPlayerMove();

        void recordScore();
    }


}
