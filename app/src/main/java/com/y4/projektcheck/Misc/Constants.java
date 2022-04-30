package com.y4.projektcheck.Misc;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Constants {
    private static final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    public static FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public FirebaseFirestore getFirebaseFirestore() {
        return firebaseFirestore;
    }
}
