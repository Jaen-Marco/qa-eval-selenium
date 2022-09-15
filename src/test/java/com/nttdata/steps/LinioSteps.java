package com.nttdata.steps;

import com.nttdata.page.LinioHomePage;
import org.openqa.selenium.WebDriver;

public class LinioSteps {

    private WebDriver driver;

    public LinioSteps(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return this.driver.findElement(LinioHomePage.sNombreCliente).getText();
    }


    public void productsInternationals() {
        this.driver.findElement(LinioHomePage.sProductInternational).click();
    }

    public void selectFirstProduct() {
        this.driver.findElement(LinioHomePage.firstCardProduct).click();
    }
}
