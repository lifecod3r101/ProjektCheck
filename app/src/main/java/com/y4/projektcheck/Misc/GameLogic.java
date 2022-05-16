package com.y4.projektcheck.Misc;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    /*Generally, pawns can move forwards and when kings, backwards.
     * Moves: +/-7 or +/-9
     * Jumps: +/-14 or +/-18
     * for position 8, 14, 24, 30, 40, 46, 56 or 62: Moves: +/-7(depending) or +/-9(depending) */


    public ArrayList<Integer> getSpacesAvailable(int piecePosition) {
        ArrayList<Integer> availablePositions = new ArrayList<>();
        int availablePosition, availablePositionSev, availablePositionNine;
        boolean clickedPositionsSev = piecePosition == 56 || piecePosition == 40 || piecePosition == 24 || piecePosition == 8;
        boolean clickedPositionsNine = piecePosition == 55 || piecePosition == 39 || piecePosition == 23;
        boolean exceptSpace = piecePosition == 1 || piecePosition == 3 || piecePosition == 5 || piecePosition == 7;
        if (!exceptSpace) {
            if (clickedPositionsSev) {
                availablePosition = piecePosition - 7;
                availablePositions.add(availablePosition);
            } else if (clickedPositionsNine) {
                availablePosition = piecePosition - 9;
                availablePositions.add(availablePosition);
            } else {
                availablePositionSev = piecePosition - 7;
                availablePositionNine = piecePosition - 9;
                availablePositions.add(availablePositionSev);
                availablePositions.add(availablePositionNine);
            }
        }
        return availablePositions;
    }

    public ArrayList<Integer> getSpacesAvailableForKing(int kingPosition) {
        ArrayList<Integer> availablePositions = new ArrayList<>();
        int availablePosNumCornerBot, availablePosNumCornerTop, availablePositionMinSev, availablePositionPlusSev, availablePositionMinNine, availablePositionPlusNine;
        boolean availablePositionCornerBot = kingPosition == 56;
        boolean availablePositionCornerTop = kingPosition == 7;
        boolean availablePositionsSev = kingPosition == 40 || kingPosition == 24 || kingPosition == 8;
        boolean availablePositionsNine = kingPosition == 55 || kingPosition == 39 || kingPosition == 23;
        boolean availablePositionsEdgeTop = kingPosition == 1 || kingPosition == 3 || kingPosition == 5;
        if (availablePositionCornerBot) {
            availablePosNumCornerBot = kingPosition - 7;
            availablePositions.add(availablePosNumCornerBot);
        } else if (availablePositionCornerTop) {
            availablePosNumCornerTop = kingPosition + 7;
            availablePositions.add(availablePosNumCornerTop);
        } else if (availablePositionsSev) {
            availablePositionMinSev = kingPosition - 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositions.add(availablePositionMinSev);
            availablePositions.add(availablePositionPlusNine);
        } else if (availablePositionsNine) {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionMinNine = kingPosition - 9;
            availablePositions.add(availablePositionPlusSev);
            availablePositions.add(availablePositionMinNine);
        } else if (availablePositionsEdgeTop) {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositions.add(availablePositionPlusSev);
            availablePositions.add(availablePositionPlusNine);
        } else {
            availablePositionPlusSev = kingPosition + 7;
            availablePositionPlusNine = kingPosition + 9;
            availablePositionMinSev = kingPosition - 7;
            availablePositionMinNine = kingPosition - 9;
            availablePositions.add(availablePositionPlusSev);
            availablePositions.add(availablePositionPlusNine);
            availablePositions.add(availablePositionMinSev);
            availablePositions.add(availablePositionMinNine);
        }
        return availablePositions;
    }

    public ArrayList<Integer> getSpacesAvailableForElimination(int piecePosition) {
        ArrayList<Integer> spacesEliminate = new ArrayList<>();
        int spaceAvailable, spaceAvailableEight, spaceAvailableFour;
        boolean spacesTappedEdgeSideLeft = piecePosition == 56 || piecePosition == 49 || piecePosition == 40 || piecePosition == 33 || piecePosition == 24 || piecePosition == 17;
        boolean spacesTappedEdgeSideRight = piecePosition == 62 || piecePosition == 55 || piecePosition == 46 || piecePosition == 39 || piecePosition == 30 || piecePosition == 23;
        boolean spacesException = piecePosition == 1 || piecePosition == 3 || piecePosition == 5 || piecePosition == 7 || piecePosition == 8 || piecePosition == 10 || piecePosition == 12 || piecePosition == 14;
        if (!spacesException) {
            if (spacesTappedEdgeSideLeft) {
                spaceAvailable = piecePosition - 14;
                spacesEliminate.add(spaceAvailable);
            } else if (spacesTappedEdgeSideRight) {
                spaceAvailable = piecePosition - 18;
                spacesEliminate.add(spaceAvailable);
            } else {
                spaceAvailableFour = piecePosition - 14;
                spaceAvailableEight = piecePosition - 18;
                spacesEliminate.add(spaceAvailableFour);
                spacesEliminate.add(spaceAvailableEight);
            }
        }
        return spacesEliminate;
    }
}
