package ObjectRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ProductClick {

private WebDriver driver;

private static Logger logger=LogManager.getLogger(ProductClick.class);

@FindBy(xpath = "//div[@data-component-type='s-search-result']")



    private WebElement ProductSubmit;

    

    @FindBy(id="quantity")

    private WebElement QuantityDropdown;

    

    @FindBy (id="add-to-cart-button")

    private WebElement btnAddToCart;

    

    public ProductClick(WebDriver driver) {



        this.driver = driver;



        PageFactory.initElements(driver, this);



    }

    public void SwichToMainWindow() {

        Set <String> Windows= driver.getWindowHandles();

        Iterator <String> WindowName=Windows.iterator();

        String mainWindow=WindowName.next();

        String SubWindow=WindowName.next();

        driver.switchTo().window(mainWindow);

        logger.info("sucessfully swich to main window.WindowName: "+mainWindow);

    }



public Select Select2() {

     Select s = new Select(QuantityDropdown);

     return s;

}

public void AddToCart() {



    btnAddToCart.click();



}

public AddingCart Quantity(String ProductQuantity) {

    Select s=Select2();

    if(s.getOptions().size()>=3) {

        s.selectByVisibleText( ProductQuantity);

        logger.info("selected the product quantity '3'");

        String selectedoptions =s.getFirstSelectedOption().getText();

        Assert.assertEquals(selectedoptions, "3", "Selected value does not match the expected value '3'.");

    

       AddToCart();

  

    }

    else {

    logger.info("we failed to select the product and we swiched to another product.");

    SwichToMainWindow();

    ProductSelection productSelection = new ProductSelection(driver);

    

    

    productSelection.ProductSelectionInfo();

}

    return new AddingCart(driver);

}    

   

}




