package com.pages;

import com.driver.WebdriverIntializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddandDeleteTagsPortfolioPage {

    private WebDriver driver;

    private By AddTag_Icon = By.xpath("//a[text()=' Add Tag']");
    private By toasterBox = By.xpath("//div[contains(@class,'toaster')]//p");
    private By search_dropdown = By.xpath("//p[text()='Base Case ']//following-sibling::div[@class='d-inline-block dropdown']");
    private By searchBar = By.xpath("//input[@placeholder='Search...']");
    private By sizeportfolio = By.xpath("//input[@placeholder='Search...']//parent::div//parent::div[@aria-labelledby='basecase']//div[@class='basecase-list']");
    public AddandDeleteTagsPortfolioPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_on_search_dropdown(String keyword) throws InterruptedException {

        driver.findElement(search_dropdown).isDisplayed();
        Thread.sleep(100);
        driver.findElement(search_dropdown).click();
        driver.findElement(searchBar).sendKeys(keyword);
        Thread.sleep(100);

        List<WebElement> listElement = driver.findElements(sizeportfolio);
        for (int i = 0; i < listElement.size(); i++) {
            String elementText = listElement.get(i).getText();
            System.out.println(elementText);
            if (elementText.contains(keyword)) {
                System.out.println("search performed successful");
            } else {
                System.out.println("search not performed");
            }
        }

    }

    public void click_on_add_tag(String addtags, String expected_toastmsg) throws InterruptedException {
        Thread.sleep(1000);
        String[] portfoliotags = addtags.split(",");

        for (int i = 0; i < portfoliotags.length; i++) {

            Thread.sleep(2000);
            driver.findElement(AddTag_Icon).click();
            System.out.println(portfoliotags[i]);
            driver.findElement(By.xpath(
                            "//a[text()=' Add Tag']//following-sibling::div//label//a[text()='" + portfoliotags[i] + "']"))
                    .click();

            String Actual_toaster_msg = driver.findElement(toasterBox).getText();
            System.out.println("" + Actual_toaster_msg);
            Assert.assertEquals(Actual_toaster_msg, expected_toastmsg,
                    "Expected : " + expected_toastmsg + " But found : " + Actual_toaster_msg);

        }

    }

    public void delete_the_addedtags(String deletetags, String expected_toastermsg) throws InterruptedException {

        String[] portfoliodeletetags = deletetags.split(",");

        for (int i = 0; i < portfoliodeletetags.length; i++) {

            Thread.sleep(2000);
            System.out.println(portfoliodeletetags[i]);
            driver.findElement(By.xpath("//div//span[text()='" + portfoliodeletetags[i] + "']//i")).click();
            String Actual_toaster_msg = driver.findElement(toasterBox).getText();
            System.out.println("" + Actual_toaster_msg);
            Assert.assertEquals(Actual_toaster_msg, expected_toastermsg,
                    "Expected : " + expected_toastermsg + " But found : " + Actual_toaster_msg);
            // Thread.sleep(1000);
        }

    }
}
