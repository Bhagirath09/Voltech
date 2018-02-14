package Voltech;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuite extends BaseTest {

    static ExtentReports report = new ExtentReports("target/Reports/TestNG-Extent-report.html");
    static ExtentTest logger;
    String methodName;

    @Test (priority = 0)
    public void naviageToHomePage(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //navigated to homepage
        logger.log(LogStatus.PASS, "Home Page is loaded");

        homePage.getTextLatestNews();
        //Assert Latest News section
        Assert.assertEquals(homePage.latestNews, "LATEST NEWS", "Latest News section is not displayed on Home Page");
        logger.log(LogStatus.PASS, "Latest News section is displayed on Home Page");

    }

@Test (priority = 1)
    public void navigateToAboutPageAndGetPageNameFromH1Tag(){
    methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    logger = report.startTest(methodName);

        //navigate to About Page
        homePage.clickAboutPage();
        logger.log(LogStatus.PASS, "Clicking About Page");

        //getting text of the page from H1 Tag
        String aboutPage = homePage.getNameFromH1Tag();
    logger.log(LogStatus.PASS, "Getting text of the page from its H1 Tag");

        //Assert that page name is About Page
       Assert.assertEquals(aboutPage, "About", "Correct name is not correct in H1 Tag");
    logger.log(LogStatus.PASS, "Correct name is correct in H1 Tag i.e. About page");

    }

@Test (priority = 2)
    public void navigateToServicesPageAndGetPageNameFromH1Tag(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //navigate to About Page
        homePage.clickServicesPage();
        logger.log(LogStatus.PASS, "Clicking Services Page");

        //getting text of the page from H1 Tag
        String servicesPage = homePage.getNameFromH1Tag();
        System.out.println(servicesPage);
        logger.log(LogStatus.PASS, "Getting text of the services page from its H1 Tag");

        //Assert that page name is About Page
        Assert.assertEquals(servicesPage, "Services", "Correct name is not correct in H1 Tag");
        logger.log(LogStatus.PASS, "Correct name is correct in H1 Tag i.e. Services");

    }

    @Test (priority = 3)
    public void navigateToWorkPageAndGetPageNameFromH1Tag(){
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //navigate to Work Page
        homePage.clickWorkPage();
        logger.log(LogStatus.PASS, "Clicking Work Page");

        //getting text of the page from H1 Tag
        String workPage = homePage.getNameFromH1Tag();
        System.out.println(workPage);
        logger.log(LogStatus.PASS, "Getting text of the work page from its H1 Tag");

        //Assert that page name is About Page
        Assert.assertEquals(workPage, "Work", "Correct name is not correct in H1 Tag");
        logger.log(LogStatus.PASS, "Correct name is correct in H1 Tag i.e. Work");

    }

    @Test (priority = 4)
    public void navigateToContactPageAndOutputHowManyValtechOfficesInTotal(){

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //click contact page
        homePage.clickContactPage();
        logger.log(LogStatus.PASS, "contact page is cllcked");

        //Collects all office element
        List<WebElement> officesElement=driver.findElements(By.xpath("//*[@id=\"contactbox\"]/div/div/ul/li"));
        logger.log(LogStatus.PASS, "collected all office elements");

        int office=0;
        System.out.println("Valtech offices are present in following countries: ");
        logger.log(LogStatus.PASS, "Printing offices present in various countries");
        //iterate each office element and get name
        for (WebElement element : officesElement) {
            System.out.println(element.getText());
            office++;
        }
        System.out.println("Total number of Valtech Offices :"+office);
        logger.log(LogStatus.PASS, "Total number of Valtech offices is 39");
    }
    }



