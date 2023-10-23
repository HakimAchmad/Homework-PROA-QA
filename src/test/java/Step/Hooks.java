package Step;

import Config.Env;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;

public class Hooks extends Env {
    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
       // ChromeOptions opt = new ChromeOptions();
        FirefoxOptions opt = new FirefoxOptions();
        opt.setHeadless(true);
        driver = new FirefoxDriver(opt);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + scenario.getName() + ".png"));
        }
        driver.quit();
    }
}
