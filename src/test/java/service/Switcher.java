package service;

import driver.DriverSingletone;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class Switcher {
     static ArrayList<String>tabs;
    static String buffer;


    public static  void openPageInNewWindow(){
        ((JavascriptExecutor) DriverSingletone.getDriver()).executeScript("window.open()");
        tabs= new ArrayList(DriverSingletone.getDriver().getWindowHandles());
        DriverSingletone.getDriver().switchTo().window(tabs.get(1));
        }

        public static void switchToFirstPage()  {
            DriverSingletone.getDriver().switchTo().window(tabs.get(0));
           // DriverSingletone.getDriver().findElement(By.xpath("//*[@id='input_401']")).click();
            //buffer=(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);


        }
        public static void switchToSecondPage(){
        DriverSingletone.getDriver().switchTo().window(tabs.get(1));
        }

}
