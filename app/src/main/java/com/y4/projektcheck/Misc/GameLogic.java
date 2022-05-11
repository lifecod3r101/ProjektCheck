package com.y4.projektcheck.Misc;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    /*Generally, pawns can move forwards and when kings, backwards.
     * Moves: +/-7 or +/-9
     * Jumps: +/-14 or +/-18
     * for position 8, 14, 24, 30, 40, 46, 56 or 62: Moves: +/-7(depending) or +/-9(depending) */
    public void logicPlayer(boolean isPlayerOne, boolean isPlayerTwo) {


    }

    public void getSpacesAvailable(boolean currTurn, boolean visPositionsCurr, int piecePosition) {

    }

    public ArrayList<Integer> getSpacesAvailableWhileAtEdge(int piecePosition) {
        ArrayList<Integer> availablePositions = new ArrayList<>();
        int availablePosition;
        boolean clickedPositionsSev = piecePosition == 56 || piecePosition == 40 || piecePosition == 24 || piecePosition == 8;
        boolean clickedPositionsNine = piecePosition == 55 || piecePosition == 39 || piecePosition == 23;
        if (clickedPositionsSev) {
            availablePosition = piecePosition - 7;
            availablePositions.add(availablePosition);
        } else if (clickedPositionsNine) {
            availablePosition = piecePosition - 9;
            availablePositions.add(availablePosition);
        }
        return availablePositions;
    }

    public int[] getSpacesAvailableForKing(boolean currTurn, boolean visPositionsCurr, int kingPosition) {
        int[] availablePositions;
        int availablePosNumCornerBot, availablePosNumCornerTop, availablePositionMinSev, availablePositionPlusSev, availablePositionMinNine, availablePositionPlusNine;
        boolean availablePositionCornerBot = kingPosition == 56;
        boolean availablePositionCornerTop = kingPosition == 7;
        boolean availablePositionsSev = kingPosition == 40 || kingPosition == 24 || kingPosition == 8;
        boolean availablePositionsNine = kingPosition == 55 || kingPosition == 39 || kingPosition == 23;
        boolean availablePositionsEdgeTop = kingPosition == 1 || kingPosition == 3 || kingPosition == 5;
        if (availablePositionCornerBot) {
            availablePosNumCornerBot = kingPosition - 7;
            availablePositions = new int[]{availablePosNumCornerBot};
        } else if (availablePositionCornerTop) {

            availablePosNumCornerTop = kingPosition + 7;
            availablePositions = new int[]{availablePosNumCornerTop};
        } else if (availablePositionsSev) {
            availablePositionMinSev = kingPosition - 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositions = new int[]{availablePositionMinSev, availablePositionPlusNine};
        } else if (availablePositionsNine) {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionMinNine = kingPosition - 9;
            availablePositions = new int[]{availablePositionPlusSev, availablePositionMinNine};
        } else if (availablePositionsEdgeTop) {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositions = new int[]{availablePositionPlusSev, availablePositionPlusNine};
        } else {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositionMinSev = kingPosition - 7;
            availablePositionMinNine = kingPosition - 9;
            availablePositions = new int[]{availablePositionPlusSev, availablePositionPlusNine, availablePositionMinSev, availablePositionMinNine};
        }
        return availablePositions;

    }

    public void getSpacesAvailableAfterElimination(boolean currTurn, boolean visPositionsCurr, int piecePosition) {

    }
}
