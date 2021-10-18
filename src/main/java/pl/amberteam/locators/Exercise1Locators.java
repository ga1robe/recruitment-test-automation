package pl.amberteam.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Exercise1Locators {
    //Selector:#btnButton1
    @FindBy(css="body > div > div:nth-child(4) > div:nth-child(1) > #btnButton1")
    private WebElement button1;

    //Selector:#btnButton2
    //Selector:body > div > div:nth-child(4) > div:nth-child(2)
    @FindBy(css="body > div > div:nth-child(4) > div:nth-child(2) > #btnButton2")
    private WebElement button2;

    //Selector:body > div > div:nth-child(8) > pre > #trail > code
    @FindBy(css="body > div > div:nth-child(8)> pre > code")
    private WebElement trial;

    //
    //Selector:body > div > div.twelve.columns > #solution
    @FindBy(id="solution")
    private WebElement solutionButton;

    /*
        Getters
     */

    public WebElement getButton1() {
        return button1;
    }

    public WebElement getButton2() {
        return button2;
    }

    public WebElement getTrial() { return trial; }

    public WebElement getSolutionButton() { return solutionButton; }
}
