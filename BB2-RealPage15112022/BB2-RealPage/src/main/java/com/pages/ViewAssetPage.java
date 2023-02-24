package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViewAssetPage {

    private WebDriver driver;

    private By assetsredirection = By.xpath("//a[@href='/assets']");
    private By assetsverify = By.xpath("//h1[text()='Assets']");
    private By homeredirect = By.xpath("//a[@href='/home']");
    private By homeText = By.xpath("//h1[text()='Welcome back,']");
    private By filterinAsset = By.xpath("//button[text()=' Filter']");
    private By filterText = By.xpath("//*[text()='Filter']");
    private By grid = By.xpath("//*[@id=\"listGridView\"]");
    private By listgrid = By.xpath("//button[text()=' List']");
    private By cardgrid = By.xpath("//button[text()=' Cards']");
    private By newassetButton = By.xpath("//button[text()=' New Asset']");
    private By tableasset = By.xpath("//table");
    private By cards = By.xpath("//h6");
    private By editicon = By.xpath("//button[@title='Edit']//i");
    private By editText = By.xpath("//*text()='Edit Asset']");
    private By newassetText = By.xpath("//h5[text()='Create New  Asset']");
    private By canceButton = By.xpath("//button[text()='Cancel']");
    private  By multiImport = By.xpath("//button[@ngbtooltip='Import']");
    private By multiText = By.xpath("//h4[text()='Import Asset']");


    public ViewAssetPage(WebDriver driver) {

        this.driver = driver;
    }

    public void checkassetredict(){
        driver.findElements(assetsredirection).get(0).isEnabled();
        driver.findElements(assetsredirection).get(0).click();
        driver.findElement(assetsverify).isDisplayed();
        driver.findElements(assetsredirection).get(1).isEnabled();
        driver.findElements(assetsredirection).get(1).click();
        driver.findElement(assetsverify).isDisplayed();
        driver.findElement(filterinAsset).isDisplayed();
        driver.findElement(filterinAsset).click();
        driver.findElement(filterText).isDisplayed();
        driver.findElement(grid).isDisplayed();
        driver.findElement(grid).click();
        driver.findElement(listgrid).isDisplayed();
        driver.findElement(cardgrid).isDisplayed();
        driver.findElement(listgrid).click();
        driver.findElement(tableasset).isDisplayed();
        driver.findElements(editicon).get(0).isEnabled();
        driver.findElements(editicon).get(0).click();
        driver.findElement(editText).isDisplayed();
        driver.findElement(grid).click();
        driver.findElement(cardgrid).click();
        driver.findElement(cards).isDisplayed();
        driver.findElement(newassetButton).isDisplayed();
        driver.findElement(newassetButton).isEnabled();
        driver.findElement(newassetButton).click();
        driver.findElement(newassetText).isDisplayed();
        driver.findElement(canceButton).isEnabled();
        driver.findElement(canceButton).click();
        driver.findElement(multiImport).isEnabled();
        driver.findElement(multiImport).isDisplayed();
        driver.findElement(multiImport).click();
        driver.findElement(multiText).isDisplayed();
        driver.findElement(canceButton).isEnabled();
        driver.findElement(canceButton).click();
    }
    public void homecheck(){
        driver.findElement(homeredirect).isEnabled();
        driver.findElement(homeredirect).click();
        driver.findElement(homeText).isDisplayed();
    }






}
