package com.y4.projektcheck.Views;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.y4.projektcheck.Presenters.PlayerEmailSignUpPresenter;
import com.y4.projektcheck.R;

import java.util.Objects;

public class PlayerEmailSignUpActivity extends AppCompatActivity implements PlayerEmailSignUpPresenter.EmailSignUpView {
    private TextInputEditText emailEnter;
    private CircularProgressIndicator loadProgress;
    private MaterialButton emailVerifyButton;
    private PlayerEmailSignUpPresenter playerEmailSignUpPresenter;
    private String mailPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_email_sign_up_layout);
        emailEnter = findViewById(R.id.email_sign_up_enter);
        loadProgress = findViewById(R.id.load_progress);
        emailVerifyButton = findViewById(R.id.mail_verify);
        playerEmailSignUpPresenter = new PlayerEmailSignUpPresenter(this);
        loadProgress.setVisibility(View.GONE);
        if(getIntent().hasExtra("extraAction")){

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        emailVerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailPass = Objects.requireNonNull(emailEnter.getText()).toString();
                playerEmailSignUpPresenter.emailAddressIsEmptyOrNotEmail(mailPass);
            }
        });
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
    public void checkEmailEmptyOrValid(String playerEmailAddress) {
        if (playerEmailAddress.isEmpty()) {
            emailEnter.setError("Sorry. This is required");
            emailEnter.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(playerEmailAddress).matches()) {
            emailEnter.setError("Sorry. Not a valid email address.");
            emailEnter.requestFocus();
            return;
        } else {
            playerEmailSignUpPresenter.readSaveEmailAddress(playerEmailAddress);
            loadProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showSuccess(String emailAddressAuth, Task<Void> task) {
        if (task.isSuccessful()) {
            Toast.makeText(PlayerEmailSignUpActivity.this, "Kindly Check Your Mail's Inbox For Further Instructions", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("emailInfo", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailAddress", emailAddressAuth);
            editor.putString("extraAction", getIntent().getStringExtra("extraAction"));
            editor.apply();
            emailEnter.setText("");
            loadProgress.setVisibility(View.GONE);
        } else {
            Toast.makeText(PlayerEmailSignUpActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
            loadProgress.setVisibility(View.GONE);
        }
    }
}
