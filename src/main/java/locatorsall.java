import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class locatorsall {
    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        System.out.println("Static locators");
        driver.get("https://newerp.kluniversity.in/index.php");

        //academics-XPATH
        WebElement elementByx = driver.findElement(By.xpath("//*[@id=\"six\"]/div/div[2]/a")); // Adjust the text to match
        highlight(driver, elementByx);

        // aboutus-LINKTEXT
        WebElement elementByLinkText = driver.findElement(By.linkText("About Us")); // Adjust the text to match
        highlight(driver, elementByLinkText);

        //login-CSSSELECTOR
        WebElement elementBycss = driver.findElement(By.cssSelector("#mobile_bg > div:nth-child(1) > div:nth-child(1) > div > div > div > a.btn.btn-link.tcrudjax > span")); // Adjust the text to match
        highlight(driver, elementBycss);
        elementBycss.click();



        //contactus-PARTIALLINKTEXT
        WebElement elementByLinkText1 = driver.findElement(By.partialLinkText("Contact Us")); // Adjust the text to match
        highlight(driver, elementByLinkText1);


        //password-NAME
        driver.findElement(By.name("LoginForm[password]"));
        highlight(driver,   driver.findElement(By.name("LoginForm[password]")));
        driver.findElement(By.name("LoginForm[password]")).sendKeys("07-09-2004");

        //usernamelabel-CLASSNAME
        WebElement elementByt = driver.findElement(By.className("control-label")); // Adjust the text to match
        highlight(driver, elementByt);

        //captchabox-ID
        WebElement elementByi = driver.findElement(By.id("loginform-captcha")); // Adjust the text to match
        highlight(driver, elementByi);



        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        FileUtils.copyFile(file, new File("./result/image2.png"));



    }




    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid red;');", element);
    }


}
