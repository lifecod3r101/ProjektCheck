package com.y4.projektcheck.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.Presenters.GameSessionRequestPresenter;
import com.y4.projektcheck.Presenters.OwnSessionPresenter;
import com.y4.projektcheck.R;

public class OwnSessionActivity extends AppCompatActivity implements OwnSessionPresenter.OwnSessionView {
    private MaterialTextView sessionIdText, hostPlayerText, oppPlayerText;
    private OwnSessionPresenter ownSessionPresenter;
    private GameSessionRequestPresenter presenter;
    private boolean isYellowSelected = false;
    private boolean isWhiteSelected = false;
    private String sessionId, hostPlayer, oppPlayer,hostPlayerId, oppPlayerId;
    public static String sessionIdPass;
    private SharedPreferences sessionIdPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_session_layout);
        sessionIdText = findViewById(R.id.text_session_id);
        hostPlayerText = findViewById(R.id.host_username_text);
        oppPlayerText = findViewById(R.id.opp_username_text);
        if (getIntent().hasExtra("sessionId")) {
            sessionIdPass = getIntent().getStringExtra("sessionId");
        }
        ownSessionPresenter = new OwnSessionPresenter(OwnSessionActivity.this,sessionIdPass);
        presenter = new GameSessionRequestPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void ownSessionInfo(GameSession gameSession) {
        sessionId = gameSession.getGameSessionId();
        hostPlayer = String.valueOf(gameSession.getGameSessionPlayers().get("Player1UserName"));
        hostPlayerId = String.valueOf(gameSession.getGameSessionPlayers().get("Player1"));
        oppPlayer = String.valueOf(gameSession.getGameSessionPlayers().get("Player2UserName"));
        oppPlayerId = String.valueOf(gameSession.getGameSessionPlayers().get("Player2"));
        sessionIdText.setText("Session ID: ".concat(sessionId));
        hostPlayerText.setText("Player 1: ".concat(hostPlayer));
        oppPlayerText.setText("Player 2: ".concat(oppPlayer));
        ownSessionPresenter.setSessionId(gameSession.getGameSessionId());

    }

    @Override
    public void getPlaying(String oppUserName) {
        oppPlayerText.setText("Player 2: ".concat(oppUserName));
        startActivity(new Intent(OwnSessionActivity.this, GameSessionActivity.class)
                .putExtra("playerOne", "P1"));
        sessionIdPref = getSharedPreferences("sessionId", MODE_PRIVATE);
        SharedPreferences.Editor editor = sessionIdPref.edit();
        editor.putString("sessionId", sessionId);
        editor.putString("hostId", hostPlayerId);
        editor.putString("oppId", oppPlayerId);
        editor.putString("playerOneStr", "playerOne");
        editor.apply();
    }
}
