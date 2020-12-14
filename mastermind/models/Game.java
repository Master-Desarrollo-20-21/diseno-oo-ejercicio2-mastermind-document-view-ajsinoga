package mastermind.models;

public class Game {

    private final int NUM_MAX_ATTEMPTS = 10;
    private int attempts;
    private SecretCombination secretCombination;
    private Combination[] combinations;
    private Result[] results;    

    public Game() {
        this.reset();
    }

    public void reset() {
        this.attempts = 0;
        this.secretCombination = new SecretCombination();
        this.combinations = new Combination[NUM_MAX_ATTEMPTS];
        this.results = new Result[NUM_MAX_ATTEMPTS];
    }

    public int currentAttempt() {
        return attempts;
    }

    public void increaseAttempts() {
        this.attempts++;
    }

	public void saveCombination(String combination) {
        this.combinations[this.currentAttempt()] = new Combination();
        this.combinations[this.currentAttempt()].asignColors(combination);
    }   
    
    public void verifyProposal() {
        this.results[this.currentAttempt()] = new Result();
        this.results[this.currentAttempt()].verify(this.secretCombination, this.combinations[attempts]);
        this.increaseAttempts();
    }

    public boolean isWinner() {
        return this.results[this.currentAttempt() - 1].isWinner();
    }

    public boolean isCompleted() {
        return this.currentAttempt() == NUM_MAX_ATTEMPTS;
    }

    public int numberOfBlacksAttempt(int attempt) {
        return this.results[attempt].numberOfBlacks();
    }

    public int numberOfWhitesAttempt(int attempt) {
        return this.results[attempt].numberOfWhites();
    }

	public Combination RevealSecretCombination() {
		return this.secretCombination;
	}

	public Combination getProposalCombination(int attempt) {
		return this.combinations[attempt];
	}
}