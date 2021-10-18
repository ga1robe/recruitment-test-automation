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

public class TestExercise3 {
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
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise3?seed=7d4c4605-4fe4-45b0-bde6-7caaff5cd3d0");
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        FileMethod.createFile();
    }

    @Test
    public void shouldBeGoodAnswerInDropdownListAction() {
        // Given
        // Arrange
        Exercise3Page exercise3Page = new Exercise3Page(driver);
        // When
        // Act
        exercise3Page.chooseColour("Mango Orange");
        // When
        // Act
        String trialCode = exercise3Page.getTrialCode();
        System.out.println("[trialCode] = " + trialCode);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'s13:v1\'", trialCode, containsString("s13:v1"));
        // When
        // Act
        exercise3Page.pressSolutionButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String trialCode2 = exercise3Page.getTrialCode();
        System.out.println("[trialCode] = " + trialCode2);
        // Then
        // Assert
        assertThat("Is does not contain " + "\'OK. Good answer\'", trialCode2, containsString("OK. Good answer"));
        // Write to file
        FileMethod.writeToFile("TestExercise3: " + "shouldBeGoodAnswerInDropdownListAction: " + "\n" +
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
