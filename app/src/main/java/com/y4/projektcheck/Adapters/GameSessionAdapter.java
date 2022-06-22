package com.y4.projektcheck.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.y4.projektcheck.Misc.GameLogic;
import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameSessionAdapter extends RecyclerView.Adapter<GameSessionAdapter.GameSessionViewHolder> {
    private Context c;

    private AdapterView.OnItemClickListener squareSpaceClick;
    private boolean playerOne;
    private String colourChosen;
    private String gameSessionId;
    private GameLogic gameLogic = new GameLogic();
    private RecyclerView gridView;
    private ArrayList<Integer> spacesAvailableList = new ArrayList<>();

    public ArrayList<Integer> getSpacesAvailableList() {
        return spacesAvailableList;
    }

    public void setSpacesAvailableList(ArrayList<Integer> spacesAvailableList) {
        this.spacesAvailableList = spacesAvailableList;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public GameSessionAdapter() {
    }

    @NonNull
    @Override
    public GameSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.checker_piece_layout, parent, false);
        return new GameSessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameSessionViewHolder holder, int position) {
        DisplayMetrics metrics=new DisplayMetrics();
        ((Activity)c).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int deviceWidth=metrics.widthPixels / 8;
        int deviceHeight=metrics.heightPixels / 8;
        holder.square.getLayoutParams().width=deviceWidth;
        holder.square.getLayoutParams().height=deviceHeight;
        gameLogic.gameSetupDef(position, isPlayerOne(), getColourChosen(), holder.itemView, getGridView(), holder.square, holder.pieceYellow, holder.pieceWhite, holder.pieceKingYellow, holder.pieceKingWhite);

    }

    public GameSessionAdapter(Context c, boolean playerOne, String colourChosen, ArrayList<Integer> squaresAvailable, RecyclerView gridView) {
        this.c = c;
        this.playerOne = playerOne;
        this.colourChosen = colourChosen;
        this.gridView = gridView;
    }

    public RecyclerView getGridView() {
        return gridView;
    }

    public void setGridView(RecyclerView gridView) {
        this.gridView = gridView;
    }


    public String getColourChosen() {
        return colourChosen;
    }

    public void setColourChosen(String colourChosen) {
        this.colourChosen = colourChosen;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }


    public boolean isPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(boolean playerOne) {
        this.playerOne = playerOne;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 64;
    }



    public class GameSessionViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView square;
        ImageButton pieceYellow, pieceWhite, pieceKingYellow, pieceKingWhite;
        public GameSessionViewHolder(@NonNull View itemView) {
            super(itemView);
            square = itemView.findViewById(R.id.checker_board_piece);
            pieceYellow = itemView.findViewById(R.id.checker_board_man_1);
            pieceWhite = itemView.findViewById(R.id.checker_board_man_2);
            pieceKingYellow = itemView.findViewById(R.id.checker_board_king_1);
            pieceKingWhite = itemView.findViewById(R.id.checker_board_king_2);
        }
    }
}