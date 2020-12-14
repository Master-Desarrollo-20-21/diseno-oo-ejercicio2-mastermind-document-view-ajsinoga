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
    
    public void showResult() {
        console.out((this.game.currentAttempt()) + " attemps(s):\n" + this.secretCombinationView.show() + "\n");        
        for (int i = 0; i < this.game.currentAttempt(); i++) {
            console.out(this.combinationView.show(i)  + " --> " 
                        + this.game.numberOfBlacksAttempt(i) + " blacks and " + this.game.numberOfWhitesAttempt(i) + " whites\n");
        }
    }   

    public void showWinnerMessage() {
        console.out(Messages.WINNER.getMessage());
    }

    public void showLostMessage() {
        console.out(Messages.LOOSER.getMessage());
        console.out(Messages.SECRET.getMessage() + this.secretCombinationView.showDecrypted() + "\n");
    }
}