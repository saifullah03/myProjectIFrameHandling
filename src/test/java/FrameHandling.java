import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FrameHandling {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        ChromeOptions opt = new ChromeOptions();

        driver = new RemoteWebDriver(new URL("http://3.145.197.131:4444"),opt);
        driver.get("http://demo.automationtesting.in/Frames.html");
        String s = driver.findElement(By.xpath("//a[@href='#Multiple']")).getText();
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        System.out.println(s);
        // Parent Iframe (Nested iframes)
        driver.switchTo().frame(1);
        String si = driver.findElement(By.cssSelector("div[class='iframe-container'] h5")).getText();
        //driver.findElement(By.xpath("//iframe[@id='singleframe']")).getText();
        System.out.println(si);

        WebElement web = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(web);
        String ns = driver.findElement(By.cssSelector("div[class='container'] h5")).getText();
        System.out.println(ns);
        driver.findElement(By.tagName("input")).sendKeys("Hello world");

        // Parent Iframe (Nested iframes)
        driver.switchTo().parentFrame();
        String sis = driver.findElement(By.cssSelector("div[class='iframe-container'] h5")).getText();
        System.out.println(sis);

        //Main webPage
        driver.switchTo().defaultContent();
        String mainwebPageElement = driver.findElement(By.xpath("//a[@href='#Multiple']")).getText();
        System.out.println(mainwebPageElement);
        System.out.println()


    }
}
