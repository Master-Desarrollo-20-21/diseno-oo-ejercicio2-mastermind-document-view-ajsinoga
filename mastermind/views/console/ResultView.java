package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.Message;
import mastermind.utils.Console;

public class ResultView {

    private Game game;
    private CombinationView combinationView;
    private SecretCombinationView secretCombinationView;
    private Console console;

    public ResultView(Game game) {
		this.game = game;
        this.combinationView = new CombinationView(game);
        this.secretCombinationView = new SecretCombinationView(game);
        this.console = Console.getInstance();
    }
    
	public void showHeader() {
        console.outln("\n" + Integer.toString(this.game.getCurrentAttempt()) + Message.ATTEMPS.getMessage());
		console.outln(this.secretCombinationView.show());
	}
    
    public void showResult() {   
        this.showHeader(); 
        for (int i = 0; i < this.game.getCurrentAttempt(); i++) {
            console.outln(this.combinationView.show(i)  + " --> " 
                        + this.game.numberOfBlacksAttempt(i) + " blacks and " + this.game.numberOfWhitesAttempt(i) + " whites");
        }
    }   
}