package mastermind.views;

import mastermind.models.Game;

public abstract class View {

    protected Game game;

    public View(Game game) {       
        this.game = game;
    }

    public void interact() {        
        do {            
            this.play();
        } while (this.isNewGame());
    }

    protected abstract void play();
    
    protected abstract boolean isNewGame();
}