package com.y4.projektcheck.Views;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.y4.projektcheck.Adapters.GameSessionAdapter;
import com.y4.projektcheck.R;

public class GameSessionActivity extends AppCompatActivity {
    private GameSessionAdapter gameSessionAdapter;
    private GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_session_layout);
        gridView = findViewById(R.id.checker_board);
        gameSessionAdapter = new GameSessionAdapter();
        gameSessionAdapter.setC(GameSessionActivity.this);
        gameSessionAdapter.setGridView(gridView);
        gameSessionAdapter.setColourChosen("White");
        gameSessionAdapter.setPlayerOne(false);
        gridView.setAdapter(gameSessionAdapter);
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
}
