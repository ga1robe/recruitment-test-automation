package pl.amberteam.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.locators.Exercise2Locators;

import java.util.concurrent.TimeUnit;

public class Exercise2Page {

    WebDriver driver;
    WebDriverWait wait;
    Exercise2Locators exercise2Locators;
    Actions actions;

    public Exercise2Page(WebDriver driver) {
        this.driver = driver;
        this.exercise2Locators = new Exercise2Locators();
        PageFactory.initElements(driver, exercise2Locators);
        this.wait = new WebDriverWait(driver, 12);
        this.actions = new Actions(driver);
    }

    public void pressButton1() {
        wait.until(ExpectedConditions.visibilityOf(exercise2Locators.getButton1()));
        if(exercise2Locators.getButton1().isEnabled()) {
            exercise2Locators.getButton1().click();
            exercise2Locators.getButton1().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

    }

    public void writeToT14(String s) {
        wait.until(ExpectedConditions.visibilityOf(exercise2Locators.getT14()));
        if(exercise2Locators.getT14().isDisplayed()) {
            exercise2Locators.getT14().click();
            exercise2Locators.getT14().clear();
            exercise2Locators.getT14().sendKeys(s);
        }
    }

    public String getTrialCode() {
        wait.until(ExpectedConditions.visibilityOf(exercise2Locators.getTrailCode()));
        if(exercise2Locators.getTrailCode().isDisplayed()) {
            exercise2Locators.getTrailCode().click();
            return exercise2Locators.getTrailCode().getText();
        }
        return "";
    }

    public void pressSolutionButton() {
        wait.until(ExpectedConditions.visibilityOf(exercise2Locators.getSolutionButton()));
        if(exercise2Locators.getSolutionButton().isEnabled()) {
            exercise2Locators.getSolutionButton().click();
            exercise2Locators.getSolutionButton().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
}
