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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestUpdateUserData {
    private WebDriver driver;
    private WebDriverWait wait;
    private String initialEmail = "juan.perez@example.com";

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws InterruptedException {
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
        driver.get("http://localhost:3000/#/");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));

        email.sendKeys(initialEmail);
        password.sendKeys("12345678");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        // Wait for the login to complete (adjust timeout as needed)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio"));

        // Navigate to the desired page after login
        driver.navigate().to("http://localhost:3000/#/inicio/mi-perfil");

        // Optional: Wait for the new page to load if necessary
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mi-perfil"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // Perfil editado con exito
    @Test
    void CP01_Test() {
//        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
//        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.jpg");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Ashel");

        WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Vasquez");

        WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("Ashelturc0@gmail.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();

        String messageXpath = "//div[@id='root']/div/div[2]/form/div";
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        assertTrue(messageElement.isDisplayed(), "Message is not displayed: Perfil editado");
        initialEmail = "Ashelturc0@gmail.com";
    }

    @Test
    void CP02_Test() {
        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.png");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys("Raquel");

        WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Gonza");

        WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("Raquel-28@hmail.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();
        initialEmail = "Raquel-28@hmail.com";

        String messageXpath = "//div[@id='root']/div/div[2]/form/div";
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        assertTrue(messageElement.isDisplayed(), "Message is not displayed: Perfil editado");
    }

    @Test
    void CP03_Test() {
        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.gif");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Akira");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Alvarado");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("Sapito18@gmail.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();
        initialEmail = "Sapito18@gmail.com";

        String messageXpath = "//div[@id='root']/div/div[2]/form/div";
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        assertTrue(messageElement.isDisplayed(), "Message is not displayed: Perfil editado");
    }

    @Test
    void CP04_Test() {
        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.svg");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Diego");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Zavala");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("Diego_Sx@gmail.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();
        initialEmail = "Diego_Sx@gmail.com";

        String messageXpath = "//div[@id='root']/div/div[2]/form/div";
        WebElement messageElement = driver.findElement(By.xpath(messageXpath));
        assertTrue(messageElement.isDisplayed(), "Message is not displayed: Perfil editado");
    }

    // Formato de imagen no valido
//    @Test
//    void CP05_Test()  {
//
//        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
//        changeImageButton.click();
//
////        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
////        file.sendKeys("C:\\g5\\file.exe");
//
//        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
//        nameEdit.click();
//        WebElement nameInput = driver.findElement(By.name("name"));
//        nameInput.clear();
//        nameInput.sendKeys("Ysaac");
//
//        WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
//        lastNameEdit.click();
//        WebElement lastNameInput = driver.findElement(By.name("lastName"));
//        lastNameInput.clear();
//        lastNameInput.sendKeys("Correa");
//
//        WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
//        emailEdit.click();
//        WebElement emailInput = driver.findElement(By.name("email"));
//        emailInput.clear();
//        emailInput.sendKeys("aysaacUE5@gmail.com");
//
//        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
//        submitButton.click();
//
//        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
//        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
//        initialEmail = "aysaacUE5@gmail.com";
//        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Formato de imagen no valido.");
//    }

    // Nombre no valido
    @Test
    void CP06_Test()  {
        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.png");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Juan Alonso Bizantino Carlos Cesar Abel");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Alvarado");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("juan.perez@example.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Nombre no valido.");
    }

    @Test
    void CP07_Test() {
        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.gif");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("123.45");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Campos");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("maria.garcia@example.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Nombre no valido.");
    }

    // Apellido no valido
    @Test
    void CP08_Test() {

        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.gif");

       WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Maria");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("988:05:00.000");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("maria.marquez@example.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Apellido no valido.");
    }

    @Test
    void CP09_Test() throws InterruptedException {

        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.jpg");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Garcia");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("ApellidoMuyLargoDeMasDe25Caracteres");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("garcia.johnson@example.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[4]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Apellido no valido.");
    }

    // Correo no valido
    @Test
    void CP10_Test() throws InterruptedException {

        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.svg");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Laura");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Martinez");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("123457&dominio.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Correo no valido.");
    }

    @Test
    void CP11_Test() throws InterruptedException {

        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.png");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Andrea");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Sanchez");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("nombre@:com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Correo no valido.");
    }

    @Test
    void CP12_Test() throws InterruptedException {

        WebElement changeImageButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/button"));
        changeImageButton.click();

//        WebElement file = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div/div[2]/label/input"));
//        file.sendKeys("C:\\g5\\file.svg");

        WebElement nameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[2]/div/div/button"));
        nameEdit.click();
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.clear();
        nameInput.sendKeys("Ana");

         WebElement lastNameEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[2]/button"));
        lastNameEdit.click();
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Ramirez");

         WebElement emailEdit = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        emailEdit.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys("14526@.com");

        WebElement submitButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/form/div[3]/div/div[3]/button"));
        submitButton.click();

        String errorMessageXpath = "//div[@id='root']/div/div[2]/form/div/h5";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Correo no valido.");
    }
}