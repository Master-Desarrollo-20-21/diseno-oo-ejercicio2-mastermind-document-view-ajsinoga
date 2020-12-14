package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.Message;
import mastermind.utils.YesNoDialog;

public class ResumeView {

	private Game game;

	public ResumeView(Game game) {
		this.game = game; 
	}

	public boolean isPlayingAgain() {
		boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
			this.game.reset();
		}
        return newGame;
	}
}