package mastermind.views;

import mastermind.models.Game;

public class View {

    private PlayView playView;
    private ResumeView resumeView;

    public View(Game game) {       
        this.playView = new PlayView(game);
        this.resumeView = new ResumeView(game);
    }

    public void interact() {        
        do {            
            this.playView.interact();
        } while (this.resumeView.isPlayingAgain());
    }
}