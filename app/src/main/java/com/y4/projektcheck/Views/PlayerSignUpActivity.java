package com.y4.projektcheck.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.y4.projektcheck.Presenters.PlayerSignUpPresenter;
import com.y4.projektcheck.R;

public class PlayerSignUpActivity extends AppCompatActivity implements PlayerSignUpPresenter.SignUpProcessView {
    private PlayerSignUpPresenter playerSignUpPresenter;
    private TextInputEditText userNameEditText;
    private MaterialButton confirmInfoButton;
    private SharedPreferences getEmail;
    private String emailGet, userNameGet, extraActionGet;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sign_up_layout);
        userNameEditText = findViewById(R.id.username_sign_up_enter);
        confirmInfoButton = findViewById(R.id.sign_up);
        playerSignUpPresenter = new PlayerSignUpPresenter(PlayerSignUpActivity.this);
        getEmail = getSharedPreferences("emailInfo", MODE_PRIVATE);
        emailGet = getEmail.getString("emailAddress", "");
        extraActionGet = getEmail.getString("extraAction", "");
        playerSignUpPresenter.getFirebaseSignInLink(getIntent(), emailGet);
        confirmInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameGet = userNameEditText.getText().toString();
                playerSignUpPresenter.checkIfUserNameEmpty(userNameGet);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void checkUserNameEmpty(String playerUserName) {
        if (playerUserName.isEmpty()) {
            userNameEditText.setError("Sorry. This is required.");
            userNameEditText.requestFocus();
        } else {
            playerSignUpPresenter.getPlayerUserName(playerUserName);
        }
    }

    @Override
    public void checkUserNameTaken(boolean snapshotExists,String playerUserName) {
        if (snapshotExists) {
            userNameEditText.setError("Sorry. This username has been taken.");
            userNameEditText.requestFocus();
        } else {
            if (extraActionGet.equals("ID")) {
                startActivity(new Intent(PlayerSignUpActivity.this, UserProfileActivity.class));
                finish();
            } else if (extraActionGet.equals("sessionMine")) {
                startActivity(new Intent(PlayerSignUpActivity.this, MainMenuActivity.class).putExtra("intention", extraActionGet)
                        .putExtra("playerUserName",playerUserName));
                finish();
                Toast.makeText(PlayerSignUpActivity.this, "Please proceed to create your session!", Toast.LENGTH_SHORT).show();
            } else if (extraActionGet.equals("sessionOther")) {
                startActivity(new Intent(PlayerSignUpActivity.this, GameSessionRequestActivity.class));
                finish();
            } else {
                startActivity(new Intent(PlayerSignUpActivity.this, MainMenuActivity.class));
                finish();
                Toast.makeText(PlayerSignUpActivity.this, "Welcome to the club!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void checkPlayerExists(boolean exists) {
        if (exists) {
            startActivity(new Intent(PlayerSignUpActivity.this, MainMenuActivity.class));
            Toast.makeText(PlayerSignUpActivity.this, "Welcome back to the club!", Toast.LENGTH_SHORT).show();
        } else {

        }
    }
}
