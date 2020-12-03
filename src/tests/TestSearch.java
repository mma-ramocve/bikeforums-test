package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class TestSearch {
    public WebDriver driver;

    @BeforeClass
    public void getHomePage() {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Home.homeUrl);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 0, testName = "Test search -> 'capriolo'")
    // Test search -> 'capriolo'
    public void searchPosts() {

        WebElement searchField = driver.findElement(By.xpath(Home.searchFieldXPath));
        searchField.clear();
        searchField.sendKeys("capriolo");


        WebElement searchButton = driver.findElement(By.xpath(Home.searchButtonXPath));
        searchButton.click();


        String actualPageTitle = driver.findElement(By.xpath("//u[contains(text(),'capriolo')]")).getText().trim();
        Assert.assertEquals(actualPageTitle, "capriolo");
    }

    @Test(priority = 1, testName = "Test open post Greetings from Serbia")
    // Test open post Greetings from Serbia
    public void openPostGreetingsFromSerbia() {

        WebElement threadGreetingsFromSerbia = driver.findElement(By.linkText("Greetings from Serbia"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", threadGreetingsFromSerbia);
        threadGreetingsFromSerbia.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bikeforums.net/introductions/1100781-greetings-serbia.html";

        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
