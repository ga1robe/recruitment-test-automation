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

public class TestExercise1 {

    private WebDriver driver;

    @Before
    public void setUp(){
        String engine = "chrome"; /* second option: "gecko"; */
        switch(engine){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "gecko":
                System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + engine);
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise1?seed=58cb3fd9-bfe4-4f9b-92f9-1d9aba14a7bd");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        FileMethod.createFile();
    }

    @Test
    public void shouldBeGoodAnswerInThreeButtonsAction() {
        // Given
        // Arrange
        Exercise1Page exercise1Page = new Exercise1Page(driver);
        // When
        // Act
        exercise1Page.pressButton1();
        exercise1Page.pressButton2();
        exercise1Page.pressButton2();
        // When
        // Act
        String trialText = exercise1Page.getTrialText();
        System.out.println("[trialText] = " + trialText);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'b1b2b2\'", trialText, containsString("b1b2b2"));
        // When
        // Act
        exercise1Page.pressSolutionButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String trialText2 = exercise1Page.getTrialText();
        System.out.println("[trialText] = " + trialText2);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'OK. Good answer\'", trialText2, containsString("OK. Good answer"));
        // Write to file
        FileMethod.writeToFile("TestExercise1: " + "ShouldThreeButtonsAction: " + "\n" +
                "trial : \'" + trialText + "\'\n" +
                "after press button 'Check Solution' trial: \'" + trialText2 + "\'" +
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
