package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorypruebaSteps;

import com.nttdata.steps.pruebaLSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pruebaLStepsDef {
private  InventorypruebaSteps inventorypruebaSteps;
   private pruebaLSteps pruebaLSteps;
    private WebDriver driver;
    private Scenario scenario;

    private InventorypruebaSteps inventorypruebaSteps(WebDriver driver){
        return new InventorypruebaSteps(driver);
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

    @After
    public void quitDriver(){
        driver.quit();
    }



    @Dado("que me encuentro en la página de login de linio")
    public void queMeEncuentroEnLaPáginaDeLoginDeLinio() {
        driver.get("https://www.linio.com.co/account/login");
        screenShot();
    }

    @Cuando("inicio sesión con las credenciales email: {string} y contraseña: {string}")
    public void inicioSesiónConLasCredencialesEmailYContraseña(String user, String password) {
        pruebaLSteps = new pruebaLSteps(driver);
        pruebaLSteps.typeUser(user);
        pruebaLSteps.typePassword(password);

    }
    @Y("hago clic en el boton ingresar")
    public void hagoClicEnElBotonIngresar() {
        pruebaLSteps.login();
        screenShot();

    }

    @Entonces("valido que estoy en la pagina")
    public void validoQueEstoyEnLaPagina() {
    //    screenShot();
    }

    @Y("también valido que  exista un titulo {string}")
    public void tambiénValidoQueExistaUnTitulo(String title) {
        title =  inventorypruebaSteps(driver).getTitle();

        screenShot();
    }




    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }



}
