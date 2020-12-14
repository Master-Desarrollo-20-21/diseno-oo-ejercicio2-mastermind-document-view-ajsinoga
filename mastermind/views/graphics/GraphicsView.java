package mastermind.views.graphics;

import mastermind.models.Game;
import mastermind.views.View;

public class GraphicsView extends View {

    private PlayView playView;
    private ResumeView resumeView;

    public GraphicsView(Game game) {
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