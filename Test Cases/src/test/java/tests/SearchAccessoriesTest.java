package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchAccessoriesTest {
    private WebDriver driver;
    MainPage mainPage;

    @BeforeMethod
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ksuna/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
    }   

   @Test
    public void isNewPateCreated() throws InterruptedException {
        Thread.sleep(2500);
        mainPage = new MainPage(driver);
        Thread.sleep(2500);
        mainPage.OpenPage();
        Thread.sleep(2500);
        mainPage.EnterTextToSearchField("bomber");
        Thread.sleep(2500);
        mainPage.ChooseColorAndSize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        driver = null;
    }
}
