package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu (String menu){
        if(menu=="Desktops"){
            //find Desktops tab and click
            mouseHoverToElement(By.linkText("Desktops"));
            clickOnElement(By.linkText("Show All Desktops"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Desktops",title);

        } else if (menu == "Laptops & Notebooks") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            clickOnElement(By.linkText("Show All Laptops & Notebooks"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Laptops & Notebooks",title);

        } else if (menu == "Components") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
            clickOnElement(By.linkText("Show All Components"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Components",title);

        } else if (menu == "Tablets") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]"));
            clickOnElement(By.linkText("Tablets"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Tablets",title);

        } else if (menu == "Software") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]"));
            clickOnElement(By.linkText("Software"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Software",title);

        } else if (menu == "Phones & PDAs") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]"));
            clickOnElement(By.linkText("Phones & PDAs"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Phones & PDAs",title);

        } else if (menu == "Cameras") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]"));
            clickOnElement(By.linkText("Cameras"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "Cameras",title);

        } else if (menu == "MP3 Players") {
            //find Laptops & Notebooks tab, hover and click on 'Show All Laptops & Notebooks"
            mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[8]/a[1]"));
            clickOnElement(By.linkText("Show All MP3 Players"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched:", "MP3 Players",title);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }
    //1.2 / 1.3 Click on page and verify navigation
    @Test
    public void verifyPageNavigation() {
        selectMenu("Desktops");
        selectMenu("Laptops & Notebooks");
        selectMenu("Components");
        selectMenu("Tablets");
        selectMenu("Software");
        selectMenu("Phones & PDAs");
        selectMenu("Cameras");
        selectMenu("MP3 Players");
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        selectMenu("Desktops");
    }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
            selectMenu("Laptops & Notebooks");
        }
        @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
            selectMenu("Components");

    }

    @After
    public void teardown(){
        closeBrowser();
    }
}









