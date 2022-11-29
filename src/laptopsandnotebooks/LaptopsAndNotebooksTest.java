package laptopsandnotebooks;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);


    }
    @Test
    public void verifyProductsPriceDisplayHighToLowsuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        assertVerifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"),"Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{

        Actions actions = new Actions(driver);
       //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));

        //2.5 Verify the text “MacBook”
        assertVerifyText(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”

        //2.8 Click on link shopping cart in success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the shopping cart
        assertVerifyText(By.xpath("//html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]"),"Shopping Cart  (0.00kg)");

        //2.10 Verify the Product name "MacBook"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");

        //2.11 Change Quantity "2"
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        actions.sendKeys(Keys.BACK_SPACE).perform();
        //actions.sendKeys(Keys.DELETE).perform();
        actions.sendKeys("2").perform();

        //2.12 Click on update tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        assertVerifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"),"Success: You have modified your shopping cart!\n" +
                "×");

        //2.14 Verify the Total £737.45
        //assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"), "£737.45");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text "Checkout"
        assertVerifyText(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");

        //2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.name("firstname"),"Herry");
        sendTextToElement(By.name("lastname"),"Patel");
        sendTextToElement(By.id("input-payment-email"),"herrypatel@gmail.com");
        sendTextToElement(By.name("telephone"),"01234567890");
        sendTextToElement(By.name("address_1"),"101 Lalkilla");
        sendTextToElement(By.name("city"),"London");
        sendTextToElement(By.name("postcode"),"HA8 6AB");
        clickOnElement(By.id("input-payment-country"));
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        clickOnElement(By.id("input-payment-zone"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@class='form-control']"),"Thank You");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!
        assertVerifyText(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"),"Warning: No Payment options are available. Please contact us for assistance!");

    }
}
