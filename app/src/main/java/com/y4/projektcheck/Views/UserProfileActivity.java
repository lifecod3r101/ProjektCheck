package com.y4.projektcheck.Views;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Presenters.PlayerProfilePresenter;
import com.y4.projektcheck.R;

public class UserProfileActivity extends AppCompatActivity implements PlayerProfilePresenter.PlayerProfileView {
    private ImageView playerProfileImg;
    private MaterialTextView playerProfileUserName, playerProfileMail, playerProfileWins, playerProfileDraws, playerProfileLosses, playerProfileCumScore;
    private PlayerProfilePresenter playerProfilePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_profile_layout);
        playerProfileImg = findViewById(R.id.player_profile_img);
        playerProfileUserName = findViewById(R.id.username_text);
        playerProfileMail = findViewById(R.id.player_mail_text);
        playerProfileWins = findViewById(R.id.wins_text);
        playerProfileDraws = findViewById(R.id.draws_text);
        playerProfileLosses = findViewById(R.id.losses_text);
        playerProfileCumScore = findViewById(R.id.total_score);
        playerProfilePresenter = new PlayerProfilePresenter(UserProfileActivity.this, Constants.getFirebaseAuth().getCurrentUser());
    }

    @Override
    protected void onStart() {
        super.onStart();
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
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void getLoggedInUserInfo(Player p) {
        playerProfileUserName.setText(p.getPlayerUserName());
        playerProfileMail.setText(p.getPlayerEmailAddress());
        playerProfileWins.setText(String.valueOf(p.getPlayerWins()).concat("\n").concat("Wins"));
        playerProfileDraws.setText(String.valueOf(p.getPlayerDraws()).concat("\n").concat("Draws"));
        playerProfileLosses.setText(String.valueOf(p.getPlayerLosses()).concat("\n").concat("Losses"));
        playerProfileCumScore.setText("Total Score:\n".concat(String.valueOf(p.getPlayerCumScore())));
    }
}
