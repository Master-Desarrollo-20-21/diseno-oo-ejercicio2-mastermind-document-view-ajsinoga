package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.Console;

public class PlayView {

	private Game game;
	private CombinationView combinationView;
	private SecretCombinationView secretCombinationView;
	private ResultView resultView;
	private Console console;

	public PlayView(Game game) {
		this.game = game;		
		this.combinationView = new CombinationView(game);
		this.secretCombinationView = new SecretCombinationView(game);
		this.resultView = new ResultView(game);
		this.console = Console.getInstance();
	}

	public void interact() {
		console.outln(Messages.TITLE.getMessage());
		this.resultView.showHeader();		
		do {			
			this.game.saveCombination(this.combinationView.read(Messages.PROPOSE.getMessage()));
			this.game.verifyProposal();
			this.resultView.showResult();									
		} while (!isGameFinished());
	}	

	private boolean isGameFinished() {
		if (this.game.isWinner()) {
			console.outln(Messages.WINNER.getMessage());;
			return true;
		} 
		if (this.game.isCompleted()) {
			console.outln(Messages.LOOSER.getMessage());
			console.outln(Messages.SECRET.getMessage() + this.secretCombinationView.showDecrypted());
			return true;
		}
		return false;
	}
}