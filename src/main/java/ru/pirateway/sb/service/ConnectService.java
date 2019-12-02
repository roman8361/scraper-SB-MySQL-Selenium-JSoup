package ru.pirateway.sb.service;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import ru.pirateway.sb.api.service.IConnectService;

/**
 * @author Roman Kravchenko
 */

@Component
public class ConnectService implements IConnectService {

    private WebDriver webDriver;

    @SneakyThrows
    public void getConnect() {
        System.setProperty("webdriver.chrome.driver", "D:\\###PROJECT\\JAVA\\scraper\\16.11\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://positivebet.com/ru/user/login");
        webDriver.findElement(By.id("UserLogin_username")).sendKeys("Ezjikfrom1");
        webDriver.findElement(By.id("UserLogin_password")).sendKeys("Fromvegas1");
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[5]/button")).click();
        Thread.sleep(500);
        webDriver.navigate().to("https://positivebet.com/ru/bets/index");
    }

    @Override
    public String getHtml(WebDriver webDriver) {
        return webDriver.getPageSource();
    }

    @Override
    public void refreshPage( WebDriver webDriver) {
        webDriver.navigate().refresh();
    }

    @Override
    public WebDriver getDriver() {
        return webDriver;
    }

}
