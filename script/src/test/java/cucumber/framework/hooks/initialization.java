package cucumber.framework.hooks;

import cucumber.api.java.Before;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by rakeshnbr on 05/12/2016.
 */
public class initialization extends PageObject{
    public static String downLoadDirectory;
    public static ScenarioHook scenarioHook;
    public static boolean browserTest = false;
    EnvironmentVariables environmentVariables;


    @Managed
    public WebDriver webdriver = getDriver();

    @Before("~@NoBrowser")
    public void prepareTest() throws Exception {
        try{
            browserTest = true;
          /*  if (!PropertyHelper.getProperty("webdriver.driver").equalsIgnoreCase("appium")) {
                getDriver().manage().window().maximize();
                getDriver().manage().window().setSize(new Dimension(1920,1080));
            }*/
        }catch (Exception e){
            throw new Exception("ERROR: While Preparing for the Test");
        }
    }

    public static byte[] extractBytes (String ImageName) throws IOException {
        byte[] bytes = new byte[0];
        try {
            RandomAccessFile f = new RandomAccessFile(ImageName, "r");
            bytes = new byte[(int) f.length()];
            f.read(bytes);
            f.close();
            return bytes;
        }catch (Exception e){
            return bytes;
        }
    }
}
