package com.y4.projektcheck.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

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
    private String emailGet;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sign_up_layout);
        userNameEditText = findViewById(R.id.username_sign_up_enter);
        confirmInfoButton = findViewById(R.id.sign_up);
        playerSignUpPresenter = new PlayerSignUpPresenter(this);
        getEmail = getSharedPreferences("emailInfo", MODE_PRIVATE);
        emailGet = getEmail.getString("emailAddress", "");
        confirmInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerSignUpPresenter.userNameExists(userNameEditText.getText().toString());
                playerSignUpPresenter.userNameIsEmpty(userNameEditText.getText().toString());
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
    public void checkUserNameEmpty(String playerUserName, Boolean isEmpty) {
        if (isEmpty) {
            userNameEditText.setError("Sorry. This is required.");
            userNameEditText.requestFocus();
        } else {
            playerSignUpPresenter.readPlayerUserNameAndEmailAddress(playerUserName, emailGet);
            startActivity(new Intent(PlayerSignUpActivity.this, MainActivity.class));
        }
    }

    @Override
    public void userNameIsTaken(String playerUserName, Boolean isTaken) {
        if (isTaken) {
            userNameEditText.setError("Sorry. This username has been taken.");
            userNameEditText.requestFocus();
        } else {
            playerSignUpPresenter.readPlayerUserNameAndEmailAddress(playerUserName, emailGet);
            startActivity(new Intent(PlayerSignUpActivity.this, MainActivity.class));
        }
    }
}
