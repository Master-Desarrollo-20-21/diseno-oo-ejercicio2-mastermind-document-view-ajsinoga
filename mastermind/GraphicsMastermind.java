package mastermind;

import mastermind.models.Game;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView(Game game) {
        return new GraphicsView(game);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }    
}