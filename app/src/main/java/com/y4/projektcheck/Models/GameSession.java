package com.y4.projektcheck.Models;

import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.Map;

public class GameSession {
    private Date gameStartTime, gameEndTime;

    @DocumentId
    private String gameSessionId;

    private Map<String, Object> gameSessionPlayers, gameSessionPlayerMoves, gameSessionPlayerScores;

    private Boolean playerAccepted;


    public GameSession() {
    }

    public GameSession(Date gameStartTime, Date gameEndTime, String gameSessionId, Map<String, Object> gameSessionPlayers, Map<String, Object> gameSessionPlayerScores, Map<String, Object> gameSessionPlayerMoves, Boolean playerAccepted) {
        this.gameStartTime = gameStartTime;
        this.gameEndTime = gameEndTime;
        this.gameSessionId = gameSessionId;
        this.gameSessionPlayers = gameSessionPlayers;
        this.gameSessionPlayerScores = gameSessionPlayerScores;
        this.gameSessionPlayerMoves = gameSessionPlayerMoves;
        this.playerAccepted = playerAccepted;
    }

    public Boolean getPlayerAccepted() {
        return playerAccepted;
    }

    public void setPlayerAccepted(Boolean playerAccepted) {
        this.playerAccepted = playerAccepted;
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

    public Map<String, Object> getGameSessionPlayerMoves() {
        return gameSessionPlayerMoves;
    }

    public void setGameSessionPlayerMoves(Map<String, Object> gameSessionPlayerMoves) {
        this.gameSessionPlayerMoves = gameSessionPlayerMoves;
    }

    public Map<String, Object> getGameSessionPlayerScores() {
        return gameSessionPlayerScores;
    }

    public void setGameSessionPlayerScores(Map<String, Object> gameSessionPlayerScores) {
        this.gameSessionPlayerScores = gameSessionPlayerScores;
    }
}
