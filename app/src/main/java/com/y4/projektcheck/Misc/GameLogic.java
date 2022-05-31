package com.y4.projektcheck.Misc;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.y4.projektcheck.Presenters.GameSessionPresenter;
import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameLogic {

    private final ArrayList<Integer> spacesAvailableList = new ArrayList<>();
    private final ArrayList<Integer> initialPiecesPlayer = new ArrayList<>();
    private final ArrayList<Integer> initialPiecesOpp = new ArrayList<>();
    private boolean hasPieceBeenClicked, spacesAvailable, hasKingPieceBeenClicked;
    private View view;
    private int pieceClicked, reflectedPieceClicked, reflectedKingPieceClicked;
    private String gameSessionId, hostId, oppId;
    private GameSessionPresenter presenter = new GameSessionPresenter();
    private boolean playerMoveMade, oppMoveMade;
    private Intent intent;
    private boolean isTurn;
    private String playerOneStr, playerTwoStr;
    private View v;


    public void setPlayerOneStr(String playerOneStr) {
        this.playerOneStr = playerOneStr;
    }

    public String getPlayerOneStr() {
        return playerOneStr;
    }

    public void setPlayerTwoStr(String playerTwoStr) {
        this.playerTwoStr = playerTwoStr;
    }

    public String getPlayerTwoStr() {
        return playerTwoStr;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setPlayerMoveMade(boolean playerMoveMade) {
        this.playerMoveMade = playerMoveMade;
    }

    public boolean isPlayerMoveMade() {
        return playerMoveMade;
    }

    public void setOppMoveMade(boolean oppMoveMade) {
        this.oppMoveMade = oppMoveMade;
    }

    public boolean isOppMoveMade() {
        return oppMoveMade;
    }

    public boolean isHasPieceBeenClicked() {
        return hasPieceBeenClicked;
    }

    public void setHasPieceBeenClicked(boolean hasPieceBeenClicked) {
        this.hasPieceBeenClicked = hasPieceBeenClicked;
    }

    public GameLogic() {

    }


    public boolean isSpacesAvailable() {
        return spacesAvailable;
    }

    public void setSpacesAvailable(boolean spacesAvailable) {
        this.spacesAvailable = spacesAvailable;
    }

    public View getPieceClicked() {
        return view;
    }

    public View getKingPieceClicked() {
        return view;
    }

    public void setHasKingPieceBeenClicked(boolean hasKingPieceBeenClicked) {
        this.hasKingPieceBeenClicked = hasKingPieceBeenClicked;
    }

    public boolean isHasKingPieceBeenClicked() {
        return hasKingPieceBeenClicked;
    }

    public void setPieceClicked(int pieceClicked, View view) {
        this.pieceClicked = pieceClicked;
        this.view = view;
    }

    public void setReflectedPieceClicked(int reflectedPieceClicked) {
        this.reflectedPieceClicked = reflectedPieceClicked;
    }

    public int getReflectedPieceClicked() {
        return reflectedPieceClicked;
    }

    public void setReflectedKingPieceClicked(int reflectedKingPieceClicked) {
        this.reflectedKingPieceClicked = reflectedKingPieceClicked;
    }

    public int getReflectedKingPieceClicked() {
        return reflectedKingPieceClicked;
    }

    public void setKingPieceClicked(int pieceClicked, View view) {
        this.pieceClicked = pieceClicked;
        this.view = view;
    }

    public void gameLogicDef(int spacePosition, boolean isPlayerOne, String colourChosen, View view, GridView gridView, ImageView imageView, ImageButton buttonPiece1, ImageButton buttonPiece2, ImageButton buttonKing1, ImageButton buttonKing2) {
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
        imageView.setTag(spacePosition);
        buttonPiece1.setTag(spacePosition);
        buttonPiece2.setTag(spacePosition);
        buttonKing1.setTag(spacePosition);
        buttonKing2.setTag(spacePosition);
        spacesAvailableList.add(24);
        spacesAvailableList.add(26);
        spacesAvailableList.add(28);
        spacesAvailableList.add(30);
        spacesAvailableList.add(33);
        spacesAvailableList.add(35);
        spacesAvailableList.add(37);
        spacesAvailableList.add(39);
        if (!isPlayerOne && colourChosen.equals("White")) {
            if (visCurrPlayer) {
                buttonPiece2.setVisibility(View.VISIBLE);
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
            if (visOppPlayer) {
                buttonPiece1.setVisibility(View.VISIBLE);
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
            }
        } else if (isPlayerOne && colourChosen.equals("White")) {
            if (visCurrPlayer) {
                buttonPiece2.setVisibility(View.VISIBLE);
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
            if (visOppPlayer) {
                buttonPiece1.setVisibility(View.VISIBLE);
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
            }
        } else if (!isPlayerOne && colourChosen.equals("Yellow")) {
            if (visCurrPlayer) {
                buttonPiece1.setVisibility(View.VISIBLE);
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
            if (visOppPlayer) {
                buttonPiece2.setVisibility(View.VISIBLE);
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
            }
        } else if (isPlayerOne && colourChosen.equals("Yellow")) {
            if (visCurrPlayer) {
                buttonPiece1.setVisibility(View.VISIBLE);
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
            if (visOppPlayer) {
                buttonPiece2.setVisibility(View.VISIBLE);
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
            }
        }

        if (colourChosen.equals("White")) {
            buttonPiece2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setPieceClicked((Integer) v.getTag(), v);
                    setReflectedPieceClicked(reflectPosition((Integer) v.getTag()));
                }
            });
            buttonKing2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasKingPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setKingPieceClicked((Integer) v.getTag(), v);
                    setReflectedKingPieceClicked(reflectPosition((Integer) v.getTag()));
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSpacesAvailable()) {
                        ImageView imageClicked = gridView.findViewWithTag(v.getTag());
                        imageClicked.setImageResource(R.drawable.ic_checker_board_part);
                        boolean spaceClickedNegSev = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 7;
                        boolean spaceClickedNegNine = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 9;
                        boolean spaceClickedKingNegSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 7;
                        boolean spaceClickedKingNegNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 9;
                        boolean spaceClickedKingPlusSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 7;
                        boolean spaceClickedKingPlusNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 9;
                        if (isHasKingPieceBeenClicked()) {
                            if (initialPiecesOpp.contains((Integer) v.getTag())) {

                            } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedKingPlusSev) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingPlusNine) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegSev) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegNine) {
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                }
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() - 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 9);
                                spacesAvailableList.add((Integer) v.getTag() - 18);
                                buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() - 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 9, (Integer) getKingPieceClicked().getTag());
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() - 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 7);
                                spacesAvailableList.add((Integer) v.getTag() - 14);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() - 7).setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 7, (Integer) getKingPieceClicked().getTag());
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getKingPieceClicked().getTag());
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getKingPieceClicked().getTag());
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            } else {
                                spacesAvailableList.remove((Integer) v.getTag());
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                } else if ((Integer) v.getTag() == 8 || (Integer) v.getTag() == 24 || (Integer) v.getTag() == 40) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);

                                } else if ((Integer) v.getTag() == 23 || (Integer) v.getTag() == 39 || (Integer) v.getTag() == 55) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                } else if ((Integer) v.getTag() == 58 || (Integer) v.getTag() == 60 || (Integer) v.getTag() == 62) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                } else if ((Integer) v.getTag() == 56) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                } else if ((Integer) v.getTag() == 7) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                } else {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                }
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                if (isHasPieceBeenClicked()) {

                                } else {
                                    buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                    hasKingPieceBeenClicked = false;
                                }
                            }
                        } else if (isHasPieceBeenClicked()) {
                            if (initialPiecesOpp.contains((Integer) v.getTag())) {

                            } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7);
                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7);
                                    }
                                    hasPieceBeenClicked = false;
                                } else if (spaceClickedNegNine) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() + 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9);
                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9);
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                } else {
                                    buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                }
                                hasPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                } else {
                                    buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                }
                                hasPieceBeenClicked = false;
                            } else {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7);
                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7);
                                    }
                                    hasPieceBeenClicked = false;
                                } else if (spaceClickedNegNine) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() + 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9);
                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9);
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            }
                        }
                    }
                }
            });
        } else {
            buttonPiece1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setPieceClicked((Integer) v.getTag(), v);
                    setReflectedPieceClicked(reflectPosition((Integer) v.getTag()));
                }
            });
            buttonKing1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setPieceClicked((Integer) v.getTag(), v);
                    setReflectedKingPieceClicked(reflectPosition((Integer) v.getTag()));
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSpacesAvailable()) {
                        ImageView imageClicked = gridView.findViewWithTag(v.getTag());
                        imageClicked.setImageResource(R.drawable.ic_checker_board_part);
                        boolean spaceClickedNegSev = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 7;
                        boolean spaceClickedNegNine = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 9;
                        boolean spaceClickedKingNegSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 7;
                        boolean spaceClickedKingNegNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 9;
                        boolean spaceClickedKingPlusSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 7;
                        boolean spaceClickedKingPlusNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 9;
                        if (isHasKingPieceBeenClicked()) {
                            if (initialPiecesOpp.contains((Integer) v.getTag())) {

                            } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedKingPlusSev) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingPlusNine) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegSev) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegNine) {
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                        hasKingPieceBeenClicked = false;
                                    }
                                }
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() - 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 9);
                                spacesAvailableList.add((Integer) v.getTag() - 18);
                                buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() - 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 9, (Integer) getKingPieceClicked().getTag());
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() - 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 7);
                                spacesAvailableList.add((Integer) v.getTag() - 14);
                                buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() - 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 7, (Integer) getKingPieceClicked().getTag());
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getKingPieceClicked().getTag());
                                hasKingPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getKingPieceClicked().getTag());
                                hasKingPieceBeenClicked = false;
                            } else {
                                spacesAvailableList.remove((Integer) v.getTag());
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);

                                } else if ((Integer) v.getTag() == 8 || (Integer) v.getTag() == 24 || (Integer) v.getTag() == 40) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);

                                } else if ((Integer) v.getTag() == 23 || (Integer) v.getTag() == 39 || (Integer) v.getTag() == 55) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);

                                } else if ((Integer) v.getTag() == 58 || (Integer) v.getTag() == 60 || (Integer) v.getTag() == 62) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);

                                } else if ((Integer) v.getTag() == 56) {
                                    spacesAvailableList.add((Integer) v.getTag() - 7);

                                } else if ((Integer) v.getTag() == 7) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);

                                } else {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.add((Integer) v.getTag() - 9);

                                }
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                if (isHasPieceBeenClicked()) {

                                } else {
                                    buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getKingPieceClicked().getTag());
                                    hasKingPieceBeenClicked = false;
                                }
                            }
                        } else if (isHasPieceBeenClicked()) {
                            if (initialPiecesOpp.contains((Integer) v.getTag())) {

                            } else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getPieceClicked().getTag());
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getPieceClicked().getTag());
                                    }
                                    hasPieceBeenClicked = false;
                                } else if (spaceClickedNegNine) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() + 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getPieceClicked().getTag());
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) getPieceClicked().getTag());
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                } else {
                                    buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                }
                                hasPieceBeenClicked = false;
                            } else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                } else {
                                    buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    presenter.getEliminatedPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                }
                                hasPieceBeenClicked = false;
                            } else {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), ((Integer) getPieceClicked().getTag()));
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), ((Integer) getPieceClicked().getTag()));
                                    }
                                    hasPieceBeenClicked = false;
                                } else if (spaceClickedNegNine) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() + 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), ((Integer) getPieceClicked().getTag()));
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), ((Integer) getPieceClicked().getTag()));
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            }
                        }
                    }
                }
            });
        }
        disablePieces(colourChosen, buttonPiece1, buttonPiece2, buttonKing1, buttonKing2);
    }

    public void disablePieces(String colourChosen, ImageView piece1, ImageView piece2, ImageView king1, ImageView king2) {
        if (GameSessionPresenter.isDisabledForP1 || GameSessionPresenter.isDisabledForP2) {
            if (colourChosen.equals("White")) {
                piece2.setEnabled(false);
                king2.setEnabled(false);
            } else {
                piece1.setEnabled(false);
                king1.setEnabled(false);
            }
        }
    }

    public Integer reflectPosition(int piecePos) {
        int newPos = 0;
        if (piecePos == 1) {
            newPos = piecePos + 61;
        } else if (piecePos == 3) {
            newPos = piecePos + 57;
        } else if (piecePos == 5) {
            newPos = piecePos + 53;
        } else if (piecePos == 7) {
            newPos = piecePos + 49;
        } else if (piecePos == 8) {
            newPos = piecePos + 47;
        } else if (piecePos == 10) {
            newPos = piecePos + 43;
        } else if (piecePos == 12) {
            newPos = piecePos + 39;
        } else if (piecePos == 14) {
            newPos = piecePos + 35;
        } else if (piecePos == 17) {
            newPos = piecePos + 29;
        } else if (piecePos == 19) {
            newPos = piecePos + 25;
        } else if (piecePos == 21) {
            newPos = piecePos + 21;
        } else if (piecePos == 23) {
            newPos = piecePos + 17;
        } else if (piecePos == 24) {
            newPos = piecePos + 15;
        } else if (piecePos == 26) {
            newPos = piecePos + 11;
        } else if (piecePos == 28) {
            newPos = piecePos + 7;
        } else if (piecePos == 30) {
            newPos = piecePos + 3;
        } else if (piecePos == 33) {
            newPos = piecePos - 3;
        } else if (piecePos == 35) {
            newPos = piecePos - 7;
        } else if (piecePos == 37) {
            newPos = piecePos - 11;
        } else if (piecePos == 39) {
            newPos = piecePos - 15;
        } else if (piecePos == 40) {
            newPos = piecePos - 17;
        } else if (piecePos == 42) {
            newPos = piecePos - 21;
        } else if (piecePos == 44) {
            newPos = piecePos - 25;
        } else if (piecePos == 46) {
            newPos = piecePos - 29;
        } else if (piecePos == 49) {
            newPos = piecePos - 35;
        } else if (piecePos == 51) {
            newPos = piecePos - 39;
        } else if (piecePos == 53) {
            newPos = piecePos - 43;
        } else if (piecePos == 55) {
            newPos = piecePos - 47;
        } else if (piecePos == 56) {
            newPos = piecePos - 49;
        } else if (piecePos == 58) {
            newPos = piecePos - 53;
        } else if (piecePos == 60) {
            newPos = piecePos - 57;
        } else if (piecePos == 62) {
            newPos = piecePos - 61;
        }
        return newPos;
    }
}