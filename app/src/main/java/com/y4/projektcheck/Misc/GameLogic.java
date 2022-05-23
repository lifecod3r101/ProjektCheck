package com.y4.projektcheck.Misc;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.y4.projektcheck.R;

import java.util.ArrayList;

public class GameLogic {

    private final ArrayList<Integer> spacesAvailableList = new ArrayList<>();
    private final ArrayList<Integer> initialPiecesPlayer = new ArrayList<>();
    private final ArrayList<Integer> initialPiecesOpp = new ArrayList<>();
    private boolean hasPieceBeenClicked, spacesAvailable, hasKingPieceBeenClicked;
    private View view;
    private int pieceClicked;

    public boolean isHasPieceBeenClicked() {
        return hasPieceBeenClicked;
    }

    public void setHasPieceBeenClicked(boolean hasPieceBeenClicked) {
        this.hasPieceBeenClicked = hasPieceBeenClicked;
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
                }
            });
            buttonKing2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasKingPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setKingPieceClicked((Integer) v.getTag(), v);
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

                            }

                            else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedKingPlusSev) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingPlusNine) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegSev) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegNine) {
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                }
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() - 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 9);
                                spacesAvailableList.add((Integer) v.getTag() - 18);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() - 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() - 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 7);
                                spacesAvailableList.add((Integer) v.getTag() - 14);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() - 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                buttonKing2.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else {
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
                                    hasKingPieceBeenClicked = false;
                                }

                            }
                        }

                        else if (isHasPieceBeenClicked()) {
                            if (initialPiecesOpp.contains((Integer) v.getTag())) {

                            }
                            else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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

                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                } else {
                                    buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                }
                                hasPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                buttonPiece1.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                getPieceClicked().setVisibility(View.INVISIBLE);
                                if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                    buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                } else {
                                    buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                }
                                hasPieceBeenClicked = false;
                            }



                            else {
                                if (spaceClickedNegSev) {
                                    ImageView imgNotClicked = gridView.findViewWithTag((Integer) v.getTag() - 2);
                                    imgNotClicked.setImageResource(R.drawable.ic_checker_board_part);
                                    getPieceClicked().setVisibility(View.INVISIBLE);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                        buttonKing2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);

                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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

                                    } else {
                                        buttonPiece2.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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
                }
            });
            buttonKing1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPieceBeenClicked = true;
                    setSpacesAvailable(true);
                    setPieceClicked((Integer) v.getTag(), v);
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

                            }
                            else if (spacesAvailableList.contains((Integer) v.getTag())) {
                                if (spaceClickedKingPlusSev) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 7);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingPlusNine) {
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    spacesAvailableList.add((Integer) v.getTag() - 9);
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegSev) {
                                    spacesAvailableList.add((Integer) v.getTag() + 7);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                } else if (spaceClickedKingNegNine) {
                                    spacesAvailableList.add((Integer) v.getTag() + 9);
                                    spacesAvailableList.remove((Integer) v.getTag());
                                    getKingPieceClicked().setVisibility(View.INVISIBLE);
                                    if (isHasPieceBeenClicked()) {

                                    } else {
                                        buttonKing1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                        hasKingPieceBeenClicked = false;
                                    }
                                }
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() - 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 9);
                                spacesAvailableList.add((Integer) v.getTag() - 18);
                                buttonKing1.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() - 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() - 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() - 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() - 7);
                                spacesAvailableList.add((Integer) v.getTag() - 14);
                                buttonKing1.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() - 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 9) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 9);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 9);
                                spacesAvailableList.add((Integer) v.getTag() + 18);
                                buttonKing1.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 9).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else if (initialPiecesOpp.contains((Integer) v.getTag() + 7) && spacesAvailableList.contains((Integer) v.getTag())) {
                                initialPiecesOpp.remove((Integer) v.getTag() + 7);
                                spacesAvailableList.remove((Integer) v.getTag());
                                spacesAvailableList.add((Integer) v.getTag() + 7);
                                spacesAvailableList.add((Integer) v.getTag() + 14);
                                buttonKing1.findViewWithTag((Integer) v.getTag()).setVisibility(View.VISIBLE);
                                buttonPiece2.findViewWithTag((Integer) v.getTag() + 7).setVisibility(View.INVISIBLE);
                                getKingPieceClicked().setVisibility(View.INVISIBLE);
                                hasKingPieceBeenClicked = false;
                            }

                            else {
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

                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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

                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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
                                } else {
                                    buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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
                                } else {
                                    buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
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
                                    } else {
                                        buttonPiece1.findViewWithTag(v.getTag()).setVisibility(View.VISIBLE);
                                    }
                                    hasPieceBeenClicked = false;
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}