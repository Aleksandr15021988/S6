package test;

import driver.DriverSingletone;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CalculatorPage;

public class CompareValuesBetweenDrpDownAndTableTest {
    WebDriver driver=DriverSingletone.getDriver();

CalculatorPage calculatorPage=new CalculatorPage(driver);

@BeforeTest
public void setUp(){
    calculatorPage.openPage().findAndClickCalculatorElements();
}


    @Test
    public void compareMachineClassesValues(){

Assert.assertTrue((calculatorPage.getValueOfMachineClassFromTable()).
        contains(calculatorPage.getValueOfMachineClassFromDropDown()));}

    @Test
    public void compareMachineTypesValues(){

Assert.assertTrue(calculatorPage.getValueOfMachineTypeFromTable().
        contains(calculatorPage.getValueOfMachineTypeFromDropDown()));
    }


}

