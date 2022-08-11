package com.nttdata.steps;

import com.nttdata.page.pruebaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pruebaLSteps {

    private WebDriver driver;

    //constructor
    public pruebaLSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(pruebaPage.userInputli);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pruebaPage.loginButtonli));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(pruebaPage.passInputli).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        try {
            this.driver.findElement(pruebaPage.loginButtonli).click();
        }catch (Exception e){

        }

    }

}
