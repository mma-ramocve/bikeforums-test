package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home;
import pages.LoggedInHome;

import java.util.concurrent.TimeUnit;

public class TestLogIn {
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

    @Test(priority = 0, testName = "Test login with valid credentials")
    // Test login with valid credentials
    public void logInExistingUser() {
        WebElement username = driver.findElement(By.xpath(Home.logInUsernameXpath));
        username.clear();
        username.sendKeys("mma.ramocve");

        WebElement password = driver.findElement(By.xpath(Home.logInPasswordXpath));
        password.clear();
        password.sendKeys("Antika_1");

        WebElement loginButton = driver.findElement(By.xpath(Home.logInButtonXpath));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/strong[1]")));

        String actualUsername = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/strong[1]")).getText().trim();
        Assert.assertEquals(actualUsername, "mma.ramocve");
    }

    @Test(priority = 1, testName = "Test if click on Forum -> Bike Forums -> Classic & Vintage submenu takes to correct page")
    // Test if click on Forum -> Bike Forums -> Classic & Vintage submenu takes to correct page
    public void getClassicVintageDiscussion() {
        WebElement forumTab = driver.findElement(By.xpath(LoggedInHome.forumTabXPath));
        WebElement bikeForumSubmenu = driver.findElement(By.xpath(LoggedInHome.bikeForumSubmenuXPath));
        WebElement classicVintageSubmenu = driver.findElement(By.xpath(LoggedInHome.classicVintageSubmenuXPath));
        Actions action = new Actions(driver);
        action.moveToElement(forumTab).perform();
        action.moveToElement(bikeForumSubmenu).perform();
        action.moveToElement(classicVintageSubmenu).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/strong[1]")));

        String actualPageTitle = driver.findElement(By.xpath("//body/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]")).getText().trim();
        Assert.assertEquals(actualPageTitle, "Sub-Forums: Classic & Vintage");
    }

    @Test(priority = 2, testName = "Test to sort posts in the Classic & Vintage theme from the beginning, ascending")
    // Test to get the oldest post in the Classic & Vintage theme, 'retro or vintage cycling wear'
    public void sortClassicVintagePostsASC() {
        Select objSelect1 = new Select(driver.findElement(By.xpath(LoggedInHome.sortOrderMenuXPath)));
        objSelect1.selectByVisibleText("Ascending");
        Select objSelect2 = new Select(driver.findElement(By.xpath(LoggedInHome.sortFromTheMenuXPath)));
        objSelect2.selectByVisibleText("Beginning");
        driver.findElement(By.xpath(LoggedInHome.showThreadsButtonXPath)).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bikeforums.net/classic-vintage/?pp=50&sort=lastpost&order=asc&daysprune=-1";

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 3, testName = "Test to get the oldest post in the Classic & Vintage theme")
    // Test to get the oldest post in the Classic & Vintage theme
    public void getTheOldestClassicVintagePost() {
        WebElement threadRetro = driver.findElement(By.linkText("retro or vintage cycling wear"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", threadRetro);
        threadRetro.click();


        String actualPostTitle = driver.findElement(By.xpath("//h1[contains(text(),'retro or vintage cycling wear')]")).getText().trim();
        Assert.assertEquals(actualPostTitle, "retro or vintage cycling wear");
    }
}
