package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ukážkový príklad Selenium WebDrive testovania,
 * program otvorí požadovanú URL a porovná element "title".
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-20
 */
public class SelWebDriver {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.seleniumhq.org/";
        String expectedTitle = "Selenium - Web Browser Automation";
        String actualTitle = "";

        // spustí chrom a vojde na definovanú URL
        driver.get(baseUrl);

        // získa skutočný titulok stránky
        actualTitle = driver.getTitle();


        // Porovná skutočný title stránkz s očakávaným
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // web driver sa zavrie
        driver.quit();
    }
}