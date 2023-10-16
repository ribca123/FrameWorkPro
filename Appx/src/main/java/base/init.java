package base;





import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class init {
    public WebDriver driver; //WebDriver driver = new ChromeDriver(); //implements
    public Properties prop; //Properties prop = new Properties();
    
public WebDriver BrowserIntialization() throws IOException {
prop = new Properties();
   
    String filepath = System.getProperty("user.dir")+"\\Resources\\Config.properties";
    FileInputStream file = new FileInputStream(filepath);
    prop.load(file);
    String Browser;
    Browser    =prop.getProperty("browser");
    if(Browser==null) {
     Browser=prop.getProperty("Browser");
        }
    
    if(Browser.equalsIgnoreCase("edge")) {
         driver =    new     EdgeDriver();




   }else if (Browser.equalsIgnoreCase("firefox")) {
        driver = new     FirefoxDriver();
    }else {
        driver = new     ChromeDriver();
    }
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(33));
    return driver;
}
public String screenshot(WebDriver driver, String testcasename) throws IOException {
    
    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
    FileHandler.copy(src, new File(path));
    
    return path;
}




}
