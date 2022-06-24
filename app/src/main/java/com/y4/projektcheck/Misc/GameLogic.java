package com.y4.projektcheck.Misc;

import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.y4.projektcheck.Presenters.GameSessionPresenter;
import com.y4.projektcheck.R;
import com.y4.projektcheck.Views.GameSessionActivity;

import java.util.ArrayList;
import java.util.Objects;

public class GameLogic {
    public static ArrayList<Integer> spacesAvailableList = new ArrayList<>();
    private boolean hasPieceBeenClicked, spacesAvailable, hasKingPieceBeenClicked;
    private View view;
    private int pieceClicked, reflectedPieceClicked, reflectedKingPieceClicked;
    private boolean playerMoveMade, oppMoveMade;
    private String playerOneStr, playerTwoStr;

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

    public void gameSetupDef(int spacePosition, boolean isPlayerOne, String colourChosen, View view, RecyclerView gridView, ShapeableImageView imageView, ImageButton buttonPieceYellow, ImageButton buttonPieceWhite, ImageButton buttonKingYellow, ImageButton buttonKingWhite) {
        GameSessionPresenter presenter = new GameSessionPresenter();
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
        buttonPieceYellow.setTag(spacePosition);
        buttonPieceWhite.setTag(spacePosition);
        buttonKingYellow.setTag(spacePosition);
        buttonKingWhite.setTag(spacePosition);
        if (!isPlayerOne && colourChosen.equals("White")) {
            if (visCurrPlayer) {
                buttonPieceWhite.setVisibility(View.VISIBLE);
            } else if (visOppPlayer) {
                buttonPieceYellow.setVisibility(View.VISIBLE);
            }
        } else if (isPlayerOne && colourChosen.equals("White")) {
            if (visCurrPlayer) {
                buttonPieceWhite.setVisibility(View.VISIBLE);
            } else if (visOppPlayer) {
                buttonPieceYellow.setVisibility(View.VISIBLE);
            }
        } else if (!isPlayerOne && colourChosen.equals("Yellow")) {
            if (visCurrPlayer) {
                buttonPieceYellow.setVisibility(View.VISIBLE);
            } else if (visOppPlayer) {
                buttonPieceWhite.setVisibility(View.VISIBLE);
            }
        } else if (isPlayerOne && colourChosen.equals("Yellow")) {
            if (visCurrPlayer) {
                buttonPieceYellow.setVisibility(View.VISIBLE);
            } else if (visOppPlayer) {
                buttonPieceWhite.setVisibility(View.VISIBLE);
            }
        }
        spacesAvailableList.add(24);
        spacesAvailableList.add(26);
        spacesAvailableList.add(28);
        spacesAvailableList.add(30);
        spacesAvailableList.add(33);
        spacesAvailableList.add(35);
        spacesAvailableList.add(37);
        spacesAvailableList.add(39);

        if (colourChosen.equals("White")) {
            buttonPieceWhite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasKingPieceBeenClicked()) {
                        setHasKingPieceBeenClicked(false);
                    } else {
                        setHasPieceBeenClicked(true);
                        setSpacesAvailable(true);
                        setPieceClicked((Integer) v.getTag(), v);
                        setReflectedPieceClicked(reflectPosition((Integer) v.getTag()));
                    }
                }
            });
            buttonKingWhite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasPieceBeenClicked()) {
                        setHasPieceBeenClicked(false);
                    } else {
                        setHasKingPieceBeenClicked(true);
                        setSpacesAvailable(true);
                        setKingPieceClicked((Integer) v.getTag(), v);
                        setReflectedKingPieceClicked(reflectPosition((Integer) v.getTag()));
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!GameSessionActivity.isYourTurn) {

                    } else {
                        if (isSpacesAvailable()) {
                            boolean spaceClickedNegSev = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 7;
                            boolean spaceClickedNegNine = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 9;
                            boolean spaceClickedKingNegSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 7;
                            boolean spaceClickedKingNegNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 9;
                            boolean spaceClickedKingPlusSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 7;
                            boolean spaceClickedKingPlusNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 9;
                            boolean spaceClickedNegFort = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 14;
                            boolean spaceClickedNegEght = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 18;
                            boolean spaceClickedKingNegFort = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 14;
                            boolean spaceClickedKingNegEght = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 18;
                            boolean spaceClickedKingPlusFort = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 14;
                            boolean spaceClickedKingPlusEght = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 18;
                            boolean spaceFilled = gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE || gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                            boolean spaceFilledByOwn = gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE || gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                            if (isHasKingPieceBeenClicked()) {
                                if (spacesAvailableList.contains((Integer) v.getTag()) || spacesAvailableList.contains(reflectPosition((Integer) v.getTag()))) {
                                    if (spaceClickedKingPlusSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingPlusNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegFort) {
                                        boolean visibleFort = gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleFort = gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleFort || visibleFort) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 7);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegEght) {
                                        boolean visibleEght = gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleEght = gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleEght || visibleEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 9);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingPlusFort) {
                                        boolean ownKingVisibleNegFort = gridView.getChildAt((int) v.getTag() - 7).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        boolean visibleNegFort = gridView.getChildAt((int) v.getTag() - 7).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleNegFort || visibleNegFort) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 7).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 7).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() - 7);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 7, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingPlusEght) {
                                        boolean visibleNegEght = gridView.getChildAt((int) v.getTag() - 9).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleNegEght = gridView.getChildAt((int) v.getTag() - 9).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleNegEght || visibleNegEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 9).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 9).findViewById(R.id.checker_board_king_1).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() - 9);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 9, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    }
                                } else {
                                    if (spaceFilled || spaceFilledByOwn) {

                                    } else {
                                        getKingPieceClicked().setVisibility(View.INVISIBLE);
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
                                        gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                        setHasKingPieceBeenClicked(false);
                                    }
                                }
                            } else if (isHasPieceBeenClicked()) {

                                if (spacesAvailableList.contains((Integer) v.getTag()) || spacesAvailableList.contains(reflectPosition((Integer) v.getTag()))) {
                                    if (spaceClickedNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegFort) {
                                        boolean kingVisibleFort = gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleFort = gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        boolean visibleFort = gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || kingVisibleFort || ownKingVisibleFort || visibleFort) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 7);
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegEght) {
                                        boolean kingVisibleEght = gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleEght = gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        boolean visibleEght = gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || kingVisibleEght || ownKingVisibleEght || visibleEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_1).setVisibility(View.INVISIBLE);
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 9);
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    }
                                } else {
                                    if (spaceClickedNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_2).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            });
        } else {
            buttonPieceYellow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasKingPieceBeenClicked()) {
                        setHasKingPieceBeenClicked(false);
                    } else {
                        setHasPieceBeenClicked(true);
                        setSpacesAvailable(true);
                        setPieceClicked((Integer) v.getTag(), v);
                        setReflectedPieceClicked(reflectPosition((Integer) v.getTag()));
                    }
                }
            });
            buttonKingYellow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHasPieceBeenClicked()) {
                        setHasPieceBeenClicked(false);
                    } else {
                        setHasKingPieceBeenClicked(true);
                        setSpacesAvailable(true);
                        setKingPieceClicked((Integer) v.getTag(), v);
                        setReflectedKingPieceClicked(reflectPosition((Integer) v.getTag()));
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!GameSessionActivity.isYourTurn) {

                    } else {
                        if (isSpacesAvailable()) {
                            boolean spaceClickedNegSev = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 7;
                            boolean spaceClickedNegNine = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 9;
                            boolean spaceClickedKingNegSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 7;
                            boolean spaceClickedKingNegNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 9;
                            boolean spaceClickedKingPlusSev = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 7;
                            boolean spaceClickedKingPlusNine = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 9;
                            boolean spaceClickedNegFort = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 14;
                            boolean spaceClickedNegEght = (Integer) v.getTag() == (Integer) getPieceClicked().getTag() - 18;
                            boolean spaceClickedKingNegFort = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 14;
                            boolean spaceClickedKingNegEght = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() - 18;
                            boolean spaceClickedKingPlusFort = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 14;
                            boolean spaceClickedKingPlusEght = (Integer) v.getTag() == (Integer) getKingPieceClicked().getTag() + 18;
                            boolean spaceEdge = (Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7;
                            boolean spaceEdgeReflect = Objects.equals((Integer) v.getTag(), reflectPosition((int) 1)) || Objects.equals((Integer) v.getTag(), reflectPosition((int) 3)) || Objects.equals((Integer) v.getTag(), reflectPosition((int) 5)) || Objects.equals((Integer) v.getTag(), reflectPosition((int) 7));
                            boolean spaceFilled = gridView.getChildAt((int) v.getTag()).findViewById(R.id.checker_board_man_2).getVisibility() == View.VISIBLE || gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                            boolean spaceFilledByOwn = gridView.getChildAt((int) v.getTag()).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE || gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                            if (isHasKingPieceBeenClicked()) {
                                if (spacesAvailableList.contains((Integer) v.getTag()) || spacesAvailableList.contains(reflectPosition((Integer) v.getTag()))) {
                                    if (spaceClickedKingPlusSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingPlusNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                            presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                            setHasKingPieceBeenClicked(false);
                                        }
                                    } else if (spaceClickedKingNegFort) {
                                        boolean visibleFort = gridView.getChildAt((int) v.getTag() + 7).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleFort = gridView.getChildAt((int) v.getTag() + 7).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleFort || visibleFort) {

                                        } else {
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 7);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            if (spaceEdge) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedKingNegEght) {
                                        boolean visibleEght = gridView.getChildAt((int) v.getTag() + 9).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleEght = gridView.getChildAt((int) v.getTag() + 9).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleEght || visibleEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 9);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            if (spaceEdge) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedKingPlusFort) {
                                        boolean visibleNegFort = gridView.getChildAt((int) v.getTag() - 7).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleNegFort = gridView.getChildAt((int) v.getTag() - 7).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleNegFort || visibleNegFort) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() - 7).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 7).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() - 7);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            if (spaceEdgeReflect) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 7, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 7, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedKingPlusEght) {
                                        boolean visibleNegEght = gridView.getChildAt((int) v.getTag() - 9).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleNegEght = gridView.getChildAt((int) v.getTag() - 9).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || ownKingVisibleNegEght || visibleNegEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() - 9).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            gridView.getChildAt((Integer) v.getTag() - 9).findViewById(R.id.checker_board_king_2).setVisibility(View.INVISIBLE);
                                            getKingPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() - 9);
                                            spacesAvailableList.add((Integer) getKingPieceClicked().getTag());
                                            if (spaceEdgeReflect) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 9, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() - 9, (Integer) getKingPieceClicked().getTag());
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    }
                                } else {
                                    if (spaceFilled || spaceFilledByOwn) {

                                    } else {
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
                                        gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                        presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getKingPieceClicked().getTag());
                                        setHasKingPieceBeenClicked(false);
                                    }
                                }
                            } else if (isHasPieceBeenClicked()) {
                                if (spacesAvailableList.contains((Integer) v.getTag()) || spacesAvailableList.contains(reflectPosition((Integer) v.getTag()))) {
                                    if (spaceClickedNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {


                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegFort) {
                                        boolean ownKingVisibleFort = gridView.getChildAt((int) v.getTag() + 7).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        boolean visibleFort = gridView.getChildAt((int) v.getTag() + 7).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean kingVisibleFort = gridView.getChildAt((int) v.getTag() + 7).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || kingVisibleFort || ownKingVisibleFort || visibleFort) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() + 7).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 7);
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 7, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegEght) {
                                        boolean kingVisibleEght = gridView.getChildAt((int) v.getTag() + 9).findViewById(R.id.checker_board_king_2).getVisibility() == View.VISIBLE;
                                        boolean visibleEght = gridView.getChildAt((int) v.getTag() + 9).findViewById(R.id.checker_board_man_1).getVisibility() == View.VISIBLE;
                                        boolean ownKingVisibleEght = gridView.getChildAt((int) v.getTag() + 9).findViewById(R.id.checker_board_king_1).getVisibility() == View.VISIBLE;
                                        if (spaceFilled || spaceFilledByOwn || kingVisibleEght || ownKingVisibleEght || visibleEght) {

                                        } else {
                                            gridView.getChildAt((Integer) v.getTag() + 9).findViewById(R.id.checker_board_man_2).setVisibility(View.INVISIBLE);
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) v.getTag() + 9);
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), (Integer) v.getTag() + 9, (Integer) getPieceClicked().getTag());
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    }
                                } else {
                                    if (spaceClickedNegSev) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    } else if (spaceClickedNegNine) {
                                        if (spaceFilled || spaceFilledByOwn) {

                                        } else {
                                            getPieceClicked().setVisibility(View.INVISIBLE);
                                            spacesAvailableList.remove((Integer) v.getTag());
                                            spacesAvailableList.add((Integer) getPieceClicked().getTag());
                                            if ((Integer) v.getTag() == 1 || (Integer) v.getTag() == 3 || (Integer) v.getTag() == 5 || (Integer) v.getTag() == 7) {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_king_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            } else {
                                                gridView.getChildAt((Integer) v.getTag()).findViewById(R.id.checker_board_man_1).setVisibility(View.VISIBLE);
                                                presenter.getPlayerMove((Integer) v.getTag(), reflectPosition((Integer) v.getTag()), 0, ((Integer) getPieceClicked().getTag()));
                                                setHasPieceBeenClicked(false);
                                                setHasKingPieceBeenClicked(false);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
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