package mastermind;

import mastermind.models.Game;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind {

	@Override
	protected ConsoleView createView(Game game) {
		return new ConsoleView(game);
    }
    
    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }   
}