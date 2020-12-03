package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestNumOfPostsInGenCyc {
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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/strong[1]")));

        String actualUsername = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/strong[1]")).getText().trim();
        Assert.assertEquals(actualUsername, "mma.ramocve");
    }

    @Test(priority = 1, testName = "Check if number of posts in first theme is greater than number of days in this year till today")
    // Check if number of posts in first theme is greater than number of days in this year till today
    public void checkNumOfPostsInGCD() {
        WebElement forumTab = driver.findElement(By.xpath(Home.forumTabXPath));
        WebElement bikeForumSubmenu = driver.findElement(By.xpath(Home.bikeForumSubmenuXPath));
        Actions action = new Actions(driver);
        action.moveToElement(forumTab).perform();
        action.moveToElement(bikeForumSubmenu).click().perform();

        Calendar numOfDays = Calendar.getInstance();
        int dayOfYear = numOfDays.get(Calendar.DAY_OF_YEAR);
        System.out.println("Number of days in this year till today: " + dayOfYear);

        WebElement baseTable = driver.findElement(By.className("tbox"));

        WebElement firstTheme = baseTable.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[3]"));
        String firstThemeTitle = firstTheme.findElement(By.xpath("//*[@id=\"f7\"]/div[1]/h2/a/strong")).getText();
        String firstThemePostsNo = firstTheme.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[3]/div/div[5]")).getText().replaceAll(",", "");

        System.out.println("The number of posts in " + firstThemeTitle + " is " + firstThemePostsNo + ".");

        int postsNo = Integer.parseInt(firstThemePostsNo);

        Assert.assertTrue(dayOfYear < postsNo);
        System.out.println("Number of posts is greater than number of days.");

    }
}
