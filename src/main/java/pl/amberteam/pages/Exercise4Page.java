package pl.amberteam.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.amberteam.locators.Exercise4Locators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise4Page {

    WebDriver driver;
    WebDriverWait wait;
    Exercise4Locators exercise4Locators;
    Actions actions;

    public Exercise4Page(WebDriver driver) {
        this.driver = driver;
        this.exercise4Locators = new Exercise4Locators();
        PageFactory.initElements(driver, exercise4Locators);
        this.wait = new WebDriverWait(driver, 16);
        this.actions = new Actions(driver);
    }

    public String getTrialCode() {
        wait.until(ExpectedConditions.visibilityOf(exercise4Locators.getTrailCode()));
        if(exercise4Locators.getTrailCode().isDisplayed()) {
            exercise4Locators.getTrailCode().click();
            return exercise4Locators.getTrailCode().getText();
        }
        return "";
    }

    public void pressSolutionButton() {
        wait.until(ExpectedConditions.visibilityOf(exercise4Locators.getSolutionButton()));
        if(exercise4Locators.getSolutionButton().isEnabled()) {
            exercise4Locators.getSolutionButton().click();
            exercise4Locators.getSolutionButton().sendKeys(Keys.SPACE);
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    public void chooseColour(int i, String s) {
        List<WebElement> radioInputs;
        switch(i){
            case 0:
                radioInputs = exercise4Locators.getRadioInputsG0();
                break;
            case 1:
                radioInputs = exercise4Locators.getRadioInputsG1();
                break;
            case 2:
                radioInputs = exercise4Locators.getRadioInputsG2();
                break;
            case 3:
                radioInputs = exercise4Locators.getRadioInputsG3();
                break;
            default:
                radioInputs = new ArrayList<>();
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(exercise4Locators.getRadioGroups()));
        if(exercise4Locators.getRadioGroups().get(i).isDisplayed()) {
            String[] wordsInTable = exercise4Locators.getRadioGroups().get(i).getText().split("\n");
            String headOfGroup = wordsInTable[0];
            System.out.println("head-of-group(" + i + "): \"" + headOfGroup + "\"");

            int selectedIndex = 0;
            for (int w = 1; w < wordsInTable.length; w++) {
                if(wordsInTable[w].contains(s)) {
                    selectedIndex = w - 1;
                    System.out.println("selected-" + selectedIndex + "-word-in-text-of-group(" + i + "): \"" + wordsInTable[w] + "\"");
                }
            }

            if(radioInputs.get(i).getAttribute("name").contains("s"+String.valueOf(i))) {
                System.out.println("selected-" + selectedIndex + "-name-of-input(" + i + "): \"" + radioInputs.get(selectedIndex).getAttribute("name") + "\"");
                System.out.println("selected-" + selectedIndex + "-value-of-input(" + i + "): \"" + radioInputs.get(selectedIndex).getAttribute("value") + "\"");
                radioInputs.get(selectedIndex).click();
            }
        }
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
}
