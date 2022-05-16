package com.y4.projektcheck.Views;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.y4.projektcheck.Adapters.GameSessionAdapter;
import com.y4.projektcheck.Misc.GameLogic;
import com.y4.projektcheck.R;

public class GameSessionActivity extends AppCompatActivity {
    private GameSessionAdapter gameSessionAdapter;
    private GridView gridView;
    private GameLogic gameLogic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_session_layout);
        gridView = findViewById(R.id.checker_board);
        gameSessionAdapter = new GameSessionAdapter();
        gameLogic = new GameLogic();
        gameSessionAdapter.setC(GameSessionActivity.this);
        gridView.setAdapter(gameSessionAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameSessionAdapter.setGridView(gridView);
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
