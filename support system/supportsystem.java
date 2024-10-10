public class SupportSystem {
    private InputReader reader;
    private Responder responder;
    private Customer[] customerList;  // Array to store customers
    private int customerCount;  // Track how many customers have been added
    private int state;  // To track the conversation state
    private String currentIdentity;  // Temporarily store customer identity

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
        customerList = new Customer[10];  // Fixed-size array for up to 10 customers
        customerCount = 0;
        state = 1;  // Start by asking for identity
    }

    public void start() {
        boolean finished = false;
        printWelcome();
        
        while (!finished) {
            String input = reader.getInput();
            
            if (input.startsWith("bye")) {
                finished = true;
            } else if (input.startsWith("list")) {
                listAllCustomers();
            } else {
                if (state == 1) {
                    currentIdentity = input;
                    state = 2;
                    System.out.println(responder.generateResponse(state));  // Ask for the problem
                } else if (state == 2) {
                    if (customerCount < customerList.length) {
                        customerList[customerCount] = new Customer(currentIdentity, input);
                        customerCount++;
                    } else {
                        System.out.println("Customer list is full.");
                    }
                    state = 3;  // Switch to generating random responses
                    System.out.println(responder.generateResponse(state));  // Generate the first random response
                } else {
                    System.out.println(responder.generateResponse(state));  // Continue with random responses
                }
            }
        }
        printGoodbye();
    }

    // Now a public method to be accessed via right-click in BlueJ
    public void listAllCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
        } else {
            System.out.println("List of Customers:");
            for (int i = 0; i < customerCount; i++) {
                System.out.println(customerList[i]);
            }
        }
    }
    
        private void printWelcome() {
        System.out.println("Welcome to the Technical Support System.");
        System.out.println();
        System.out.println("Please tell us your name.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
    }
}
