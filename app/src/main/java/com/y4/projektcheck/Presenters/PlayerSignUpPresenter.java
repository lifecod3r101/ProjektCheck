package com.y4.projektcheck.Presenters;

import com.y4.projektcheck.Interactors.PlayerSignUpInteractor;
import com.y4.projektcheck.Models.Player;

public class PlayerSignUpPresenter {
    private final Player player;
    private final SignUpProcessView signUpProcessView;

    private final PlayerSignUpInteractor playerSignUpInteractor = new PlayerSignUpInteractor();



    public PlayerSignUpPresenter(SignUpProcessView signUpProcessView) {
        this.player = new Player();
        this.signUpProcessView = signUpProcessView;
    }

    public interface SignUpProcessView {

        void checkUserNameEmpty(String playerUserName, Boolean isEmpty);

        void userNameIsTaken(String playerUserName, Boolean isTaken);
    }

    public void readPlayerUserNameAndEmailAddress(String playerUserName, String playerEmailAddress) {
        player.setPlayerUserName(playerUserName.trim());
        player.setPlayerEmailAddress(playerEmailAddress.trim());
        playerSignUpInteractor.getPlayerInfo(player);
    }


    public void userNameIsEmpty(String playerUserName) {
        if (playerUserName.isEmpty()) {
            signUpProcessView.checkUserNameEmpty(playerUserName, true);
        }
    }

    public void userNameExists(String playerUserName) {
        signUpProcessView.userNameIsTaken(playerUserName, true);
    }


}