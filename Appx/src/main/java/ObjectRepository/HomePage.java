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

public class HomePage {

     private WebDriver driver;

    private static Logger logger=LogManager.getLogger(HomePage.class);

    @FindBy(id="nav-link-accountList-nav-line-1")

    private WebElement HellosinginLink;

    

     @FindBy(xpath="//div[@id='nav-flyout-ya-signin']//a//span")

     private WebElement linksingin;

    

    @FindBy(id="twotabsearchtextbox")

    private WebElement textSearchBox;

    

    @FindBy(id="nav-search-submit-button")

    private WebElement searchSymbol;

    

    private String PageValidationText ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

    

    public HomePage(WebDriver driver) {

        this.driver=driver;

        PageFactory.initElements(driver,this);

    }

public SignInEmail signlink() { //SignInEmail sn=HomePage.signlink() ;

    actions(HellosinginLink);

    linksingin.click();

return new SignInEmail(driver);

}

public void actions(WebElement helloiSignin) {

    Actions a= new Actions(driver);

    a.moveToElement( helloiSignin).build().perform();

}
public void SearchBox(String EnterProduct) {

    textSearchBox.sendKeys(EnterProduct);

}

public void PageValidation() {

    String title=driver.getTitle();

    Assert.assertEquals(PageValidationText,title ,"Window title is not as expected. Actuval title:"+title );

    

    

}

public ProductSelection SearchSymbol() {

    searchSymbol.click();

    return new ProductSelection(driver);

}

}

