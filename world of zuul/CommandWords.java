public class CommandWords {
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look"
    };

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString) {
        for(String command : validCommands) {
            if(command.equals(aString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print all valid commands.
     */
    public void showAll() {
        for(String command : validCommands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
