package mastermind.views;

import mastermind.models.Game;

public class View {

    private Game game;
    private PlayView playView;
    private ResumeView resumeView;

    public View(Game game) {
        this.game = game;        
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);
    }

    public void interact() {        
        do {            
            this.playView.interact();
        } while (this.resumeView.isPlayingAgain());
    }
}