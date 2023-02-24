package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class AddandDeleteTagsAssetPage {
    private WebDriver driver;

    private By Asset_Tab = By.xpath("//*[@class='sidemenu-content']//a[3]//i");
    private By add_tag = By.xpath("//*[text()=' Add Tag']//i");
    private By detail = By.xpath("//*[text()='Details']");
    private By text = By.xpath("//*[text()=' Add Tag']//following-sibling::div//div//input");
    private By text1 = By.xpath("//*[text()=' Add Tag']//following-sibling::div//div[2]//label//div//a");
    private By toaster = By.xpath("//*[@class='toaster success']//p");
    private By del_tag = By.xpath("//span[text()='Educational services']//i");

    public AddandDeleteTagsAssetPage(WebDriver driver){
        this.driver = driver;
    }

    public void Add_tag(String Tags, String message) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String[] t = Tags.split(",");
        for (int i = 0; i < t.length; i++) {
            driver.findElement(add_tag).click();
            driver.findElement(text).sendKeys(t[i]);
            Thread.sleep(500);
            driver.findElement(text1).click();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String s = driver.findElement(toaster).getText();
            Assert.assertEquals(s, message);
            Thread.sleep(2000);
            WebElement Element = driver.findElement(By.xpath("//*[text()='Tags']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", Element);
            driver.findElement(By.xpath("//*[text()='Tags']//following-sibling::div//span[text()='" + t[i] + "']")).isDisplayed();
            Thread.sleep(1000);
        }
    }

    public void Remove_Tag(String Tags, String del_message) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // driver.navigate().refresh();
        String[] t = Tags.split(",");
        for (int i = 0; i < t.length; i++) {
            driver.findElement(By.xpath("//span[text()='" + t[i] + "']//i")).click();
            String s = driver.findElement(toaster).getText();
            Assert.assertEquals(s, del_message);
            Thread.sleep(2000);
//            WebElement Element = driver.findElement(By.xpath("//*[text()='Tags']"));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView();", Element);
//            if (!driver.findElement(By.xpath("//*[text()='Tags']//following-sibling::div//span[text()='" + t[i] + "']")).isDisplayed()) {
//                System.out.println("deleted");
//            }
        }
    }
}
