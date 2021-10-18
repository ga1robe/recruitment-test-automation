package pl.amberteam.pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.amberteam.supports.FileMethod;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class TestExercise2 {
    private WebDriver driver;

    @Before
    public void setUp(){
        String engine = "chrome"; /* second option: "gecko"; */
        switch(engine){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","/home/robert/.config/google-chrome/Drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "gecko":
                System.setProperty("webdriver.gecko.driver","/home/robert/.config/mozilla/Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + engine);
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise2?seed=7d4c4605-4fe4-45b0-bde6-7caaff5cd3d0");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        FileMethod.createFile();
    }

    @Test
    public void shouldBeGoodAnswerInEditboxAction() {
        // Given
        // Arrange
        Exercise2Page exercise2Page = new Exercise2Page(driver);
        // When
        // Act
        exercise2Page.writeToT14("Quite alone.");
        exercise2Page.pressButton1();
        // When
        // Act
        String trialCode = exercise2Page.getTrialCode();
        System.out.println("[trialCode] = " + trialCode);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'t14:Quite alone.b1\'", trialCode, containsString("t14:Quite alone.b1"));
        // When
        // Act
        exercise2Page.pressSolutionButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String trialCode2 = exercise2Page.getTrialCode();
        System.out.println("[trialCode] = " + trialCode2);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'OK. Good answer\'", trialCode2, containsString("OK. Good answer"));
        // Write to file
        FileMethod.writeToFile("TestExercise2: " + "shouldBeGoodAnswerInEditboxAction: " + "\n" +
                "trial Code : \'" + trialCode + "\'\n" +
                "after press button 'Check Solution' trial Code: \'" + trialCode2 + "\'" +
                ""
        );
    }

    @After
    public void tearDown(){

        driver.quit();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileMethod.closeWriter();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}