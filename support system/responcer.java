public class Responder {
    private int responseIndex;

    public Responder() {
        responseIndex = 0;
    }

    public String generateResponse(int state) {
        if (state == 1) {
            return "Can you please provide your identity (e.g., name or customer ID)?";
        } else if (state == 2) {
            return "What technical issue are you facing today?";
        } else {
            String[] responses = {
                "That sounds interesting. Can you elaborate more?",
                "We are working on resolving your issue.",
                "Thank you for sharing. We will look into it.",
                "That's a common issue. Let me help you with that.",
                "Please give us more details about the problem."
            };
            String response = responses[responseIndex];
            responseIndex = (responseIndex + 1) % responses.length;
            return response;
        }
    }
}
