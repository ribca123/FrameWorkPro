package base;



import ObjectRepository.ProductSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import ObjectRepository.AddingCart;
import ObjectRepository.HomePage;
import ObjectRepository.Password;
import ObjectRepository.ProductClick;
import ObjectRepository.SignInEmail;
import test.commonMethods;
import test.reporting;
public class homeModuleTest extends init {
WebDriver driver;
private static Logger logger=LogManager.getLogger(homeModuleTest.class);
@BeforeTest(alwaysRun=true)
public void browser() throws IOException {
    driver=BrowserIntialization();
    driver.get(prop.getProperty("Url"));
    logger.info("browser is open");
}
    
    
    @Test
    public void ProductSelection() throws IOException {
        logger.info("Strating the E-commerce scenarion test.");
        
        HomePage homepage = new HomePage(driver);
        homepage.PageValidation();
        commonMethods Exel = new commonMethods();
        ArrayList<String> ForExel =Exel.exel("Details", "ProductSelection");
        SignInEmail singinMail=homepage.signlink();
        singinMail.getEmailId(ForExel.get(1));
        Password password=singinMail.getContinue();
        password.getPassword(ForExel.get(2));
        password.ClickSignin();
        homepage.SearchBox(ForExel.get(3));
        ProductSelection productSelection=homepage.SearchSymbol();
        ProductClick productClick=productSelection.ProductSelectionInfo();
        AddingCart addingCart=productClick.Quantity(ForExel.get(4));
        addingCart.AddCartValidation();
        addingCart.GetHelloSignin();
    }
    @AfterTest
    public void tearDown(){
    driver.quit();    
    }
    
}



