package ObjectRepository;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SignInEmail {
    private WebDriver driver;
    
     @FindBy (id="ap_email")
       private WebElement EmailOrPhonenumber;
        
      @FindBy (id="continue")
         private WebElement btncontinue;
      
      public SignInEmail(WebDriver driver) { //driver.
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
      
      public void getEmailId(String EnterEmailOrPhonenumber) {     
          EmailOrPhonenumber.sendKeys(EnterEmailOrPhonenumber);
      }
      
      public Password getContinue() {
          btncontinue.click();
        return new Password(driver);
        
      }
     




}