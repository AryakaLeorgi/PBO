public class SupportSystem {
    private InputReader reader;
    private Responder responder;
    private Customer[] customerList;
    private int customerCount;
    private int state; 
    private String currentIdentity; 

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
        customerList = new Customer[10]; 
        customerCount = 0;
        state = 1;  
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
                    System.out.println(responder.generateResponse(state)); 
                } else if (state == 2) {
                    if (customerCount < customerList.length) {
                        customerList[customerCount] = new Customer(currentIdentity, input);
                        customerCount++;
                    } else {
                        System.out.println("Customer list is full.");
                    }
                    state = 3;
                    System.out.println(responder.generateResponse(state));  
                } else {
                    System.out.println(responder.generateResponse(state)); 
                }
            }
        }
        printGoodbye();
    }

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
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
        System.out.println("Type 'list' to see all customers.");
    }

    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
    }
}