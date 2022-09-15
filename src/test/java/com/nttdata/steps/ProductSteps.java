package com.nttdata.steps;

import com.nttdata.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductSteps {

    private WebDriver driver;

    //contrsuctor
    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    public void addProduct() {
        this.driver.findElement(ProductPage.btnAgregarCarrito);
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getMessage(){
        return this.driver.switchTo().alert().getText();
    }

}
