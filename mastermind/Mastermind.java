package mastermind;

import mastermind.models.Game;
import mastermind.views.View;

class Mastermind {

    private Game game;
    private View view;    

    Mastermind() {
        this.game = new Game();
        this.view = new View(this.game);        
    }

    private void play() {
        this.view.interact();
    }

    public static void main(String args[]) {    
        new Mastermind().play();
    }
}