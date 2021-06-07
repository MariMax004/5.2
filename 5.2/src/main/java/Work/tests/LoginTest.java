package Work.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    LoginPage login;

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        login = new LoginPage(driver);
        driver.get("https://mail.yandex.ru");

        login.clickGoToLogin();
        System.out.println("GotoLogin click");
        login.inputLogin("MaximovaMaria0404@yandex.ru");
        System.out.println("Login inject");
        login.clickLoginBtn();
        System.out.println("BTN click");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login.inputPasswd("zaqwer1234");
        System.out.println("Pass inject");
        login.clickLoginBtn2();
        System.out.println("BTN2 click");

        List<WebElement> mails = driver.findElements(By.xpath("//*[contains(@class, 'mail-MessageSnippet js-message-snippet toggles-svgicon-on-important toggles-svgicon-on-unread is-unread')]"));
        String str = mails.get(0).getText();
        
        System.out.println(str.split("\n")[2]);

        System.out.println();
    }
}
