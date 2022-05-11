package com.y4.projektcheck.Views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Presenters.GameSessionRequestPresenter;

public class GameSessionRequestActivity extends AppCompatActivity implements GameSessionRequestPresenter.PlayersView {
    private GameSessionRequestPresenter gameSessionRequestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameSessionRequestPresenter = new GameSessionRequestPresenter(this);
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
    public void getPlayersAvailable(Player player) {

    }
}
