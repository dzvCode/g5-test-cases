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

public class TestCreatePlan {
    private WebDriver driver;
    private WebDriverWait wait;

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

        email.sendKeys("diego.zavala@unmsm.edu.pe");
        password.sendKeys("12345678");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/button")).click();

        // Wait for the login to complete (adjust timeout as needed)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio"));

        // Navigate to the desired page after login
        driver.navigate().to("http://localhost:3000/#/inicio/buscar");

        // Optional: Wait for the new page to load if necessary
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/buscar"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    void CP01_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("01-01-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0900AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Comida rapida");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("50");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");
    }

    @Test
    void CP02_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[2]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("05-15-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("1130AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Viveres");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("150.10");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");
    }

    @Test
    void CP03_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("07-31-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0245PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Boletos para el cine");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("250");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");
    }

    // Fechas no validas
    @Test
    void CP04_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("25-12-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0230PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Pago de servicios");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("60.99");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    @Test
    void CP05_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[2]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("01-32-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("1100AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Boletos para el cine");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("150");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    @Test
    void CP06_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("0y-ho-21jk");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0927AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Compra de regalos");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("80.50");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    // Horas no validas
    @Test
    void CP07_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("09-22-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("1300AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Compra de regalos");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("20.20");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    @Test
    void CP08_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("07-31-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("9999PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Plantas o jardineria");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("25");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    // Descripcion no valida
    @Test
    void CP09_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("11-05-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0515PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Compré un montón de cosas geniales en la tienda de descuentos");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("150.30");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    @Test
    void CP10_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("01-01-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0745AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Suscripción para ver todas las series más famosas del mundo 🐀✅");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("90");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    // Mongo a gastar no valido
    @Test
    void CP11_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("05-10-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0835AM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Agua y comida");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("0");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/mis-planes"));
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/inicio/mis-planes"),
                "Expected redirection to http://localhost:3000/#/inicio/mis-planes");

    }

    @Test
    void CP12_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("05-15-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0354PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Revistas o periodicos");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("12345678901");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        String errorMessageXpath = "//body/div/div/div[2]/div/div";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Plan sin crear: Monto con demasiadas cifras.");

    }

    @Test
    void CP13_Test() {
        driver.navigate().to("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY");
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/#/inicio/crear-plan/ChIJmQANaEbJBZER6aRkQID43sY"));

        WebElement category = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div"));
        category.click();
        WebElement selected = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[3]"));
        selected.click();
        WebElement date = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input"));
        date.sendKeys("01-12-2023");

        WebElement time = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/input[2]"));
        time.click();
        time.sendKeys("0850PM");
        time.click();

        WebElement description = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input"));
        description.sendKeys("Telefonia movil");
        WebElement cost = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div/input[2]"));
        cost.sendKeys("-210");
        WebElement sendCreatePlan = driver.findElement(By.xpath("//body/div/div/div[2]/div/button"));
        sendCreatePlan.click();

        String errorMessageXpath = "//body/div/div/div[2]/div/div";
        WebElement errorMessageElement = driver.findElement(By.xpath(errorMessageXpath));
        assertTrue(errorMessageElement.isDisplayed(), "Error message is not displayed: Plan sin crear: El monto no puede ser negativo");

    }
}
