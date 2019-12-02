package ru.pirateway.sb.api.service;

import org.openqa.selenium.WebDriver;

/**
 * @author Roman Kravchenko
 */

public interface IConnectService {

    void getConnect();

    String getHtml(WebDriver webDriver);

    void refreshPage(WebDriver webDriver);

    WebDriver getDriver();

}
