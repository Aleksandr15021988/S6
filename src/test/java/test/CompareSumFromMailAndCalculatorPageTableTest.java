package test;

import Util.TestListener;
import driver.DriverSingletone;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.MailPage;
import page.MainPage;
import page.ReadMailPage;
import service.Switcher;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

@Listeners({TestListener.class})
public class CompareSumFromMailAndCalculatorPageTableTest {
    MainPage mainPage=new MainPage(DriverSingletone.getDriver());
    CalculatorPage calculatorPage =
            new CalculatorPage(DriverSingletone.getDriver());
    MailPage mailPage=new MailPage(DriverSingletone.getDriver());
    ReadMailPage readMailPage=new ReadMailPage(DriverSingletone.getDriver());
    String TotalCostFromCakculatorPage;
    String b;

    @Test
    public void compareSumFromTableAndCalculatorPage() throws IOException, UnsupportedFlavorException {
        mainPage.openPage().inputAndFindDataInSearch().clickCloudCalculator().switchFrame();
        calculatorPage.findAndClickCalculatorElements();
        Switcher.openPageInNewWindow();
        mailPage.openPage().copyEmail();
        Switcher.switchToFirstPage();

        calculatorPage.switchFrame();
        TotalCostFromCakculatorPage=calculatorPage.getTotalCost().getText();
        calculatorPage.pasteEmail();
        calculatorPage.sendEmail();
        Switcher.switchToSecondPage();
        mailPage.openLetter();
        b=readMailPage.getTotalCost().getText();
        Assert.assertTrue ((TotalCostFromCakculatorPage).
                contains(b)
        );
    }



}
