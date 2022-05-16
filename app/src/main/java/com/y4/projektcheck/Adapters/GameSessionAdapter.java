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
    private boolean hasPieceBeenClicked, spacesAvailable;
    private int pieceClicked;
    private ArrayList<Integer> initialPiecesOpp = new ArrayList<>();
    private ArrayList<Integer> initialPiecesPlayer = new ArrayList<>();
    private ArrayList<Integer> spacesAvailableList = new ArrayList<>();
    private GameLogic gameLogic = new GameLogic();
    private GridView gridView;
    private View view;

    public ArrayList<Integer> getInitialPiecesOpp() {
        return initialPiecesOpp;
    }

    public void setInitialPiecesOpp(ArrayList<Integer> initialPiecesOpp) {
        this.initialPiecesOpp = initialPiecesOpp;
    }

    public ArrayList<Integer> getInitialPiecesPlayer() {
        return initialPiecesPlayer;
    }

    public void setInitialPiecesPlayer(ArrayList<Integer> initialPiecesPlayer) {
        this.initialPiecesPlayer = initialPiecesPlayer;
    }

    public GameSessionAdapter() {
    }

    public GameSessionAdapter(Context c, boolean playerOne, String colourChosen, boolean hasPieceBeenClicked, boolean spacesAvailable, ArrayList<Integer> squaresAvailable, int pieceClicked, GridView gridView) {
        this.c = c;
        this.playerOne = playerOne;
        this.colourChosen = colourChosen;
        this.hasPieceBeenClicked = hasPieceBeenClicked;
        this.spacesAvailable = spacesAvailable;
        this.pieceClicked = pieceClicked;
        this.gridView = gridView;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
        this.gridView = gridView;
    }

    public View getPieceClicked() {
        return view;
    }

    public void setPieceClicked(int pieceClicked, View view) {
        this.pieceClicked = pieceClicked;
        this.view = view;
    }

    public boolean isSpacesAvailable() {
        return spacesAvailable;
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
            boolean isVis = spacePosition == 1 || spacePosition == 3 || spacePosition == 5 || spacePosition == 7 || spacePosition == 8 || spacePosition == 10 || spacePosition == 12 || spacePosition == 14
                    || spacePosition == 17 || spacePosition == 19 || spacePosition == 21 || spacePosition == 23 || spacePosition == 24 || spacePosition == 26 || spacePosition == 28 || spacePosition == 30
                    || spacePosition == 33 || spacePosition == 35 || spacePosition == 37 || spacePosition == 39 || spacePosition == 40 || spacePosition == 42 || spacePosition == 44 || spacePosition == 46
                    || spacePosition == 49 || spacePosition == 51 || spacePosition == 53 || spacePosition == 55 || spacePosition == 56 || spacePosition == 58 || spacePosition == 60 || spacePosition == 62;
            boolean visOppPlayer = spacePosition == 1 || spacePosition == 3 || spacePosition == 5 || spacePosition == 7 || spacePosition == 8 || spacePosition == 10 || spacePosition == 12 || spacePosition == 14
                    || spacePosition == 17 || spacePosition == 19 || spacePosition == 21 || spacePosition == 23;
            boolean visCurrPlayer = spacePosition == 40 || spacePosition == 42 || spacePosition == 44 || spacePosition == 46
                    || spacePosition == 49 || spacePosition == 51 || spacePosition == 53 || spacePosition == 55 || spacePosition == 56 || spacePosition == 58 || spacePosition == 60 || spacePosition == 62;
            if (!isVis) {
                view.setVisibility(View.GONE);
            }
            square.setTag(spacePosition);
            piece1.setTag(spacePosition);
            piece2.setTag(spacePosition);
            pieceKing1.setTag(spacePosition);
            pieceKing2.setTag(spacePosition);
            spacesAvailableList.add(24);
            spacesAvailableList.add(26);
            spacesAvailableList.add(28);
            spacesAvailableList.add(30);
            spacesAvailableList.add(33);
            spacesAvailableList.add(35);
            spacesAvailableList.add(37);
            spacesAvailableList.add(39);
            if (visOppPlayer) {
                piece1.setVisibility(View.VISIBLE);
                initialPiecesOpp.add(1);
                initialPiecesOpp.add(3);
                initialPiecesOpp.add(5);
                initialPiecesOpp.add(7);
                initialPiecesOpp.add(8);
                initialPiecesOpp.add(10);
                initialPiecesOpp.add(12);
                initialPiecesOpp.add(14);
                initialPiecesOpp.add(17);
                initialPiecesOpp.add(19);
                initialPiecesOpp.add(21);
                initialPiecesOpp.add(23);
            } else if (visCurrPlayer) {
                piece2.setVisibility(View.VISIBLE);
                initialPiecesPlayer.add(40);
                initialPiecesPlayer.add(42);
                initialPiecesPlayer.add(44);
                initialPiecesPlayer.add(46);
                initialPiecesPlayer.add(49);
                initialPiecesPlayer.add(51);
                initialPiecesPlayer.add(53);
                initialPiecesPlayer.add(55);
                initialPiecesPlayer.add(56);
                initialPiecesPlayer.add(58);
                initialPiecesPlayer.add(60);
                initialPiecesPlayer.add(62);
            }
            piece2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setPieceClicked((Integer) v.getTag(), v);
                }
            });
            if (pieceKing2.getVisibility() == View.VISIBLE) {
                pieceKing2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
            square.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasPieceBeenClicked()) {
                        if (isSpacesAvailable()) {
                            ImageView imageClicked = getGridView().findViewWithTag(v.getTag());
                            imageClicked.setImageResource(R.drawable.ic_checker_board_part);
                            boolean isKing = true;
                            if (isKing) {
                                if (initialPiecesOpp.contains((Integer) v.getTag())) {

                                } else if (initialPiecesOpp.contains((Integer) v.getTag() - 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                    piece1.findViewWithTag((Integer)v.getTag()-9).setVisibility(View.INVISIBLE);
                                    initialPiecesOpp.remove((Integer) v.getTag()-9);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag()-9);
                                    spacesAvailableList.add((Integer) v.getTag()-18);

                                } else if (initialPiecesOpp.contains((Integer) v.getTag() - 7) && spacesAvailableList.contains((Integer) v.getTag())) {

                                } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                    if ((Integer) v.getTag() + 7 == (Integer) getPieceClicked().getTag()) {

                                    } else if ((Integer) v.getTag() + 7 == (Integer) getPieceClicked().getTag()) {

                                    } else if ((Integer) v.getTag() - 7 == (Integer) getPieceClicked().getTag()) {

                                    } else if ((Integer) v.getTag() - 9 == (Integer) getPieceClicked().getTag()) {

                                    }
                                }


                            } else {
                                if (initialPiecesOpp.contains((Integer) v.getTag())) {

                                } else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                    initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                    piece1.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 14);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                    initialPiecesPlayer.add((Integer) v.getTag());
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    } else {
                                        piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    }
                                } else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                    initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                    piece1.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                    initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                    initialPiecesPlayer.add((Integer) v.getTag());
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.add((Integer) v.getTag() + 18);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    } else {
                                        piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    }
                                } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                    if ((Integer) v.getTag() + 7 == (Integer) getPieceClicked().getTag()) {
                                        ImageView imgNotClicked = getGridView().findViewWithTag((Integer) v.getTag() - 2);
                                        imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                        getPieceClicked().setVisibility(View.INVISIBLE);
                                        initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                        initialPiecesPlayer.add((Integer) v.getTag());
                                        spacesAvailableList.remove((Integer) v.getTag());
                                        spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                        if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                            pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        } else {
                                            piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        }
                                    } else if ((Integer) v.getTag() + 9 == (Integer) getPieceClicked().getTag()) {
                                        ImageView imgNotClicked = getGridView().findViewWithTag((Integer) v.getTag() + 2);
                                        imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                        getPieceClicked().setVisibility(View.INVISIBLE);
                                        initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                        initialPiecesPlayer.add((Integer) v.getTag());
                                        spacesAvailableList.remove((Integer) v.getTag());
                                        spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                        if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                            pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        } else {
                                            piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        }
                                    }
                                } else {
                                    if ((Integer) v.getTag() + 7 == (Integer) getPieceClicked().getTag()) {
                                        ImageView imgNotClicked = getGridView().findViewWithTag((Integer) v.getTag() - 2);
                                        imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                        getPieceClicked().setVisibility(View.INVISIBLE);
                                        initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                        initialPiecesPlayer.add((Integer) v.getTag());
                                        spacesAvailableList.remove((Integer) v.getTag());
                                        spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                        if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                            pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        } else {
                                            piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        }
                                    } else if ((Integer) v.getTag() + 9 == (Integer) getPieceClicked().getTag()) {
                                        ImageView imgNotClicked = getGridView().findViewWithTag((Integer) v.getTag() + 2);
                                        imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                        getPieceClicked().setVisibility(View.INVISIBLE);
                                        initialPiecesPlayer.remove((Integer) getPieceClicked().getTag());
                                        initialPiecesPlayer.add((Integer) v.getTag());
                                        spacesAvailableList.remove((Integer) v.getTag());
                                        spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                        if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                            pieceKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        } else {
                                            piece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        }
                                    }
                                }
                            }
                        }
                        hasPieceBeenClicked = false;
                    }
                }
            });
        }
        return view;
    }
}
