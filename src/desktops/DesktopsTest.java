package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));

        //1.2 Click on "Show All Desktops"
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //1.3 Select Sort By Position "Name Z to A"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Mouse hover on Desktops tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 Click on "Show All Desktops"
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");

        //2.4 Select product "HP LP3065"
        clickOnElement(By.linkText("HP LP3065"));

        //2.5 Verify the text "HP LP3065"
        assertVerifyText(By.xpath("//h1[contains(text(),'HP LP3065')]"),"HP LP3065");

        // 2.6 Select Delivery Date "2022-11-30
        String year = "2022";
        String month = "November";
        String date = "30";

        //Opens the date picker
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']"));
        while (true) {

            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            //Nov 2022
            String
                    arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }

        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));

        //2.7 Enter Qty "1” using Select class.
        clickOnElement(By.xpath("//input[@id='input-quantity']"));

        //2.8 Click on "Add to Cart" button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message "Success: You have added HP LP3065 to your shopping cart!”
        //assertVerifyText(By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added HP LP3065 to your shopping cart!");

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText(""));
        //2.11 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]"),"Shopping Cart  (2.00kg)");

        //2.12 Verify the Product name "HP LP3065"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");

        //2.13 Verify the Delivery Date "2022-11-30"
        assertVerifyText(By.xpath("//small[contains(text(),'Delivery Date: 2030-11-22')]"),"Delivery Date: 2022-11-30");
        //2.14 Verify the Model "Product21"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]"),"Product 21");
        //2.15 Verify the Total "£74.73"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"£74.73");
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}









