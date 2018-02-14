package Voltech;

import PageObjects.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import static Voltech.TestSuite.logger;
import static Voltech.TestSuite.report;

public class BaseTest extends Utils {

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProp loadProp = new LoadProp();
    HomePage homePage = new HomePage();

    static String imagePath;

    @BeforeMethod
    public void openBrowserAndEnterURL(){

        //open browser
        browserSelector.openBrowser(loadProp.getExcelProperty(0,1,1));

        //Enter URL navigate to homepage
        driver.get(loadProp.getExcelProperty(0,3,1));
    }

    @AfterMethod
    public static void tearDown(ITestResult result)
    {
        logger.log(LogStatus.INFO,  "Executing tearDown Method");

        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {

            logger.log(LogStatus.FAIL,  "Test case failed");

            try
            {
                // Create reference of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                imagePath = "target/ScreenShots/"+result.getName()+".png";

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File(imagePath));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
            logger.log(LogStatus.FAIL,  logger.addScreenCapture(imagePath));
            report.endTest(logger);
            report.flush();
        }

        // close browser
        driver.close();
        logger.log(LogStatus.INFO,  "Browser closed");
        report.endTest(logger);
        report.flush();
    }
}
