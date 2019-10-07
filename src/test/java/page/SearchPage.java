package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPage {
    private String Search_Url="https://cloud.google.com/s/results/?q=Google+Cloud+Platform+Pricing+Calculator&p=%2F";
    @FindBy (xpath="//b[contains(.,'Google Cloud Platform Pricing Calculator')]")
    private WebElement cloudCalculator;
//*[@id='___gcse_0']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div/a


    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public SearchPage openPage() {
        driver.navigate().to(Search_Url);
        return this;
    }
    public CalculatorPage clickCloudCalculator(){
        cloudCalculator.click();
        return new CalculatorPage(driver);
    }
}
