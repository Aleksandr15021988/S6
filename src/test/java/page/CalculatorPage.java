package page;
import Model.CalculatorData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.CalculatorDataCreator;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class CalculatorPage extends AbstractPage {
private final String CALC_URL ="https://cloud.google.com/products/calculator/";
    CalculatorData calculatorData = CalculatorDataCreator.withCredentialsFromProperty();

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")
    private WebElement TotalCost;
    @FindBy(id="idIframe")
    private WebElement SwitchFrame;
    @FindBy(xpath = "//*[@id='dialogContent_407']/form/md-dialog-actions/button[2]")
    private WebElement SendEmail;
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]/div")//*[@id="compute"]/md-list/md-list-item[3]/div
    private WebElement ValueOfMachineTypeFromTable;
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[2]/div")
    private WebElement ValueOfMachineClassFromTable;
    private WebElement ValueOfMachineClassFromDropDown;
    private WebElement ValueOfMachineTypeFromDropDown;

    public WebElement getTotalCost() {
        return TotalCost;
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public CalculatorPage openPage ()
    { driver.navigate().to(CALC_URL);
     driver.switchTo().frame(SwitchFrame);
        return this;}



        public void switchFrame(){
            driver.switchTo().frame(SwitchFrame);
        }

        public void pasteEmail() throws IOException, UnsupportedFlavorException {
            String buffer=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        new WebDriverWait(driver,10)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(calculatorData.getEmail()))).sendKeys(buffer);





        }
        public void sendEmail(){
        SendEmail.click();
        }




    public void findAndClickCalculatorElements()  {
        driver.findElement(By.xpath(calculatorData.getSearchForAProduct())).click();
        driver.findElement(By.xpath(calculatorData.getNumberOfInstances())).sendKeys("4");
        new WebDriverWait(driver,10)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(calculatorData.getOperatingSystemLocator()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
            By.xpath(calculatorData.getValueOfOperatingSystem()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getMachineClass()))).click();
        ValueOfMachineClassFromDropDown =new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfMachineClass())));
        ValueOfMachineClassFromDropDown.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getMachineType()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfMachineType()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(calculatorData.getAddGPU()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getNumberOfGPUs()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfNumberOfGPUs()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(calculatorData.getGPUType()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfGPUType()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getLocalSSD()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfLocalSSD()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getDatacenterLocation()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfDatacenterLocation()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(calculatorData.getCommitedUsage()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getValueOfCommitedUsage()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(calculatorData.getAddToEstimate()))).click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(calculatorData.getEmailEstimate()))).click();

    }

    public String getValueOfMachineClassFromTable() {
        return ValueOfMachineClassFromTable.getText();
       }

    public String getValueOfMachineClassFromDropDown() {
      return   new WebDriverWait(driver,10)
              .until(ExpectedConditions.presenceOfElementLocated
                      (By.xpath(calculatorData.getValueOfMachineClass()))).getText();

    }

    public String getValueOfMachineTypeFromTable() {
        return ValueOfMachineTypeFromTable.getText();
    }

    public String getValueOfMachineTypeFromDropDown() {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(calculatorData.getValueOfMachineType()))).getText();
    }






}
