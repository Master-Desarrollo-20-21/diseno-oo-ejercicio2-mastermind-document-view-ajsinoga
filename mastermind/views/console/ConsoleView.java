package mastermind.views.console;

import mastermind.models.Game;
import mastermind.views.View;

public class ConsoleView extends View {

    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Game game) {
        super(game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);        
    }

    @Override
    protected void play() {
        this.playView.interact();
    }

    @Override
    protected boolean isNewGame() {
        return this.resumeView.isPlayingAgain();
    }    
}