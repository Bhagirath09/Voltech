package PageObjects;

import Voltech.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Utils {

    private By _latestNews = By.xpath("//main[@id=\"container\"]/div[2]/div[3]/div/header/h2");
    private By _aboutPage = By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[1]/a/span");
    private By _servicesPage = By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[3]/a/span");
    private By _workPage = By.xpath("//*[@id=\"navigationMenuWrapper\"]/div/ul/li[2]/a/span");
    private By _contactPageLink = By.xpath("//a[@id='contacticon']/div/div/div/i");

    public String latestNews, aboutPage, servicesPage, workPage;

    public void getTextLatestNews(){

        latestNews = driver.findElement(_latestNews).getText();
    }

    public void clickAboutPage(){myClick(_aboutPage);}
    public void clickServicesPage(){myClick(_servicesPage);}
    public void clickWorkPage(){myClick(_workPage);}
    public void clickContactPage(){myClick(_contactPageLink);}

    public String getNameFromH1Tag(){

         String pageName = driver.findElement(By.tagName("H1")).getText();

         return pageName;

    }

}
