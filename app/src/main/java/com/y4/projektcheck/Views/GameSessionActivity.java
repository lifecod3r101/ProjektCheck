package com.y4.projektcheck.Views;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        gameSessionAdapter.setPieceSpaceClick(new GameSessionAdapter.OnItemClickListener() {
            @Override
            public void ClickPiece(int position, boolean currPlayerPieces, boolean oppPlayerPieces) {
                gameSessionAdapter.setSpacesAvailable(true);
                gameSessionAdapter.setSquaresAvailable(gameLogic.getSpacesAvailableWhileAtEdge(position));
                boolean clickedPositionsSev = position == 56 || position == 40 || position == 24 || position == 8;
                boolean clickedPositionsNine = position == 55 || position == 39 || position == 23;
                if ((clickedPositionsSev || clickedPositionsNine) && currPlayerPieces) {
                    Toast.makeText(GameSessionActivity.this, gameSessionAdapter.getSquaresAvailable().toString(), Toast.LENGTH_SHORT).show();
                }
                gameSessionAdapter.setPieceClicked(position);
            }

            @Override
            public void ClickSpace(int position, boolean currPlayerPieces, boolean oppPlayerPieces) {

            }
        });
        gridView.setAdapter(gameSessionAdapter);
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
