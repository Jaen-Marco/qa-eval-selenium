package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioSteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioStepDefs {

    private WebDriver driver;
    private Scenario scenario;
    LinioSteps linioSteps;
    private ProductSteps productSteps(WebDriver driver){
        return new ProductSteps(driver);
    }

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

    //@After
    //public void quitDriver(){
    //    driver.quit();
    //}

    @Then("que el nombre de mi usuario {string} figure")
    public void queElNombreDeMiUsuarioFigure(String userName) {
        linioSteps = new LinioSteps(driver);
        linioSteps.getUserName();
        screenShot();
    }

    @Given("estoy en la url")
    public void estoyEnLaUrl() {
        driver.get("https://www.linio.com.pe/");
        screenShot();
    }

    @When("doy click en Productos Internacionales")
    public void doyClickEnProductosInternacionales() {
        linioSteps = new LinioSteps(driver);
        linioSteps.productsInternationals();
        screenShot();
    }

    @And("selecciono el primero producto")
    public void seleccionoElPrimeroProducto() {
        linioSteps = new LinioSteps(driver);
        linioSteps.selectFirstProduct();
        screenShot();
    }

    @And("agregar al carrito")
    public void agregarAlCarrito() {
        productSteps(driver).addProduct();
        screenShot();
    }

    @Then("debe mostrar un span con mensaje {string}")
    public void debeMostrarUnSpanConMensaje(String mensaje) {
        String confirmacion = productSteps(driver).getMessage();
        screenShot();
        Assertions.assertEquals(confirmacion, mensaje);
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
