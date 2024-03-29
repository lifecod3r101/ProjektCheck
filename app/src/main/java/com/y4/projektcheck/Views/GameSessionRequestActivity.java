package com.y4.projektcheck.Views;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Adapters.GameSessionRequestsAdapter;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.Presenters.GameSessionRequestPresenter;
import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameSessionRequestActivity extends AppCompatActivity implements GameSessionRequestPresenter.PlayersView {
    private GameSessionRequestPresenter gameSessionRequestPresenter;
    private MaterialTextView noPlayersText;
    private RecyclerView playerRequestsRecycler;
    private ArrayList<GameSession> sessionsAvailableArrayList = new ArrayList<>();
    private GameSessionRequestsAdapter gameSessionRequestsAdapter;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private String hostPlayerId, oppPlayerId, sessionId;
    private SharedPreferences sessionIdPref;
    private String playerUserName;

    public void setOppPlayerId(String oppPlayerId) {
        this.oppPlayerId = oppPlayerId;
    }

    public String getOppPlayerId() {
        return oppPlayerId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getHostPlayerId() {
        return hostPlayerId;
    }

    public void setHostPlayerId(String hostPlayerId) {
        this.hostPlayerId = hostPlayerId;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_requests_layout);
        noPlayersText = findViewById(R.id.no_players_text);
        playerRequestsRecycler = findViewById(R.id.player_requests_recycler);
        playerRequestsRecycler.setLayoutManager(new LinearLayoutManager(GameSessionRequestActivity.this));
        playerRequestsRecycler.setHasFixedSize(false);
        gameSessionRequestsAdapter = new GameSessionRequestsAdapter();
        gameSessionRequestPresenter = new GameSessionRequestPresenter(GameSessionRequestActivity.this);
        if (getIntent().hasExtra("joinPlayerUserName")) {
            playerUserName = getIntent().getStringExtra("joinPlayerUserName");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameSessionRequestsAdapter.setPlayersRequestClick(new GameSessionRequestsAdapter.OnItemClickListener() {
            @Override
            public void playerClick(GameSession gameSession) {
                builder = new AlertDialog.Builder(GameSessionRequestActivity.this);
                builder.setMessage("Awaiting Approval...");
                dialog = builder.create();
                dialog.show();
                setHostPlayerId(String.valueOf(gameSession.getGameSessionPlayers().get("Player1")));
                setOppPlayerId(String.valueOf(gameSession.getGameSessionPlayers().get("Player2")));
                setSessionId(gameSession.getGameSessionId());
                gameSessionRequestPresenter.requestToPlaySession(String.valueOf(gameSession.getGameSessionPlayers().get("Player1")), Constants.getFirebaseAuth().getCurrentUser().getUid(), playerUserName, gameSession.getGameSessionId());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    public void getSessionsAvailable(GameSession gameSession, boolean b) {
        if (b) {
            noPlayersText.setVisibility(View.VISIBLE);
            Log.i("GameSession", String.valueOf(gameSession));
        } else {
            sessionsAvailableArrayList.add(gameSession);
            noPlayersText.setVisibility(View.GONE);
            gameSessionRequestsAdapter.setSessionsArrayList(sessionsAvailableArrayList);
            playerRequestsRecycler.setAdapter(gameSessionRequestsAdapter);
        }
    }


    @Override
    public void getPlaying() {
        startActivity(new Intent(GameSessionRequestActivity.this, GameSessionActivity.class)
                .putExtra("playerTwo", "P2"));
        sessionIdPref = getSharedPreferences("sessionId", MODE_PRIVATE);
        SharedPreferences.Editor editor = sessionIdPref.edit();
        editor.putString("sessionId", getSessionId());
        editor.putString("hostId", getHostPlayerId());
        editor.putString("oppId", getOppPlayerId());
        editor.putString("playerTwoStr", "playerTwo");
        editor.apply();
    }
}
