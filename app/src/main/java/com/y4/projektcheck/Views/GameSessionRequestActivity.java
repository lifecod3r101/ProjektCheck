package com.y4.projektcheck.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Adapters.GameSessionRequestsAdapter;
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameSessionRequestsAdapter.setPlayersRequestClick(new GameSessionRequestsAdapter.OnItemClickListener() {
            @Override
            public void playerClick(GameSession gameSession) {

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
        if (!b) {
            noPlayersText.setVisibility(View.VISIBLE);
            Log.i("GameSession", String.valueOf(gameSession));
        } else {
            sessionsAvailableArrayList.add(gameSession);
            noPlayersText.setVisibility(View.GONE);
            gameSessionRequestsAdapter.setSessionsArrayList(sessionsAvailableArrayList);
            playerRequestsRecycler.setAdapter(gameSessionRequestsAdapter);
        }
    }
}
