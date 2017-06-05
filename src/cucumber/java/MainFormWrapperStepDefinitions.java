import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.MainFormWrapper;

import java.util.stream.IntStream;

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

    @When("^I insert (\\d+) Pennys? into the vending machine$")
    public void i_insert_a_Penny_into_the_vending_machine(int numberOfCoinsInserted) {
        IntStream.rangeClosed(1, numberOfCoinsInserted).forEach(insertedCoin -> {
            mainFormWrapper.retrieveInsertPennyButton().doClick();
        });
    }

    @When("^I insert (\\d+) Nickles? into the vending machine$")
    public void i_insert_a_Nickle_into_the_vending_machine(int numberOfCoinsInserted) {
        IntStream.rangeClosed(1, numberOfCoinsInserted).forEach(insertedCoin -> {
            mainFormWrapper.retrieveInsertNickleButton().doClick();
        });
    }

    @When("^I insert (\\d+) Dimes? into the vending machine$")
    public void i_insert_a_Dime_into_the_vending_machine(int numberOfCoinsInserted) {
        IntStream.rangeClosed(1, numberOfCoinsInserted).forEach(insertedCoin -> {
            mainFormWrapper.retrieveInsertDimeButton().doClick();
        });

    }

    @When("^I insert (\\d+) Quarters? into the vending machine$")
    public void i_insert_a_Quarter_into_the_vending_machine(int numberOfCoinsInserted) {
        IntStream.rangeClosed(1, numberOfCoinsInserted).forEach(insertedCoin -> {
            mainFormWrapper.retrieveInsertQuarterButton().doClick();
        });
    }

    @When("^I select the return coins button$")
    public void i_select_the_return_coins_button() {
        mainFormWrapper.retrieveReturnCoinsButton().doClick();
    }

    @Then("^the coin return has \"(.*?)\"$")
    public void the_coin_return_has(String returnedChange) {
        assertThat(mainFormWrapper.retrieveCoinReturnLabel().getText(), is(returnedChange));
    }

    @When("^I collect change from the coin return$")
    public void i_collect_change_from_the_coin_return() {
        mainFormWrapper.retrieveCollectCoinReturnButton().doClick();
    }

    @When("^I select the purchase cola button$")
    public void i_select_the_purchase_cola_button() {
        mainFormWrapper.retrievePurchaseColaButton().doClick();
    }

    @When("^I select the purchase chips button$")
    public void i_select_the_purchase_chips_button() {
        mainFormWrapper.retrievePurchaseChipsButton().doClick();
    }

    @When("^I select the purchase candy button$")
    public void i_select_the_purchase_candy_button() {
        mainFormWrapper.retrievePurchaseCandyButton().doClick();
    }

    @Then("^the display eventually shows \"(.*?)\" within (\\d+) second$")
    public void the_display_eventually_shows_within_seconds(String expectedDisplayText, int timeoutInSeconds) throws InterruptedException {
        int timeoutInMilliseconds = timeoutInSeconds * 1000;
        long timeout = System.currentTimeMillis() + timeoutInMilliseconds;
        while (!expectedDisplayText.equals(mainFormWrapper.retrieveVendingDisplayLabel().getText()) && hasNotTimedOut(timeout)) {
            Thread.sleep(5L);
        }
        assertThat(mainFormWrapper.retrieveVendingDisplayLabel().getText(), is(expectedDisplayText));
    }

    @Then("^\"(.*?)\" (?:is|are) dispensed from the vending machine$")
    public void are_dispensed_from_the_vending_machine(String dispensedItemText) {
        assertThat(mainFormWrapper.retrieveDispensedItemLabel().getText(), is(dispensedItemText));
    }

    private boolean hasNotTimedOut(long timeout) {
        return System.currentTimeMillis() < timeout;
    }

}
