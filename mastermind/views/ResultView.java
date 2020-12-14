package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.Console;

public class ResultView {

    private Game game;
	private CombinationView combinationView;
    private SecretCombinationView secretCombinationView;
    private Console console;

    public ResultView(Game game) {
		this.game = game;
		this.combinationView = new CombinationView(this.game);
        this.secretCombinationView = new SecretCombinationView(this.game);
        this.console = Console.getInstance();
    }
    
	public void showHeader() {
        console.outln("\n" + Integer.toString(this.game.getCurrentAttempt()) + Messages.ATTEMPS.getMessage());
		console.outln(this.secretCombinationView.show());
	}
    
    public void showResult() {   
        this.showHeader(); 
        for (int i = 0; i < this.game.getCurrentAttempt(); i++) {
            console.outln(this.combinationView.show(i)  + " --> " 
                        + this.game.numberOfBlacksAttempt(i) + " blacks and " + this.game.numberOfWhitesAttempt(i) + " whites");
        }
    }   

    public void showWinnerMessage() {
        console.outln(Messages.WINNER.getMessage());
    }

    public void showLooserMessage() {
        console.outln(Messages.LOOSER.getMessage());
        console.outln(Messages.SECRET.getMessage() + this.secretCombinationView.showDecrypted());
    }
}