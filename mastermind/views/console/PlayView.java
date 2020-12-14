package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.Message;
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
		console.outln(Message.TITLE.getMessage());
		this.resultView.showHeader();		
		do {			
			this.game.saveCombination(this.combinationView.read(Message.PROPOSE.getMessage()));
			this.game.verifyProposal();
			this.resultView.showResult();									
		} while (!isGameFinished());
	}	

	private boolean isGameFinished() {
		if (this.game.isWinner()) {
			console.outln(Message.WINNER.getMessage());;
			return true;
		} 
		if (this.game.isCompleted()) {
			console.outln(Message.LOOSER.getMessage());
			console.outln(Message.SECRET.getMessage() + this.secretCombinationView.showDecrypted());
			return true;
		}
		return false;
	}
}