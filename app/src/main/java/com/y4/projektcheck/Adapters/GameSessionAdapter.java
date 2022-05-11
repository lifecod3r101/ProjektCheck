package com.y4.projektcheck.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.y4.projektcheck.R;
import com.y4.projektcheck.Views.GameSessionActivity;

import java.util.ArrayList;

public class GameSessionAdapter extends BaseAdapter {
    private Context c;
    private OnItemClickListener pieceSpaceClick;
    private boolean playerOne;
    private String colourChosen;
    private boolean hasPieceBeenClicked, spacesAvailable;
    private ArrayList<Integer> squaresAvailable = new ArrayList<>();
    private int pieceClicked;


    public GameSessionAdapter() {
    }

    public GameSessionAdapter(Context c, OnItemClickListener pieceSpaceClick, boolean playerOne, String colourChosen, boolean hasPieceBeenClicked, boolean spacesAvailable, ArrayList<Integer> squaresAvailable, int pieceClicked) {
        this.c = c;
        this.pieceSpaceClick = pieceSpaceClick;
        this.playerOne = playerOne;
        this.colourChosen = colourChosen;
        this.hasPieceBeenClicked = hasPieceBeenClicked;
        this.spacesAvailable = spacesAvailable;
        this.squaresAvailable = squaresAvailable;
        this.pieceClicked = pieceClicked;
    }

    public int getPieceClicked() {
        return pieceClicked;
    }

    public void setPieceClicked(int pieceClicked) {
        this.pieceClicked = pieceClicked;
    }

    public boolean isSpacesAvailable() {
        return spacesAvailable;
    }

    public ArrayList<Integer> getSquaresAvailable() {
        return squaresAvailable;
    }

    public void setSquaresAvailable(ArrayList<Integer> squaresAvailable) {
        this.squaresAvailable = squaresAvailable;
    }

    public void setSpacesAvailable(boolean spacesAvailable) {
        this.spacesAvailable = spacesAvailable;
    }

    public boolean isHasPieceBeenClicked() {
        return hasPieceBeenClicked;
    }

    public void setHasPieceBeenClicked(boolean hasPieceBeenClicked) {
        this.hasPieceBeenClicked = hasPieceBeenClicked;
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

    public OnItemClickListener getPieceSpaceClick() {
        return pieceSpaceClick;
    }

    public void setPieceSpaceClick(OnItemClickListener pieceSpaceClick) {
        this.pieceSpaceClick = pieceSpaceClick;
    }

    public boolean isPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(boolean playerOne) {
        this.playerOne = playerOne;
    }

    public interface OnItemClickListener {
        void ClickPiece(int position, boolean currPlayerPieces, boolean oppPlayerPieces);

        void ClickSpace(int position, boolean currPlayerPieces, boolean oppPlayerPieces);
    }


    @Override
    public int getCount() {
        return 64;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView square, piece;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            square = itemView.findViewById(R.id.checker_board_piece);
            piece = itemView.findViewById(R.id.checker_board_man);

        }
    }

    @Override
    public View getView(int spacePosition, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.checker_piece_layout, parent, false);
            boolean isVis = spacePosition == 1 || spacePosition == 3 || spacePosition == 5 || spacePosition == 7 || spacePosition == 8 || spacePosition == 10 || spacePosition == 12 || spacePosition == 14
                    || spacePosition == 17 || spacePosition == 19 || spacePosition == 21 || spacePosition == 23 || spacePosition == 24 || spacePosition == 26 || spacePosition == 28 || spacePosition == 30
                    || spacePosition == 33 || spacePosition == 35 || spacePosition == 37 || spacePosition == 39 || spacePosition == 40 || spacePosition == 42 || spacePosition == 44 || spacePosition == 46
                    || spacePosition == 49 || spacePosition == 51 || spacePosition == 53 || spacePosition == 55 || spacePosition == 56 || spacePosition == 58 || spacePosition == 60 || spacePosition == 62;
            boolean visOppPlayer = spacePosition == 1 || spacePosition == 3 || spacePosition == 5 || spacePosition == 7 || spacePosition == 8 || spacePosition == 10 || spacePosition == 12 || spacePosition == 14
                    || spacePosition == 17 || spacePosition == 19 || spacePosition == 21 || spacePosition == 23;
            boolean visCurrPlayer = spacePosition == 40 || spacePosition == 42 || spacePosition == 44 || spacePosition == 46
                    || spacePosition == 49 || spacePosition == 51 || spacePosition == 53 || spacePosition == 55 || spacePosition == 56 || spacePosition == 58 || spacePosition == 60 || spacePosition == 62;
            ViewHolder v = new ViewHolder(view);
            if (!isVis) {
                view.setVisibility(View.GONE);
            }
            if (visOppPlayer /*&& getColourChosen().equals("Yellow")*/) {
                v.piece.setImageResource(R.drawable.ic_rpiece);
            } else if (visCurrPlayer /*&& getColourChosen().equals("Yellow")*/) {
                v.piece.setImageResource(R.drawable.ic_bpiece);
            }

            v.square.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasPieceBeenClicked()) {
                        pieceSpaceClick.ClickSpace(spacePosition, visCurrPlayer, visOppPlayer);
                        hasPieceBeenClicked = false;
                    }
                }
            });
            v.piece.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (visCurrPlayer) {
                    hasPieceBeenClicked = true;
                    pieceSpaceClick.ClickPiece(spacePosition, visCurrPlayer, visOppPlayer);
//                    } else {

//                    }
                }
            });
        }
        return view;
    }
}
