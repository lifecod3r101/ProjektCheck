package com.y4.projektcheck.Views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.y4.projektcheck.Presenters.PlayerEmailSignUpPresenter;

public class PlayerEmailSignUpActivity extends AppCompatActivity implements PlayerEmailSignUpPresenter.EmailSignUpView {
    private TextInputEditText emailEnter;
    private ProgressBar loadProgress;
    private MaterialButton emailVerifyButton;
    private PlayerEmailSignUpPresenter playerEmailSignUpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerEmailSignUpPresenter = new PlayerEmailSignUpPresenter(this);
        playerEmailSignUpPresenter.readSavePlayerEmailAddress(emailEnter.getText().toString());
        emailVerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerEmailSignUpPresenter.emailAddressIsEmptyOrNotEmail(emailEnter.getText().toString().trim());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void checkEmailEmptyOrValid(Boolean isEmpty, Boolean isNotEmail) {
        if (isEmpty) {
            emailEnter.setError("Sorry. This is required");
            emailEnter.requestFocus();
        } else {
            playerEmailSignUpPresenter.readSavePlayerEmailAddress(emailEnter.getText().toString().trim());
        }
        if (isNotEmail) {
            emailEnter.setError("Sorry. Not a valid email address.");
            emailEnter.requestFocus();
        } else {
            playerEmailSignUpPresenter.readSavePlayerEmailAddress(emailEnter.getText().toString().trim());
        }
    }

    @Override
    public void showSuccess(Boolean isSuccessful, String emailAddressAuth, Task<Void> task) {
        if (isSuccessful) {
            Toast.makeText(PlayerEmailSignUpActivity.this, "Kindly Check Your Mail's Inbox For Further Instructions", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("emailInfo", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailAddress", emailAddressAuth);
            editor.apply();
            emailEnter.setText("");
            loadProgress.setVisibility(ProgressBar.INVISIBLE);
        } else {
            Toast.makeText(PlayerEmailSignUpActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
            loadProgress.setVisibility(ProgressBar.INVISIBLE);
        }
    }
}
