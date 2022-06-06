package com.y4.projektcheck.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.y4.projektcheck.Adapters.GameSessionAdapter;
import com.y4.projektcheck.Misc.CheckerPieceDecorator;
import com.y4.projektcheck.Misc.GameLogic;
import com.y4.projektcheck.Models.GameSession;
import com.y4.projektcheck.Presenters.GameSessionPresenter;
import com.y4.projektcheck.R;

public class GameSessionActivity extends AppCompatActivity implements GameSessionPresenter.GameSessionView {
    private GameSessionAdapter gameSessionAdapter;
    private RecyclerView gridView;
    private GameSessionPresenter gameSessionPresenter;
    private SharedPreferences gameSessionIdPref;
    private String sessionId, hostId, oppId, playerOneStr, playerTwoStr;
    public static String sessionIdPass, hostIdPass, oppIdPass;
    private Intent intent;
    public static Intent otherIntent;
    private MaterialTextView playerTextName, oppNameText;
    private GameLogic gameLogic;
    public static boolean isYourTurnP1, isYourTurnP2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_session_layout);
        playerTextName = findViewById(R.id.player_name_text);
        gridView = findViewById(R.id.checker_board);
        oppNameText = findViewById(R.id.opp_player_name_text);
        intent = getIntent();
        otherIntent = getIntent();
        gameLogic = new GameLogic();
        gameSessionAdapter = new GameSessionAdapter();
        gameSessionIdPref = getSharedPreferences("sessionId", MODE_PRIVATE);
        sessionId = gameSessionIdPref.getString("sessionId", "");
        hostId = gameSessionIdPref.getString("hostId", "");
        oppId = gameSessionIdPref.getString("oppId", "");
        playerOneStr = gameSessionIdPref.getString("playerOneStr", "");
        playerTwoStr = gameSessionIdPref.getString("playerTwoStr", "");
        gameLogic.setPlayerOneStr(playerOneStr);
        gameLogic.setPlayerTwoStr(playerTwoStr);
        gameSessionAdapter.setC(GameSessionActivity.this);
        gameSessionAdapter.setGridView(gridView);
        gameSessionAdapter.setGameSessionId(sessionId);
        gridView.setLayoutManager(new GridLayoutManager(GameSessionActivity.this, 8));
        gridView.setHasFixedSize(true);
        gridView.addItemDecoration(new CheckerPieceDecorator(1));
        if (intent.hasExtra("playerOne")) {
            gameSessionAdapter.setColourChosen("Yellow");
            gameSessionAdapter.setPlayerOne(true);
            gameSessionPresenter = new GameSessionPresenter(GameSessionActivity.this, sessionId, hostId, oppId);
        }
        if (intent.hasExtra("playerTwo")) {
            gameSessionAdapter.setColourChosen("White");
            gameSessionAdapter.setPlayerOne(false);
            gameSessionPresenter = new GameSessionPresenter(GameSessionActivity.this, sessionId, hostId, oppId);
        }
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

    @Override
    public void gameSessionInfo(GameSession gameSession) {
        if (intent.hasExtra("playerOne")) {
            playerTextName.setText(String.valueOf(gameSession.getGameSessionPlayers().get("Player1")));
            oppNameText.setText(String.valueOf(gameSession.getGameSessionPlayers().get("Player2")));
        }
        if (intent.hasExtra("playerTwo")) {
            playerTextName.setText(String.valueOf(gameSession.getGameSessionPlayers().get("Player2")));
            oppNameText.setText(String.valueOf(gameSession.getGameSessionPlayers().get("Player1")));
        }
        sessionIdPass = gameSession.getGameSessionId();
        hostIdPass = (String) gameSession.getGameSessionPlayers().get("Player1");
        oppIdPass = (String) gameSession.getGameSessionPlayers().get("Player2");
    }

    @Override
    public void updateTurn(boolean isTurn) {
        if (isTurn) {
            Toast.makeText(GameSessionActivity.this, "Your Turn", Toast.LENGTH_SHORT).show();
            gameLogic.setPlayerMoveMade(false);
            gameLogic.setOppMoveMade(true);
            isYourTurnP1 = true;
        } else {
            Toast.makeText(GameSessionActivity.this, "Opponent's Turn", Toast.LENGTH_SHORT).show();
            gameLogic.setPlayerMoveMade(true);
            gameLogic.setOppMoveMade(false);
            isYourTurnP1 = false;
        }
    }

    @Override
    public void reflect(long reflect, long prev, long eliminated, boolean isPlayerOne) {
        if (isPlayerOne) {
            if (reflect == 1 || reflect == 3 || reflect == 5 || reflect == 7 || reflect == gameLogic.reflectPosition(1) || reflect == gameLogic.reflectPosition(3) || reflect == gameLogic.reflectPosition(5) || reflect == gameLogic.reflectPosition(7)) {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);

            } else if (gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE) {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);

            } else {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);

            }
        } else {
            if (reflect == 1 || reflect == 3 || reflect == 5 || reflect == 7 || reflect == gameLogic.reflectPosition(1) || reflect == gameLogic.reflectPosition(3) || reflect == gameLogic.reflectPosition(5) || reflect == gameLogic.reflectPosition(7)) {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);

            } else if (gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_king_2).getVisibility()==View.VISIBLE) {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);

            } else {
                gridView.getChildAt((int) reflect).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) prev)).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                gridView.getChildAt(gameLogic.reflectPosition((int) eliminated)).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);

            }
        }
    }
}