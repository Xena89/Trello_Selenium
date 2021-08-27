package site.panarina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloLoginAndCreateNewBoard {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToTrello();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button/p[text()='Создать']")).click();
        driver.findElement(By.xpath("//button/span[text()='Создайте доску']")).click();
        driver.findElement(By.xpath("//*[@id=\"layer-manager-overlay\"]/div/div/div/div[1]/div/input")).sendKeys("Еще одна доска");
        driver.findElement(By.xpath("//*[@id=\"layer-manager-overlay\"]/div/div/div/div[2]/div[3]/button")).click();

        driver.quit();
    }
    public static void loginToTrello() throws InterruptedException {
        driver.get("https://trello.com/ru/login");
        driver.findElement(By.id("user")).sendKeys("quickusja89@hotmail.com");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("100989quick");
        driver.findElement(By.xpath("//button[contains(@id,'login-submit')]")).click();
    }
}
