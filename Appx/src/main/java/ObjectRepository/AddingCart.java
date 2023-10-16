package ObjectRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AddingCart {
private WebDriver driver;
private static Logger logger=LogManager.getLogger(AddingCart.class);

@FindBy(id="nav-link-accountList-nav-line-1")
private WebElement HellosinginLink;

@FindBy(xpath="//a[@id='nav-item-signout']//span")
private WebElement signout;

@FindBy(xpath="//a[@data-csa-c-content-id='sw-gtc_CONTENT']")
private WebElement unkownXpath;

@FindBy(id="nav-cart-count")
private WebElement carticon;

@FindBy(xpath="//span[@data-feature-id='delete']")
private WebElement Delete;


public AddingCart(WebDriver driver) { //driver.
    this.driver=driver;
    PageFactory.initElements(driver,this);
}




//driver.findElement(By.xpath("//a[@data-csa-c-content-id='sw-gtc_CONTENT']")).click();

public void Actions(WebElement Signin) {
      Actions a = new Actions(driver);
      a.moveToElement(Signin).build().perform();
}

public void GetHelloSignin() {
      Actions(HellosinginLink);
      signout.click();
    
}
public void AddCartValidation() {
    unkownXpath.click();
String expected    =carticon.getText();
String Actuval="3";





 if(expected.equalsIgnoreCase(Actuval)) {
      logger.info("product add to the cart successfully");
  }else {
      logger.error("failed to add to the product to the cart.");
  }
  

}







}

