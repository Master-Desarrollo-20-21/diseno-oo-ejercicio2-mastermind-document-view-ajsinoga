package mastermind.views;

enum Messages 
{
    TITLE("\n ----- MASTERMIND ----- "),
    ATTEMPS(" attempt(s):"),
    PROPOSE("Propose a combination: "),
    WINNER("You have won :-)"),
    LOOSER("You have lost :-("),
    WRONGLENGHT("Wrong proposed combination length"),
    WRONGCOLOR("Wrong colors, they must be: rbygop"),
    RESUME("RESUME"), 
    SECRET("The secret combination was: ");  

    private String message;
    
    Messages(String message) {
        this.message = message;
    }

	public String getMessage() {
		return this.message;
	}
}