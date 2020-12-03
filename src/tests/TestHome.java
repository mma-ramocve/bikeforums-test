package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class TestHome {

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

    @Test(priority = 0, testName = "Test if click on Marketplace in top menu from home page takes to correct page")
    // Test if click on Marketplace in top menu from home page takes to correct page
    public void getMarketplaceFromHomePage() {
        WebElement marketplaceTab = driver.findElement(By.xpath(Home.marketplaceTabXPath));
        marketplaceTab.click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, Home.marketplaceUrl);
    }

    @Test(priority = 1, testName = "Test if click on site logo returns to home page")
    // Test if click on site logo returns to home page
    public void getHomePageFromMarketplace() {
        WebElement logo = driver.findElement(By.xpath(Home.logoXpath));
        logo.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Welcome to the Bike Forums.')]")));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, Home.homeUrl);
    }

    @Test(priority = 2, testName = "Test if click on New Posts tab in top menu takes to Posts From Last Day")
    // Test if click on New Posts tab in top menu takes to Posts From Last Day
    public void getNewPostsFromHomePage() {
        WebElement newPostsTab = driver.findElement(By.xpath(Home.newPostsTabXPath));
        newPostsTab.click();

        String actualPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Posts From Last Day')]")).getText().trim();
        Assert.assertEquals(actualPageTitle, "Posts From Last Day");
    }

    @Test(priority = 3, testName = "Test if click on Forum -> Bike Forums -> General Cycling Discussion submenu takes to correct page")
    // Test if click on Forum -> Bike Forums -> General Cycling Discussion submenu takes to correct page
    public void getGeneralCyclingDiscussion() {
        WebElement forumTab = driver.findElement(By.xpath(Home.forumTabXPath));
        WebElement bikeForumSubmenu = driver.findElement(By.xpath(Home.bikeForumSubmenuXPath));
        WebElement generalCyclingSubmenu = driver.findElement(By.xpath(Home.generalCyclingSubmenuXPath));
        Actions action = new Actions(driver);
        action.moveToElement(forumTab).perform();
        action.moveToElement(bikeForumSubmenu).perform();
        action.moveToElement(generalCyclingSubmenu).click().perform();

        String actualPageTitle = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/strong[1]")).getText().trim();
        Assert.assertEquals(actualPageTitle, "General Cycling Discussion");
    }

    @Test(priority = 4, testName = "Test if click on Contact Us tab in bottom menu takes to Contact Us Form")
    // Test if click on Contact Us tab in bottom menu takes to Contact Us Form
    public void getContactUs() {
        WebElement contactUs = driver.findElement(By.xpath(Home.contactUsTabXPath));
        contactUs.click();

        String actualPageTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/div/h1/strong")).getText().trim();
        Assert.assertEquals(actualPageTitle, "Contact Us");
    }
}
