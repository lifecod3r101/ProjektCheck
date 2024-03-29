package com.y4.projektcheck.Views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseUser;
import com.y4.projektcheck.Misc.Constants;
import com.y4.projektcheck.Models.Player;
import com.y4.projektcheck.Presenters.MainMenuPresenter;
import com.y4.projektcheck.R;

public class MainMenuActivity extends AppCompatActivity implements MainMenuPresenter.MainMenuView {
    private ShapeableImageView profileImg;
    private MaterialButton waitingRoom, createSession, joinSession;
    private MainMenuPresenter mainMenuPresenter;
    private Player player;
    private String intentionSession, sessionId;
    private String playerUserName;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profileImg = findViewById(R.id.profile_img);
        waitingRoom = findViewById(R.id.your_game);
        createSession = findViewById(R.id.create_game);
        joinSession = findViewById(R.id.join_game);
        mainMenuPresenter = new MainMenuPresenter(MainMenuActivity.this, Constants.getFirebaseAuth().getCurrentUser());
        if (getIntent().hasExtra("intention") && getIntent().hasExtra("playerUserName")) {
            intentionSession = getIntent().getStringExtra("intention");
            mainMenuPresenter.createSession(Constants.getFirebaseAuth().getCurrentUser().getUid(), getIntent().getStringExtra("playerUserName"));
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenuActivity.this);
            alertDialog.setMessage("Prove yourself worthy of a challenge!");
            alertDialog.setNeutralButton("For sure!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = alertDialog.create();
            dialog.show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        waitingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, OwnSessionActivity.class).putExtra("sessionId", mainMenuPresenter.getCurrSessId()));
            }
        });
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuPresenter.checkUserExists(Constants.getFirebaseAuth().getCurrentUser(), "showProfile", "ID");
            }
        });
        createSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuPresenter.checkUserExists(Constants.getFirebaseAuth().getCurrentUser(), "createSession", "sessionMine");
            }
        });
        joinSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuPresenter.checkUserExists(Constants.getFirebaseAuth().getCurrentUser(), "joinSession", "sessionOther");
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
    public void userInformation(Player player) {
        if (player != null) {
            profileImg.setBackgroundResource(R.color.white);
            this.player = player;
            playerUserName = player.getPlayerUserName();
            setPassPlayer(player);
            passPlayerInfo();
        } else {

        }
    }

    private void setPassPlayer(Player player) {
        this.player = player;
    }

    private Player passPlayerInfo() {
        return player;
    }

    @Override
    public void userExists(FirebaseUser firebaseUser, String action, String extraAction) {

    }

    @Override
    public void userExists(FirebaseUser firebaseUser, String action, String extraAction, boolean sessionExists) {
        if (firebaseUser == null) {
            //Inflate dialog
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenuActivity.this);
            alertDialog.setTitle("Hold On");
            alertDialog.setMessage("Before you jump in, we need to know who you are.");
            alertDialog.setPositiveButton("Okay. Sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(MainMenuActivity.this, PlayerEmailSignUpActivity.class).putExtra("extraAction", extraAction));
                    dialog.dismiss();
                }
            });
            alertDialog.setNegativeButton("Maybe later", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = alertDialog.create();
            dialog.show();
        } else if (action.equals("showProfile")) {
            startActivity(new Intent(MainMenuActivity.this, UserProfileActivity.class));
        } else if (action.equals("createSession")) {
            if (mainMenuPresenter.isSessionExists()) {
                Toast.makeText(MainMenuActivity.this, "Sorry. You have a session that exists.", Toast.LENGTH_SHORT).show();
            } else {
                mainMenuPresenter.createSession(firebaseUser.getUid(), player.getPlayerUserName());
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenuActivity.this);
                alertDialog.setMessage("Prove yourself worthy of a challenge!");
                alertDialog.setNeutralButton("For sure!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        } else if (action.equals("joinSession")) {
            startActivity(new Intent(MainMenuActivity.this, GameSessionRequestActivity.class)
                    .putExtra("joinPlayerUserName", playerUserName));
        }
    }
}