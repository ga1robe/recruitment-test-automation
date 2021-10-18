package pl.amberteam.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Exercise2Locators {


    //Selector:#t14
    @FindBy(id="t14")
    private WebElement t14;

    //Selector:#btnButton1
    @FindBy(css="body > div > div:nth-child(5) > div > #btnButton1")
    private WebElement button1;

    //Selector:#trail > code
    @FindBy(css="#trail > code")
    private WebElement trailCode;

    //Selector:body > div > div.twelve.columns > #solution
    @FindBy(id="solution")
    private WebElement solutionButton;

    /*
        Getters
     */

    public WebElement getT14() {
        return t14;
    }

    public WebElement getButton1() {
        return button1;
    }

    public WebElement getTrailCode() {
        return trailCode;
    }

    public WebElement getSolutionButton() {
        return solutionButton;
    }
}
