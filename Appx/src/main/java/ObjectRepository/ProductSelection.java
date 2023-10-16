package ObjectRepository;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ProductSelection {

     private WebDriver driver;

    private static Logger logger=LogManager.getLogger(ProductSelection.class);

    @FindBy (xpath="//div[@data-component-type='s-search-result']")

    private  List <WebElement> groupOfProducts;

     public ProductSelection(WebDriver driver) { //driver.

         this.driver=driver;

         PageFactory.initElements(driver,this);

     }



    public void SwitchToSubWindow() {

        Set <String> Windows= driver.getWindowHandles();

        Iterator <String> WindowName=Windows.iterator();

        String mainWindow=WindowName.next();

        String SubWindow=WindowName.next();

        driver.switchTo().window(SubWindow);

    }

    public ProductClick ProductSelectionInfo() {

        if(groupOfProducts.size()>=2) {

            for(int i=1;i<groupOfProducts.size();i++) {

            WebElement SelectedProduct= groupOfProducts.get(i);

            String SelectedProductName=SelectedProduct.getText();

            SelectedProduct.click();

            logger.info("we clicked product details: /n"+SelectedProductName);

            SwitchToSubWindow();

          logger.info("switch to sub window.");

            }

        }

        return new ProductClick(driver);

    }

    

    

   



}
















