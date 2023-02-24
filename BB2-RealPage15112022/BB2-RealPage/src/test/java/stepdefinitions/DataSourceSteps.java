package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.DataSourcePage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataSourceSteps {

    private DataSourcePage dataSource = new DataSourcePage(WebdriverIntializer.getDriver());
    private LoginPage lgnpage = new LoginPage(WebdriverIntializer.getDriver());


    @Given("Click on DataSource Tab")
    public void click_on_data_source_tab() {
        lgnpage.enterDetails("superadmin","Demo@123");
        lgnpage.clickonLogin();
            dataSource.clickOnDataSources();
    }

    @When("CLick on Add New Data Source {string} {string}")
    public void c_lick_on_add_new_data_source(String datasets,String Datasources) throws InterruptedException {
            dataSource.checkDataSources(Datasources);
            dataSource.checkDataSets(datasets);
    }

    @Then("Verify Them")
    public void verify_them() throws InterruptedException {
        dataSource.addDataSources();
    }
}
