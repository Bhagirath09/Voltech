package Voltech;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Utils extends BasePage {


    public static void myClick(By by) {
        driver.findElement(by).click();
    }

    public static void myEnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //scroll page up or down (up is minus i.e. -250)
    public static void scrollPage(int x, int y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }
}
