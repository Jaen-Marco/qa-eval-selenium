package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){ this.driver.findElement(LoginPage.userInput).sendKeys(user);  }

    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

}
