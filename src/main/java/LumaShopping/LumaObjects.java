package LumaShopping;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LumaObjects
{
    WebDriver driver;
    WebDriverWait wait;
    WebDriverManager manage;
    WebElement element;
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(Selectors.url);
    }
    public void createAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an Account")));
        driver.findElement(By.linkText("Create an Account")).click();
        //Personal Information
        driver.findElement(By.cssSelector("#firstname")).sendKeys(Selectors.firstName);
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(Selectors.lastName);
        driver.findElement(By.cssSelector("#email_address")).sendKeys(Selectors.email);
        driver.findElement(By.cssSelector("#password")).sendKeys(Selectors.password);
        driver.findElement(By.cssSelector("#password-confirmation")).sendKeys(Selectors.passwordConfirm);
        driver.findElement(By.cssSelector("button[title=\"Create an Account\"]")).click();
    }
    public void confirmLoginSuccess(String element, String fetchedText){
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
        WebElement verifiableElement =  driver.findElement(By.cssSelector(element));
        String verifiableText = verifiableElement.getText();
        Assert.assertEquals(fetchedText, verifiableText);

    }
    public void logout(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action=\"customer-menu-toggle\"]")));
        driver.findElement(By.cssSelector("button[data-action=\"customer-menu-toggle\"]")).click();
        driver.findElement(By.linkText("Sign Out")).click();
    }
    public void signIn(){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys(Selectors.email);
        driver.findElement(By.cssSelector("#pass")).sendKeys(Selectors.password);
        driver.findElement(By.cssSelector("#send2")).click();
    }
    public void makeOrderFromMaleCategory(){
        
    }
    public void tearDown(){
        driver.quit();
    }
    public static void main(String [] argh){
        LumaObjects luma = new LumaObjects();
        luma.setUp();
        luma.createAccount();
        luma.confirmLoginSuccess(Selectors.LocateElement,Selectors.fetchedText);
        luma.logout();
        luma.signIn();
        System.out.println(Selectors.password);
        //luma.tearDown();
    }


}
