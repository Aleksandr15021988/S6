package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReadMailPage extends AbstractPage {
    private String  ReadMailPage_URL = "https://10minutemail.net/readmail.html?mid=WR0bvu";
    @FindBy(xpath = "//*[@id='tab1']/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement TotalCost;

    public WebElement getTotalCost(){
        return TotalCost;
    }




    public ReadMailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ReadMailPage openPage ()
    { driver.navigate().to(ReadMailPage_URL);
        return this;
    }
}
