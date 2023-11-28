package com.g5.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestRegisterUser {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3000/#/registro");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Registros exitosos
    @Test
    public void CP01_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Ashel Joseph");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Vasquez Palomino");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("ashel.vasquez@g5.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("Comida10");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("Comida10");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio"),
                "Expected redirection to http://localhost:3000/#/inicio");
    }

    @Test
    public void CP02_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Juan");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Perez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("juanperez@gmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("12345678");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("12345678");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio"),
                "Expected redirection to http://localhost:3000/#/inicio");
    }

    @Test
    public void CP03_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Maria");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Garcia");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("mariagarcia@hotmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("abc12345");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("abc12345");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio"),
                "Expected redirection to http://localhost:3000/#/inicio");
    }

    // Registros con nombres no validos
    @Test
    public void CP04_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Ash3l J0seph");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Vasquez Palomino");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("ashel.vasquez@yahoo.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("Comida10");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("Comida10");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Debe ingresar un nombre valido");
    }

    @Test
    public void CP05_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Ashel Joseph Vasquez Palomino");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Vasquez Palomino");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("ashel.vasquez@yahoo.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("Comida10");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("Comida10");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: El nombre debe tener menos de 25 caracteres");
    }
// Registros con apellidos no validos
    @Test
    public void CP06_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Pedro");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("V4squ3z P4l0m1n0");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("pedro.vasquez@gmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("pedrovasquez789");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("pedrovasquez789");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Debe ingresar un apellido valido");
    }

    @Test
    public void CP07_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Pedro");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Vasquez Palomino de la Cruz Villavicencio");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("pedro.vasquez@gmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("pedrov789");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("pedrov789");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: El apellido debe tener menos de 25 caracteres");
    }

    // Registro con correo no valido

    @Test
    public void CP08_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Jose");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Gomez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("123457&dominio.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("josegomez345");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("josegomez345");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Debe ingresar un correo valido");
    }

    @Test
    public void CP09_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Ana");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Rodriguez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("nombre@:com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("anarodriguez678");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("anarodriguez678");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Debe ingresar un correo valido");
    }

    @Test
    public void CP10_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Sofia");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Sanchez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("14526@.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("sofiasanchez234");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("sofiasanchez234");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Debe ingresar un correo valido");
    }

    // Registro incorrecto con contrasena menor a 8 caracteres
    @Test
    public void CP11_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Pablo");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Martinez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("pablo.martinez@gmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("123");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("123");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: La contrasena debe tener entre 8 y 16 caracteres");
    }

    // Registro incorrecto con contrasena de confirmacion diferente
    @Test
    public void CP12_Test() {
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input"));
        nameInput.sendKeys("Lucia");

        WebElement lastNameInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[2]"));
        lastNameInput.sendKeys("Garcia Fernandez");

        WebElement emailInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/input[3]"));
        emailInput.sendKeys("lucia.garcia@gmail.com");

        WebElement passwordInput =  driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input"));
        passwordInput.sendKeys("abcd1234");

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/input"));
        confirmPasswordInput.sendKeys("Comida10");

        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/div[2]/div[2]/div[175]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        String errorMessageXpath = "//div[@id='root']/div/div/form/div[3]";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Las contrasenas no coinciden");
    }
}

