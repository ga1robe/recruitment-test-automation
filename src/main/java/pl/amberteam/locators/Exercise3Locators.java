package pl.amberteam.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Exercise3Locators {
    @FindBy(css=".row select#s13.u-full-width")
    private WebElement s13;

    @FindBy(css=".row select#s13.u-full-width option")
    private List<WebElement> s13options;

    @FindBy(css="#trail > code")
    private WebElement trailCode;

    @FindBy(id="solution")
    private WebElement solutionButton;

    /*
        Getters
     */

    public WebElement getTrailCode() {
        return trailCode;
    }

    public WebElement getSolutionButton() {
        return solutionButton;
    }

    public WebElement getS13() { return s13; }

    public List<WebElement> getS13options() {
        return s13options;
    }
}
