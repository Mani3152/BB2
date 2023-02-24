package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddandDeleteWatchListPage {

    private WebDriver driver;

    private By Add_watchlist = By.xpath("//*[text()='Add to Watchlist']");
    private By Add_btn = By.xpath("//*[text()='Add']");
    private By Assets_Watch = By.xpath("(//*[text()='Assets'])[3]");
    private By drop_btn = By.xpath("//*[@id='moreOption']//i");
    private By manage_watchlist = By.xpath("//*[text()='Manage Watchlist']");
    private By Add_Asset = By.xpath("(//*[text()='Add Assets'])[2]");
    private By search_asset = By.xpath("//*[text()='Search Asset']//following-sibling::div//input");
    private By Check_btn = By.xpath("(//table//thead)[4]//tr//th//span//input");
    private By save_btn = By.xpath("//*[text()='Save']");
    private By search_Asset_table = By.xpath("(//table//tbody)[4]//tr//td[2]//div");
    private By remove_watchlist = By.xpath("//*[text()='Remove From Watchlist']");
    private By remove_btn = By.xpath("//*[text()='Remove']");
    private By delete = By.xpath("(//table//tbody)[3]//tr//td[4]//div");
    private By check_Portfolio = By.xpath("//div[text()='Portfolio']//following-sibling::div");
    private By portfolios = By.xpath("//a[@href='/portfolios']");

    public AddandDeleteWatchListPage(WebDriver driver){
        this.driver = driver;
    }


    List<String> li = new ArrayList<>();
    List<String> del_Asset = new ArrayList<>();


    public void Add_WatchList() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Add_watchlist).isDisplayed();
        driver.findElement(Add_watchlist).click();
        Thread.sleep(1000);
        driver.findElement(Add_btn).click();
        Thread.sleep(1000);


    }

    public void go_to_verified_portfolio() throws InterruptedException {
        String portfolio_name = driver.findElement(check_Portfolio).getText();
        driver.findElement(portfolios).click();
        driver.findElement(By.xpath("//table//tbody//tr//td[1]//a[text()='" + portfolio_name + "']")).click();
        Thread.sleep(1000);
        driver.findElement(Assets_Watch).isDisplayed();
        driver.findElement(Assets_Watch).click();
    }

    public void verify_aseet_watchlist(String verify_asset, String message) throws InterruptedException {
        if (driver.findElements(By.xpath("(//table//tbody)[1]//tr//td[1]//a[text()='" + verify_asset + "']")).size() > 0) {
            String name = driver.findElement(By.xpath("(//table//tbody)[1]//tr//td[1]//a[text()='" + verify_asset + "']")).getText();
            Assert.assertEquals(name, verify_asset);
        } else {
            String error = driver.findElement(By.xpath("(//h5)[13]")).getText();
            Assert.assertEquals(error, message);
        }

    }


    public void Assets_in_watchlist() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(Assets_Watch).isDisplayed();
        driver.findElement(Assets_Watch).click();
        Thread.sleep(1000);
        driver.findElement(drop_btn).isEnabled();
        driver.findElement(drop_btn).click();
        Thread.sleep(1000);
        driver.findElement(manage_watchlist).click();
        Thread.sleep(1000);
    }


    public void Add_watchlist_btn() throws InterruptedException {
        driver.findElement(Add_Asset).isEnabled();
        driver.findElement(Add_Asset).click();
        Thread.sleep(1000);
        if (driver.findElements(By.xpath("(//table//tbody)[4]//tr//td[2]")).size() > 0) {
            int size = driver.findElements(By.xpath("(//table//tbody)[4]//tr//td[2]")).size();
            for (int i = 0; i < size; i++) {
                String key = driver.findElements(By.xpath("(//table//tbody)[4]//tr//td[2]")).get(i).getText();
                li.add(key);
            }
            System.out.println(li);
            driver.findElement(Check_btn).click();
            driver.findElement(Add_btn).click();
            driver.findElement(save_btn).click();
        } else {
            String error = driver.findElement(By.xpath("//app-add-watchlist//h5")).getText();
            Assert.assertEquals(error, "No data to display");

        }
    }
    public void verifywatchlist(String message) {
        if (driver.findElements(By.xpath("(//table//tbody)[1]//tr//td[1]//a")).size() > 0) {
            for (int i = 0; i < li.size(); i++) {
                String name = driver.findElement(By.xpath("(//table//tbody)[1]//tr//td[1]//a[text()='" + li.get(i) + "']")).getText();
                System.out.println(name);
                Assert.assertEquals(name, li.get(i));
            }
        } else {
            String error = driver.findElement(By.xpath("//*[@id='ngb-nav-16-panel']//h5")).getText();
            Assert.assertEquals(error, message);
        }
    }




    public void Remove_AddWatchlist() throws InterruptedException {
        driver.findElement(remove_watchlist).isDisplayed();
        driver.findElement(remove_watchlist).click();
        Thread.sleep(1000);
        if (driver.findElement(remove_btn).isEnabled()) {
            driver.findElement(remove_btn).click();
        }
        driver.findElement(Add_watchlist).isDisplayed();
    }

    public void delete_watchlist(String message) throws InterruptedException {
        if (driver.findElements(By.xpath("(//table//tbody)[3]//tr//td[3]")).size() > 0) {

            int size = driver.findElements(By.xpath("(//table//tbody)[3]//tr//td[3]")).size();
            for (int i = 0; i < size; i++) {
                String key = driver.findElements(By.xpath("(//table//tbody)[3]//tr//td[3]")).get(i).getText();
                del_Asset.add(key);
            }
            System.out.println(del_Asset);
            for (int i = 0; i < size; i++) {
                driver.findElement(delete).click();
            }
            driver.findElement(save_btn).click();
            Thread.sleep(2000);
        } else {
            String error = driver.findElement(By.xpath("//*[@class='modal-body']//h5")).getText();
            Assert.assertEquals(error, message);


        }

    }

    public void verify_delete_watchlist(String Asset) {
        int size = driver.findElements(By.xpath("(//table//tbody)[1]//tr//td[1]//a[text()='" + Asset + "']")).size();
        if (size == 0) {
            System.out.println("successfully deleted");
        }
    }

    public void verify_delete(String message) {
        if (driver.findElements(By.xpath("//*[text()='Watchlist']//ancestor::div[@class='col-12 mb-4']//table//tbody")).size() > 0) {
            for (int i = 0; i < del_Asset.size(); i++) {
                String name = driver.findElement(By.xpath("(//table//tbody)[1]//tr//td[1]//a[text()='" + del_Asset.get(i) + "']")).getText();
                if (!del_Asset.get(i).contains(name)) {
                    Assert.fail("Expected:" + name + "But Found:" + del_Asset.get(i));
                }
            }
        }else {
            String error = driver.findElement(By.xpath("//*[text()='Watchlist']//ancestor::div[@class='col-12 mb-4']//h5")).getText();
            Assert.assertEquals(error, message);
        }
    }


}
