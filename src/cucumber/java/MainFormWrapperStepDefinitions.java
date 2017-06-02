import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.MainFormWrapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainFormWrapperStepDefinitions {

    private MainFormWrapper mainFormWrapper;

    @Given("^A Vending Machine is running$")
    public void a_Vending_Machine_is_running() {
        mainFormWrapper = new MainFormWrapper();
        mainFormWrapper.launchForm();
    }

    @Then("^the display shows \"(.*?)\"$")
    public void the_display_shows(String displayText) {
        assertThat(mainFormWrapper.retrieveVendingDisplayLabel().getText(), is(displayText));
    }

}
