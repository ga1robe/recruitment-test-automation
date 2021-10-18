package pl.amberteam.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Exercise4Locators {
    //Selector:.container div.row.u-full-width
    @FindBy(css=".container div.row.u-full-width")
    private List<WebElement> radioGroups;

    //Selector:.container div.row.u-full-width input
    //Selector:.container div.row:nth-child(4)
    @FindBy(css=".container div.row:nth-child(4) input")
    private List<WebElement> radioInputsG0;

    //Selector:.container div.row:nth-child(5)
    @FindBy(css=".container div.row:nth-child(5) input")
    private List<WebElement> radioInputsG1;

    //Selector:.container div.row:nth-child(6)
    @FindBy(css=".container div.row:nth-child(6) input")
    private List<WebElement> radioInputsG2;

    //Selector:.container div.row:nth-child(7)
    @FindBy(css=".container div.row:nth-child(7) input")
    private List<WebElement> radioInputsG3;

    //Selector:#trail > code
    @FindBy(css="#trail > code")
    private WebElement trailCode;

    //Selector:body > div > div.twelve.columns > #solution
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

    public List<WebElement> getRadioGroups() {
        return radioGroups;
    }

    public List<WebElement> getRadioInputsG0() {
        return radioInputsG0;
    }

    public List<WebElement> getRadioInputsG1() {
        return radioInputsG1;
    }

    public List<WebElement> getRadioInputsG2() {
        return radioInputsG2;
    }

    public List<WebElement> getRadioInputsG3() {
        return radioInputsG3;
    }
}
