package com.y4.projektcheck.Presenters;

import com.y4.projektcheck.Interactors.GameSessionRequestInteractor;
import com.y4.projektcheck.Models.Player;

public class GameSessionRequestPresenter {
    private GameSessionRequestInteractor gameSessionRequestInteractor = new GameSessionRequestInteractor();

    private PlayersView playersView;

    public GameSessionRequestPresenter() {

    }

    public GameSessionRequestPresenter(PlayersView playersView) {
        this.playersView = playersView;
    }


    public void getRequestingAndRequestedPlayerUserId(String requestingPlayerId, String requestedPlayerId) {
        gameSessionRequestInteractor.readPlayersIds(requestingPlayerId, requestedPlayerId);
    }

    public interface PlayersView {
        void getPlayersAvailable(Player player);
    }

    public void getPlayersAvailable(Player player) {
        playersView.getPlayersAvailable(player);
    }
}
