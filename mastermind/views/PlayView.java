package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.Console;

public class PlayView {

	private Game game;
	private CombinationView combinationView;
	private ResultView resultView;
	private Console console;

	public PlayView(Game game) {
		this.game = game;		
		this.combinationView = new CombinationView(this.game);
		this.resultView = new ResultView(this.game);
		this.console = Console.getInstance();
	}

	public void interact() {
		this.showTitle();
		this.resultView.showHeader();		
		do {			
			this.game.saveCombination(this.combinationView.read(Messages.PROPOSE.getMessage()));
			this.game.verifyProposal();
			this.resultView.showResult();									
		} while (!isGameFinished());
	}

	private void showTitle() {
		console.outln(Messages.TITLE.getMessage());
	}

	private boolean isGameFinished() {
		if (this.game.isWinner()) {
			this.resultView.showWinnerMessage();
			return true;
		} 
		if (this.game.isCompleted()) {
			this.resultView.showLooserMessage();
			return true;
		}
		return false;
	}
}