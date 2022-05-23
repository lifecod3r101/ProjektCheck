package com.y4.projektcheck.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.y4.projektcheck.Misc.GameLogic;
import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameSessionAdapter extends BaseAdapter {
    private Context c;

    private AdapterView.OnItemClickListener squareSpaceClick;
    private boolean playerOne;
    private String colourChosen;
    private GameLogic gameLogic = new GameLogic();
    private GridView gridView;


    public GameSessionAdapter() {
    }

    public GameSessionAdapter(Context c, boolean playerOne, String colourChosen, ArrayList<Integer> squaresAvailable, GridView gridView) {
        this.c = c;
        this.playerOne = playerOne;
        this.colourChosen = colourChosen;
        this.gridView = gridView;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
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
    public int getCount() {
        return 64;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int spacePosition, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.checker_piece_layout, parent, false);
            ImageView square = view.findViewById(R.id.checker_board_piece);
            ImageButton piece1 = view.findViewById(R.id.checker_board_man_1);
            ImageButton piece2 = view.findViewById(R.id.checker_board_man_2);
            ImageButton pieceKing1 = view.findViewById(R.id.checker_board_king_1);
            ImageButton pieceKing2 = view.findViewById(R.id.checker_board_king_2);
            gameLogic.gameLogicDef(spacePosition, isPlayerOne(), getColourChosen(), view, getGridView(), square, piece1, piece2, pieceKing1, pieceKing2);
        }
        return view;
    }
}
