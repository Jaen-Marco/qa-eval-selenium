package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;
    LoginSteps loginSteps;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en en login")
    public void estoyEnElLogin() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @When("ingreso con el usuario {string}")
    public void ingresoConElUsuario(String user) {
        loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        screenShot();
    }

    @And("ingreso la clave {string}")
    public void ingresoLaClave(String clave) {
        loginSteps = new LoginSteps(driver);
        loginSteps.typePassword(clave);
        screenShot();
    }

    @And("clic en Iniciar Sesion")
    public void clicEnIniciarSesion() {
        loginSteps = new LoginSteps(driver);
        loginSteps.login();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
