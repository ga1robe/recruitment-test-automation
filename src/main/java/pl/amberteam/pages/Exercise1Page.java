package pl.amberteam.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.locators.Exercise1Locators;

import java.util.concurrent.TimeUnit;

public class Exercise1Page {

    WebDriver driver;
    WebDriverWait wait;
    Exercise1Locators exercise1Locators;
    Actions actions;

    public Exercise1Page(WebDriver driver) {
        this.driver = driver;
        this.exercise1Locators = new Exercise1Locators();
        PageFactory.initElements(driver, exercise1Locators);
        this.wait = new WebDriverWait(driver, 12);
        this.actions = new Actions(driver);
    }

    public void pressButton1() {
        wait.until(ExpectedConditions.visibilityOf(exercise1Locators.getButton1()));
        if(exercise1Locators.getButton1().isEnabled()) {
            exercise1Locators.getButton1().click();
            exercise1Locators.getButton1().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

    }

    public void pressButton2() {
        wait.until(ExpectedConditions.visibilityOf(exercise1Locators.getButton2()));
        if(exercise1Locators.getButton2().isEnabled()) {
            exercise1Locators.getButton2().click();
            exercise1Locators.getButton2().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    public void pressSolutionButton() {
        wait.until(ExpectedConditions.visibilityOf(exercise1Locators.getSolutionButton()));
        if(exercise1Locators.getSolutionButton().isEnabled()) {
            exercise1Locators.getSolutionButton().click();
            exercise1Locators.getSolutionButton().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    public String getTrialText() {
        wait.until(ExpectedConditions.visibilityOf(exercise1Locators.getTrial()));
        if(exercise1Locators.getTrial().isDisplayed()) {
            exercise1Locators.getTrial().click();
            return exercise1Locators.getTrial().getText();
        }
        return "";
    }
}
