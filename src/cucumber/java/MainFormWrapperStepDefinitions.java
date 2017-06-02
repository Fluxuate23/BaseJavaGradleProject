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

    @When("^I insert a Penny into the vending machine$")
    public void i_insert_a_Penny_into_the_vending_machine() {
        mainFormWrapper.retrieveInsertPennyButton().doClick();
    }

    @When("^I insert a Nickle into the vending machine$")
    public void i_insert_a_Nickle_into_the_vending_machine() {
        mainFormWrapper.retrieveInsertNickleButton().doClick();
    }

    @When("^I insert a Dime into the vending machine$")
    public void i_insert_a_Dime_into_the_vending_machine() {
        mainFormWrapper.retrieveInsertDimeButton().doClick();
    }

    @When("^I insert a Quarter into the vending machine$")
    public void i_insert_a_Quarter_into_the_vending_machine() {
        mainFormWrapper.retrieveInsertQuarterButton().doClick();
    }

}
