package parallel;

import io.cucumber.java.en.Given;

public class StepDefinitions {

    @Given("^I do (.+)$")
    public void i_do_action(String action) {
        System.out.println("Action: " + action);
    }
}

