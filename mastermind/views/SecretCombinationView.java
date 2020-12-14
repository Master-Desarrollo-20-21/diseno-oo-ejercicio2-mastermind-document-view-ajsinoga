package mastermind.views;

import mastermind.models.Game;
import mastermind.models.Combination;

public class SecretCombinationView {

    private Game game;

    public SecretCombinationView(Game game) {
        this.game = game;
    }

    public String show() {
        String encryptedCombination = "";
        for (int i = 0; i < Combination.size(); i++) {
            encryptedCombination += "*";						            
        }
        return encryptedCombination;
    }

    public String showDecrypted() {        
        return this.game.RevealSecretCombination().getCombination();
    }
}