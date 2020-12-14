package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.YesNoDialog;

public class ResumeView {

	private Game game;

	public ResumeView(Game game) {
		this.game = game; 
	}

	public boolean isPlayingAgain() {
		boolean newGame = new YesNoDialog().read(Messages.RESUME.getMessage());
        if (newGame) {
			this.game.reset();
		}
        return newGame;
	}
}