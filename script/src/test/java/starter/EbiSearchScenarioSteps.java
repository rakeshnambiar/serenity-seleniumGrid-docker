package starter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.framework.hooks.ScenarioHook;
import cucumber.pages.EbiHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by rakeshnambiar on 31/12/2016.
 */
public class EbiSearchScenarioSteps extends ScenarioSteps{
    EbiHomePage homePage;

    @Step
    private void printMessage(String message){

    }

    private void opens_home_page() {
        homePage.open();
    }

/*TC_01*/
    @Given("^I am Scientist$")
    public void i_am_Scientist() throws Throwable {
        opens_home_page();
    }

    @When("^I open the EBI Website$")
    public void i_open_the_EBI_Website() throws Throwable {
        Assert.assertTrue("ERROR: Home Page NOT available",homePage.verifyHomePageAvailable());
    }

    @When("^Enter the keyword \"([^\"]*)\" on the Query field$")
    public void enter_the_keyword_on_the_Query_field(String keyWord) throws Throwable {
        homePage.enterQueryString(keyWord);
    }

    @When("^Click on the Search button$")
    public void click_on_the_Search_button() throws Throwable {
        homePage.performSearch();
    }

    @Then("^I should be able to see the matching results on the Search Result page$")
    public void i_should_be_able_to_see_the_matching_results_on_the_Search_Result_page() throws Throwable {
        printMessage("Successful");
    }

/*TC_02 */
    @When("^Enter the \"([^\"]*)\" on the Query field$")
    public void enter_the_on_the_Query_field(String text) throws Throwable {
        homePage.enterQueryString(text);
    }
}
