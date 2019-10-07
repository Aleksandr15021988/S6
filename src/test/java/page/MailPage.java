package page;

import driver.DriverSingletone;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailPage extends AbstractPage {
    private static String MAIL_URL="https://10minutemail.net";
    @FindBy(xpath = "//*[@id='copy-button']")
    WebElement CopyAdressButton;


    public static String getMAIL_URL() {
        return MAIL_URL;
    }
    public MailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public MailPage openPage ()
    {
        driver.navigate().to(MAIL_URL);
        return this;
    }

    public void copyEmail(){
        CopyAdressButton.click();

    }
    public ReadMailPage openLetter(){
        new WebDriverWait(driver,180)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id='maillist']/tbody/tr[2]/td[2]/a[text()[contains(.,'Google Cloud Platform Price Estimate')]]"))).click();
        return new ReadMailPage(driver);
    }





}
