public class Customer {
    private String identity;
    private String problem;

    public Customer(String identity, String problem) {
        this.identity = identity;
        this.problem = problem;
    }

    public String getIdentity() {
        return identity;
    }

    public String getProblem() {
        return problem;
    }
    
    public String toString() {
        return "Customer Identity: " + identity + "\nProblem: " + problem + "\n";
    }
}
