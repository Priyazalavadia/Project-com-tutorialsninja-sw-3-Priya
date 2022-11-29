package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Select Menu Method
    public void selectMyAccountOptions(String option) {

        if (option == "Register") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        } else if (option == "Login") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Login')]"));

        } else if (option == "Logout") {
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[normalize-space()='Logout']"));

        } else {
            System.out.println("Please enter valid name ");
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        selectMyAccountOptions("Register");
        //Verify the Register Account
        assertVerifyText(By.xpath("//h1[contains(text(),'Register Account')]"),"Register Account");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        selectMyAccountOptions("Login");
        //Verify the Login msg
        assertVerifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 & 3.2  Click and navigate to register page
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "Humpty");
        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Dumpty");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "humpty4@gmail.com");
        // Enter Telephone
        sendTextToElement(By.name("telephone"), "01234567890");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "dumpty123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "dumpty123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        //assertVerifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));

        //3.16 Verify the text “Account Logout”
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        //3.17 Click on Continue
        clickOnElement(By.linkText("Continue"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // 4.1 & 4.2 click & navigate to login page
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "humpty4@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.id("input-password"), "dumpty123");

        //4.6 click on login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        assertVerifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//h2[contains(text(),'My Account')]"));

        //4.9 Click on Logout
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));

        //4.10 Verify the text “Account Logout
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        //4.11 Click on Continue Button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));



    }
}
