package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private LoginPage lgn = new LoginPage(WebdriverIntializer.getDriver());

    @Given("Enter the username and password {string} {string}")
    public void enter_the_username_and_password(String username, String password) {
        lgn.enterDetails(username, password);
    }

    @When("click on login")
    public void click_on_login() {
        lgn.clickonLogin();
    }

    @Then("verify true credentials verify home page or verofy the toaster if not {string} {string} {string} {string}")
    public void verify_true_credentials_verify_home_page_or_verofy_the_toaster_if_not(String toaster,String name,String username,String password) {
        lgn.verify(toaster, name,username,password);
    }
}
