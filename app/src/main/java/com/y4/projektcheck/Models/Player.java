package com.y4.projektcheck.Models;

public class Player {
    private String playerUserId, playerEmailAddress, playerUserName;
    private double playerCumScore;
    private int matchesPlayed, playerWins, playerLosses, playerDraws;

    public Player() {
    }

    public Player(String playerUserId, String playerEmailAddress, String playerUserName, double playerCumScore, int matchesPlayed, int playerWins, int playerLosses, int playerDraws) {
        this.playerUserId = playerUserId;
        this.playerEmailAddress = playerEmailAddress;
        this.playerUserName = playerUserName;
        this.playerCumScore = playerCumScore;
        this.matchesPlayed = matchesPlayed;
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.playerDraws = playerDraws;
    }

    public String getPlayerUserId() {
        return playerUserId;
    }

    public void setPlayerUserId(String playerUserId) {
        this.playerUserId = playerUserId;
    }

    public String getPlayerEmailAddress() {
        return playerEmailAddress;
    }

    public void setPlayerEmailAddress(String playerEmailAddress) {
        this.playerEmailAddress = playerEmailAddress;
    }

    public String getPlayerUserName() {
        return playerUserName;
    }

    public void setPlayerUserName(String playerUserName) {
        this.playerUserName = playerUserName;
    }

    public double getPlayerCumScore() {
        return playerCumScore;
    }

    public void setPlayerCumScore(double playerCumScore) {
        this.playerCumScore = playerCumScore;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(int playerLosses) {
        this.playerLosses = playerLosses;
    }

    public int getPlayerDraws() {
        return playerDraws;
    }

    public void setPlayerDraws(int playerDraws) {
        this.playerDraws = playerDraws;
    }

}
