package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.Console;

public class PlayView {

	private Game game;
	private CombinationView combinationView;
	private ResultView resultView;

	public PlayView(Game game) {
		this.game = game;
		this.combinationView = new CombinationView(this.game);
		this.resultView = new ResultView(this.game);
	}

	public void interact() {
		boolean gameFinished = false;
		this.showTitle();
		do {
			this.game.saveCombination(this.combinationView.read(Messages.PROPOSE.getMessage()));
			this.game.verifyProposal();
			this.resultView.showResult();			
			if (this.game.isWinner()) {
				this.resultView.showWinnerMessage();
				gameFinished = true;
			} else {
				if (this.game.isCompleted()) {
					this.resultView.showLostMessage();
					gameFinished = true;
				}
			}
		} while (!gameFinished);
	}

	private void showTitle() {
		Console.getInstance().out(Messages.TITLE.getMessage());
	}
}