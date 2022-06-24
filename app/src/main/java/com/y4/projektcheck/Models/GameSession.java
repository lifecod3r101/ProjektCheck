package com.y4.projektcheck.Models;

import com.google.firebase.firestore.DocumentId;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GameSession {
    private Date gameStartTime, gameEndTime;

    @DocumentId
    private String gameSessionId;

    private String currSessionId;

    private Map<String, Object> gameSessionPlayers = new HashMap<>();
    private Map<String, Integer> gameSessionPlayerMoves = new HashMap<>();
    private Map<String, Integer> gameSessionPlayerScores = new HashMap<>();
    private Map<String, Integer> eliminatedPiecesCount = new HashMap<>();
    private Boolean playerFound, playerOneTurn, playerTwoTurn;
    private String playerOneColour, playerTwoColour, playerHostId;
    private boolean hostTerminate, oppLeft, gameEnded;


    public GameSession() {
    }

    public GameSession(String currSessionId,Date gameStartTime, Date gameEndTime, String gameSessionId, Map<String, Object> gameSessionPlayers, Map<String, Integer> gameSessionPlayerScores, Map<String, Integer> gameSessionPlayerMoves, Boolean playerFound, String playerOneColour, String playerTwoColour, Boolean playerOneTurn, Boolean playerTwoTurn, String playerHostId, Map<String, Integer> eliminatedPiecesCount, boolean hostTerminate, boolean oppLeft, boolean gameEnded) {
        this.currSessionId=currSessionId;
        this.gameStartTime = gameStartTime;
        this.gameEndTime = gameEndTime;
        this.gameSessionId = gameSessionId;
        this.gameSessionPlayers = gameSessionPlayers;
        this.gameSessionPlayerScores = gameSessionPlayerScores;
        this.gameSessionPlayerMoves = gameSessionPlayerMoves;
        this.playerFound = playerFound;
        this.playerOneColour = playerOneColour;
        this.playerTwoColour = playerTwoColour;
        this.playerOneTurn = playerOneTurn;
        this.playerTwoTurn = playerTwoTurn;
        this.playerHostId = playerHostId;
        this.eliminatedPiecesCount = eliminatedPiecesCount;
        this.hostTerminate = hostTerminate;
        this.oppLeft = oppLeft;
        this.gameEnded = gameEnded;
    }

    public String getCurrSessionId() {
        return currSessionId;
    }

    public void setCurrSessionId(String currSessionId) {
        this.currSessionId = currSessionId;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public boolean isHostTerminate() {
        return hostTerminate;
    }

    public void setHostTerminate(boolean hostTerminate) {
        this.hostTerminate = hostTerminate;
    }

    public boolean isOppLeft() {
        return oppLeft;
    }

    public void setOppLeft(boolean oppLeft) {
        this.oppLeft = oppLeft;
    }

    public Map<String, Integer> getEliminatedPiecesCount() {
        return eliminatedPiecesCount;
    }

    public void setEliminatedPiecesCount(Map<String, Integer> eliminatedPiecesCount) {
        this.eliminatedPiecesCount = eliminatedPiecesCount;
    }

    public String getPlayerHostId() {
        return playerHostId;
    }

    public void setPlayerHostId(String playerHostId) {
        this.playerHostId = playerHostId;
    }

    public Boolean getPlayerOneTurn() {
        return playerOneTurn;
    }

    public void setPlayerOneTurn(Boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }

    public Boolean getPlayerTwoTurn() {
        return playerTwoTurn;
    }

    public void setPlayerTwoTurn(Boolean playerTwoTurn) {
        this.playerTwoTurn = playerTwoTurn;
    }

    public String getPlayerOneColour() {
        return playerOneColour;
    }

    public void setPlayerOneColour(String playerOneColour) {
        this.playerOneColour = playerOneColour;
    }

    public String getPlayerTwoColour() {
        return playerTwoColour;
    }

    public void setPlayerTwoColour(String playerTwoColour) {
        this.playerTwoColour = playerTwoColour;
    }

    public Boolean getPlayerFound() {
        return playerFound;
    }

    public void setPlayerFound(Boolean playerFound) {
        this.playerFound = playerFound;
    }

    public Date getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(Date gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public Date getGameEndTime() {
        return gameEndTime;
    }

    public void setGameEndTime(Date gameEndTime) {
        this.gameEndTime = gameEndTime;
    }

    public String getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public Map<String, Object> getGameSessionPlayers() {
        return gameSessionPlayers;
    }

    public void setGameSessionPlayers(Map<String, Object> gameSessionPlayers) {
        this.gameSessionPlayers = gameSessionPlayers;
    }

    public Map<String, Integer> getGameSessionPlayerMoves() {
        return gameSessionPlayerMoves;
    }

    public void setGameSessionPlayerMoves(Map<String, Integer> gameSessionPlayerMoves) {
        this.gameSessionPlayerMoves = gameSessionPlayerMoves;
    }

    public Map<String, Integer> getGameSessionPlayerScores() {
        return gameSessionPlayerScores;
    }

    public void setGameSessionPlayerScores(Map<String, Integer> gameSessionPlayerScores) {
        this.gameSessionPlayerScores = gameSessionPlayerScores;
    }
}
