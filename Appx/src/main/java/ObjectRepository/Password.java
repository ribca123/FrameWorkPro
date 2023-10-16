package ObjectRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Password {
private WebDriver driver;
private static Logger logger=LogManager.getLogger(Password.class);
      @FindBy(id="ap_password")
        private WebElement textPassword;





       @FindBy (id="signInSubmit")
       private  WebElement btnsignInSubmit;
       
       public Password(WebDriver driver) { //driver.
         this.driver = driver;
         PageFactory.initElements(driver,this);
        }
        
       public void getPassword(String EnterPassword) {
            textPassword.sendKeys(EnterPassword);
       }
       
       public HomePage ClickSignin() {
          
            btnsignInSubmit.click();
         logger.info("you sucessfully signed to your accout.");
            return new HomePage(driver);
            
           
       }
       
}