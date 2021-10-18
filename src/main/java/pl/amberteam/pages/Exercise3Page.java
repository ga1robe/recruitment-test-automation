package pl.amberteam.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.locators.Exercise3Locators;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Exercise3Page {

    WebDriver driver;
    WebDriverWait wait;
    Exercise3Locators exercise3Locators;
    Actions actions;

    public Exercise3Page(WebDriver driver) {
        this.driver = driver;
        this.exercise3Locators = new Exercise3Locators();
        PageFactory.initElements(driver, exercise3Locators);
        this.wait = new WebDriverWait(driver, 12);
        this.actions = new Actions(driver);
    }

    public String getTrialCode() {
        wait.until(ExpectedConditions.visibilityOf(exercise3Locators.getTrailCode()));
        if(exercise3Locators.getTrailCode().isDisplayed()) {
            exercise3Locators.getTrailCode().click();
            return exercise3Locators.getTrailCode().getText();
        }
        return "";
    }

    public void pressSolutionButton() {
        wait.until(ExpectedConditions.visibilityOf(exercise3Locators.getSolutionButton()));
        if(exercise3Locators.getSolutionButton().isEnabled()) {
            exercise3Locators.getSolutionButton().click();
            exercise3Locators.getSolutionButton().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    public void chooseColour(String s) {
        wait.until(ExpectedConditions.visibilityOf(exercise3Locators.getS13()));
        if(exercise3Locators.getS13().isEnabled()) {
            exercise3Locators.getS13().click();
            wait.until(ExpectedConditions.visibilityOfAllElements(exercise3Locators.getS13options()));
            exercise3Locators.getS13options().stream()
                    .filter(item -> item.getText().contains(s))
                    .collect(Collectors.toList())
                    .get(0).click();
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
}
