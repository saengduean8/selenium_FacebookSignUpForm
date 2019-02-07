import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookSignUp {

    WebDriver driver;

    public static void main(String[] args){

        FacebookSignUp signUp = new FacebookSignUp();
        signUp.invokeBrowser();
        signUp.signUp();


    }

    public void invokeBrowser(){

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\happy\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            String url = "http://www.facebook.com";
            driver.get(url);

            //driver.close();

    }

    public void signUp(){
        try {
            driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Em");
            driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Janta");
            driver.findElement(By.cssSelector("input[name=reg_email__]")).sendKeys("test888@gmail.com");
            driver.findElement(By.cssSelector("input[name=reg_passwd__]")).sendKeys("Saeng2526#");
            driver.findElement(By.cssSelector("input[name=reg_email_confirmation__]")).sendKeys("test888@gmail.com");

            WebElement monthElement = driver.findElement(By.name("birthday_month"));
            Select dropDown = new Select(monthElement);
            dropDown.selectByValue("2");

            WebElement dayElement = driver.findElement(By.name("birthday_day"));
            dropDown = new Select(dayElement);
            dropDown.selectByValue("4");

            WebElement yearElement = driver.findElement(By.name("birthday_year"));
            dropDown = new Select(yearElement);
            dropDown.selectByValue("1999");

            WebElement female = driver.findElement(By.cssSelector("input[name=sex]"));

            Thread.sleep(2000);

            if (!female.isSelected()) {
                female.click();
            }

            driver.findElement(By.name("websubmit")).click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
